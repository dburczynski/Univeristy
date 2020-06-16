const poKolei2 = (funTab, fcb) => {
    i = 0;
    wyniki = [];
     funTab.forEach(e => {
        wyniki.push(e(i, callback));
        //console.log(i%2);
        i = i + 1;
    });
    fcb(wyniki);
}

const callback = () => {
    console.log("Warunek nie spełniony");

}


const tab = [
    (x,cb) => {
        if((x%2) == 0)
            return x+4;
        else
            cb();
    },
    (x,cb) => {
        if((x%3) == 1)
            return x-2;
        else
            cb();
    },
    (x,cb) => {
        if (x == 0)
            return 1;
        else
            cb();
    }];

const f = (wyniki_tab) => {
    wynik = 0;
    wyniki_tab.forEach(e => {
        if (e != undefined)
            wynik+=e;
    });
    console.log(wynik);
}

poKolei2(tab,f);