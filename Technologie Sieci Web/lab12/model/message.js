const mongoose = require("../mongoose");
const Schema = mongoose.Schema;

const messageSchema = new Schema({
    autor: {
        type: String,
        required: true
    },
    roomName: {
        type: String,
        required: true
    },
    message: {
        type: String,
        required: true
    }
});


const Message = mongoose.model("Message", messageSchema);

// mały „postprocessing” błędów mongoosowych
Message.processErrors = (err) => {
    let msg = {};
    for (let key in err.errors) {
        msg[key] = err.errors[key].message;
    }
    return msg;
};

module.exports = Message;