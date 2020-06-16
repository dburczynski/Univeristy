const poKolei = (funTab, fcb) => {
    funTab.forEach(e => {
        e(callback);
    });
    fcb();
}

const callback = (x) => {
    console.log("callback "+x);
}

const tab = [(cb) => {cb(1);}, (cb) => {cb(2);}, (cb) => {cb(3);}]

const f = () => {
    console.log("fcb");
}

poKolei(tab,f);