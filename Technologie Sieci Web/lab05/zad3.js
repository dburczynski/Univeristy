var item = {
    tekst: 'Ala i As poszli w las',
    nbsp: function() {
        letters = ['a', 'i', 'o', 'u', 'w', 'z'];
        splitted = this.tekst.split(" ");
        for (i = 0; i < splitted.length; i++) {
            if(letters.includes(splitted[i])) {
                splitted[i] += "&nbsp;";
            }
            else {
                splitted[i] += " ";
            }
        }
        return splitted.join("");
    }
};

console.log(item.nbsp());
