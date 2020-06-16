
const groupBy = (tab, key) => {
    var list = [];
    for(i = 0; i < tab.length; i++) {
        list.push({key: key(tab[i]),
        value: tab[i]});
    }
    return list;
};

console.log(groupBy([1,2,3,4], key => key + 1 % 2))