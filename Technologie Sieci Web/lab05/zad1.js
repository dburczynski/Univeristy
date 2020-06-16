const telefon = (tab) => {
    var teleNum = "+48 ";
    var counter = 1;
    for (i = 0; i < tab.length; i++) {
        if (counter === 4) {
            teleNum += "-";
            counter = 1;
        }
        teleNum += tab[i].toString();
        counter++
    }
    return teleNum;
}

console.log(telefon([3,2,4,4,3,3,9,8,1]))