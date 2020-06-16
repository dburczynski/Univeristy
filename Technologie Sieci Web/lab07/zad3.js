const poKolei3 = (funTab, fcb) => {
    wynik = 0;
    
    for(i=0; i < funTab.length; i++) {
        if(i == 0)
            wynik += funTab[i](callback);
        else
            wynik += funTab[i](wynik,callback);
    }
    
    fcb(wynik);
}

const callback = () => {
    return 0;
}


const tab = [
    (cb) => {
            return cb();
    },
    (x,cb) => {
        if((x%2) == 1)
            return 5;
        else
            return cb();
    },
    (x,cb) => {
        if ((x%2) == 0)
            return 100;
        else 
            return cb();
    }];

const f = (wynik) => {
    console.log(wynik);
}

poKolei3(tab,f);