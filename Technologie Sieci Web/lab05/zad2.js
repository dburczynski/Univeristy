const odwarcanie = (napis) => {

    var words = napis.split(" ")
    var flippedWords = []

    for (i = 0; i < words.length; i++) {
        if (words[i].length > 4) {
            if((words[i].charCodeAt(words[i].length-1) >= 65 
                && words[i].charCodeAt(words[i].length-1) <= 90) ||
                (words[i].charCodeAt(words[i].length-1) >= 97
                && words[i].charCodeAt(words[i].length-1) <= 122)) {
                    var newWord = words[i].split("");
                    newWord = newWord.reverse();
                    newWord = newWord.join("");
                    
                    flippedWords.push(newWord)
            }
            else {
                flippedWords.push(words[i]);
            }
        }
     
        else {
            flippedWords.push(words[i]);
        }
    }
        
    var string = "";
    for(i = 0; i < flippedWords.length; i++) {
        string += flippedWords[i]+" ";
    }
    return string;
}

console.log(odwarcanie("Dzik jest dziki, dzik jest zły. Dzik ma bardzo ostre kły."));
