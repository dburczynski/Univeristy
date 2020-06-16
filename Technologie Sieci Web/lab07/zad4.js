const poKolei4 = (funTab, fcb) => {
    wynik = [];
    
    for(i=0; i < funTab.length; i++) {
        if(i == 0)
            wynik = funTab[i](callback);
        else
            wynik = funTab[i](wynik[0],wynik[1],callback);
    }
    
    fcb(wynik);
}

const callback = () => {
    return 0;
}


const tab = [
    (cb) => {
        min = 0;
        max = 3;
        if(Math.floor(Math.random()* (max - min))+min > 1)        
            return ["blad",cb()];
        else
            return [null, cb()];
    },
    (err,x,cb) => {
        if(err == null)
            return [null,x+5];
        else
            return [err,cb()];
    },
    (err,x,cb) => {
        if(err == null)
            return [null,x*2];
        else 
            return [err,cb()];
    }];

const f = (wynik) => {
    console.log("Blad: "+wynik[0]+", wartosc: "+wynik[1]);
}

poKolei4(tab,f);