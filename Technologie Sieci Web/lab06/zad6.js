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


const razem = async (n,funTab, cb) => 
{
    
    let x = await Promise.all(funTab)
    console.log(await cb(x));
    return await cb(x);
}
let r1 = fun1(1);
let r2 = fun2(1);
var funTab = [r1, r2]
razem(1,funTab, cb)