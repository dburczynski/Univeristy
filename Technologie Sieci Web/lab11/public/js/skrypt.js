/* globals axios: false */
// https://github.com/axios/axios


window.addEventListener("DOMContentLoaded", () => {
    console.log("Tutaj znajdzie się obsługa interfejsu gry!");

    var startButton = document.querySelectorAll(".startButton")[0];
    var cookie = document.cookie;
    startButton.onclick = startGame;
    // przykład użycia biblioteki axios:
    
});


function startGame() {
    var size_data = document.getElementById("size").value;
    var dim_data = document.getElementById("dim").value;
    var max_data = document.getElementById("max").value;
    
    var jsonInput = {
        size: size_data,
        dim: dim_data,
        max: max_data
    }

    axios.post("/mmind", jsonInput)
         .then((resp) => {
            
            window.alert(resp.data["temp"]);
            var inputElements = document.getElementById("ui-input");
            deleteElement(inputElements);
         
            createElement("div",null, "ui-game","ui")
            for(var i = 0; i < parseInt(resp.data["size"],10); i++) {
                var s = createElement("SELECT", "gameselect","select-"+i.toString, "ui-game");
                for(var j = 0; j <= parseInt(resp.data["dim"],10); j++) {
                    var option = document.createElement("option");
                    option.text = j;
                    s.add(option);
                }
                createElement("br",null, "br-"+i,"ui-game");
            }

            var patchButton = createElement("button",null,"patchButton","ui-game");
            patchButton.text = "Check Code";
            patchButton.onclick = checkMove;

            console.log("Odpowiedź serwera na POST /mmind:");
             console.dir(resp.data);
         });

}


function checkMove() {
    jsonList = [];
    var selects  = document.getElementsByClassName("gameselect");
    for(var i = 0; i < selects.length; i++) {
        jsonList.push(selects[i].value);
    }
    var jsonInput = {};
    jsonInput["clientCode"] = JSON.stringify(jsonList);
    axios.patch("/mmind", jsonInput)
        .then((resp) =>  {

            if(resp.data["max"] == 0) {
                if(resp.data["bp"] == resp.data["size"]) {
                    endGame("You Win!");
                }
                window.alert("P O I N T S Black: "+resp.data["bp"]+" White: "+resp.data["wp"]);
            }
            else {
                if(resp.data["max"] > resp.data["current"] && resp.data["bp"] == resp.data["size"])
                    endGame("You Win!");
                if(resp.data["max"] == resp.data["current"] && resp.data["bp"] != resp.data["size"])
                    endGame("You Lose!");
                if(resp.data["max"] == resp.data["current"] && resp.data["bp"] == resp.data["size"])
                    endGame("You win!");
                if(resp.data["max"] > resp.data["current"] && resp.data["bp"] < resp.data["size"])
                    window.alert("P O I N T S Black: "+resp.data["bp"]+" White: "+resp.data["wp"]);
            } 
        });
}

function endGame(string) {
    var gameElements = document.getElementById("ui-game");
    deleteElement(gameElements);

    var e = createElement("p",null,"endGameText", "ui");
    var textNode = document.createTextNode(string);
    e.appendChild(textNode);

    var p = document.getElementById("ui");
    p.appendChild(e);
}



function deleteElement(e) {
    e.parentNode.removeChild(e);
}

function createElement(element, className, id, parent) {
    var e = document.createElement(element);
    if(className != null)
        e.classList.add(className);
    e.id = id;
    var p = document.getElementById(parent);
    p.appendChild(e);

    return e;
}

function createTextNode(text, parent) {
    var p = document.getElementById(parent);
    p.appendChild(document.createTextNode(text));
    p.value = text;
}