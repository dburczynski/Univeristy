const mongoose = require("../mongoose");
const Schema = mongoose.Schema;
const message = require("./message")

const roomSchema = new Schema({
    name: {
        type: String,
        required: true
    }
});


const Room = mongoose.model("Room", roomSchema);

// mały „postprocessing” błędów mongoosowych
Room.processErrors = (err) => {
    let msg = {};
    for (let key in err.errors) {
        msg[key] = err.errors[key].message;
    }
    return msg;
};

module.exports = Room;