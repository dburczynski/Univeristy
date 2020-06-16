let szablon = { 
  html:'<table border="{border}">' +
  '  <tr><td>{first}</td><td>{last}</td></tr>' +
  '</table>',
    podstaw: function(dane) {
        var keyNames =  Object.keys(dane);
        
        for (i = 0; i < keyNames.length;i++) {
            console.log(keyNames[i]);
            if(this.html.includes("{"+keyNames[i]+"}")) {
                this.html = this.html.replace("{"+keyNames[i]+"}", dane[keyNames[i]])
            }
            
        }
        return this.html;
    }
}

  
  let dane = {
    first: "Jan",
    last:  "Kowalski",
    pesel: "97042176329"
};

console.log(szablon.podstaw(dane));
