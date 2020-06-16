async function fun1(number) {
    let result = number*2
    return result;
}

async function fun2(number) {
    let result = number+3
    return result;
}

async function cb(number) {
    let result = number*number
    console.log(number*number);
    return result;
}


const poKolei = (n, fun1, fun2, cb) => 
{
    fun1(n).then(function(value) {
        fun2(value).then(function(value) {
            cb(value);
        });;
    });
}
poKolei(1,fun1, fun2, cb)
