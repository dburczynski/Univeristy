// konfiguracja aplikacji – dostęp przez zmienne środowiskowe
require("dotenv").config();

// jako „bazy” używamy Express.js
const express = require("express");
const app = express();
const socketio = require("socket.io");
const passportSocketIo = require("passport.socketio");
const mongoose = require("mongoose");
const Message = require("./model/message");
const Room = require("./model/room");

app.set("view engine", "ejs");
app.use("/public",express.static(__dirname + "/public"));

// wszelkie dane przesyłamy w formacie JSON
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

// machnaizm sesji – z wykorzystaniem ciasteczek
const cookieParser = require("cookie-parser");
app.use(cookieParser());
const expressSession = require("express-session");


//socket config
const MongoStore = require('connect-mongo')(expressSession);

const sessionStore = new MongoStore({mongooseConnection: mongoose.connection});

app.use(expressSession({
    secret: process.env.APP_SECRET,
    store: sessionStore,
    resave: false,
    saveUninitialized: false
}));

// do obsługi autoryzacji używamy Passport.js
const passport = require("./passport");
app.use(passport.initialize());
app.use(passport.session());

// routing aplikacji
const routes = require("./routes");
app.use(routes);
// wyłapujemy odwołania do nieobsługiwanych adresów
app.use((_, res) => {
    // Not Found
    res.sendStatus(404);
});

// Serwer HTTPS
// openssl req -x509 -nodes -days 365 -newkey rsa:1024 -out my.crt -keyout my.key
const server = require("./https")(app);
const port = process.env.port;



const io = socketio(server) 

io.use(passportSocketIo.authorize({
    key: "connect.sid",
    secret: process.env.APP_SECRET,
    store: sessionStore,
    passport: passport,
    cookieParser: cookieParser
}))

io.on("connection", (socket) => {
    console.log(`Made socket connection: ${socket.id}`);


    socket.on("create-room", (data) => {
        if(socket.request.user && socket.request.user.logged_in) {
            let modifiedData = {
                roomName: data.roomName,
                socketId: socket.id
            };
            console.log("Creating new room: "+modifiedData.roomName)
            let saveRoom = new Room( {name: modifiedData.roomName } );
            saveRoom.save();
            io.sockets.emit("create-room", modifiedData);
        }
    });
    socket.on("joinRoom", (data) => {
        if(socket.request.user && socket.request.user.logged_in) {
            console.log("Socket: "+socket.id+" is joining "+data.roomName);
            socket.join(data.roomName);
        }
    })

    socket.on("leaveRoom", (data) => {
        if(socket.request.user && socket.request.user.logged_in) {
            socket.leave(data.roomName)
        }
    })

    socket.on("send-message", (data) => {
        
        if(socket.request.user && socket.request.user.logged_in) {
            let modifiedData = {
                user: socket.request.user.username,
                message: data.message,
                roomName: data.roomName
            }
            console.log(socket.request.user+" is sending message to room "+modifiedData.roomName)
            saveMessage = new Message({autor: modifiedData.user, 
                                        roomName: modifiedData.roomName,
                                        message: modifiedData.message});
            saveMessage.save();
            console.log(socket.rooms)
            io.sockets.in(modifiedData.roomName).emit("recieve-message",modifiedData);

        }
    })
});

server.listen(port, () => {
    console.log(`Serwer działa pod adresem: https://localhost:${port}`);
});
