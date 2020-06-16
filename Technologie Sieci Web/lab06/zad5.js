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
    return result;
}


const poKolei = async(n, funTab, cb) => 
{
    
    let result = n
    for(let i = 0; i < funTab.length; i++)
    {
        result = await funTab[i](result)
    }
    result = await cb(result);

    console.log(result);
    
}
var funTab = [fun1, fun2]
poKolei(2,funTab, cb)

