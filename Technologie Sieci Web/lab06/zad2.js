
const groupBy = (tab, key, fun) => {
    var list = [];
    for(i = 0; i < tab.length; i++) {
        list.push({key: key(tab[i]),
        value: fun(tab[i])});
    }
    return list;
};

console.log(groupBy([1,2,3,4], key => key + 1 % 2, fun => fun/3))