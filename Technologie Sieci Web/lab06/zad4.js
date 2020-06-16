async function fun1(number) {
    let result = number*2
    return result;
}

async function fun2(number) {
    let result = number+3
    return result;
}

async function cb(numbers) {
    let result = numbers[0]+numbers[1];
    return result;
}


const razem = async (n, fun1, fun2, cb) => 
{
    let r1 = fun1(n);
    let r2 = fun2(n);
    let x = cb([await r1, await r2]);
    console.log(x);
    return x;
}

razem(1,fun1, fun2, cb)