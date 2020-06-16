
const socket = io.connect("https://localhost:3000/");

var currentChat = ""
window.addEventListener('DOMContentLoaded', (event) => {
    console.log('DOM fully loaded and parsed');
    var create_room_input = document.getElementById("room-name-input");
    var create_room_button = document.getElementById("btn-create-room");
    var chatBox = document.getElementById("chat-box");
    
    create_room_button.addEventListener( "click", () => {
        socket.emit("create-room", {
            roomName: create_room_input.value
        })
    });
    
    // Listen for events
    socket.on("create-room", (data) => {
        if(document.getElementById(data.roomName) == null) {
            var lobby = document.getElementById("lobby")
            lobby.innerHTML+="<button id=\""+data.roomName+"\" onClick=\"joinRoom(this.id)\">"+data.roomName+"</button>";
            lobby.innerHTML+="<br>";
        }
    })
    socket.on("recieve-message", (data) => {
        console.log("receiveing");
        chatBox.innerHTML+="<p class=\"whiteText\"><strong>"+data.user+"</strong>: "+data.message+"</p>";    
    }) 
    
});



function joinRoom(id) {
    //alert(id);
    //socket.emit("joinRoom", {
    //    roomName: id
    //})
    socket.emit("joinRoom", {
        roomName: id
    })
    currentChat = id;
    document.getElementById("chat-box").innerHTML += "";
    
}

function send() {
    if(currentChat != "")
    socket.emit("send-message", {
        message: document.getElementById("chat-input-field").value,
        roomName: currentChat
    })
}