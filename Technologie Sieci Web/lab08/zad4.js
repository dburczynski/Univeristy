const zad4 = () => {
    var pro = document.getElementById("pro-plan");
    var basic = document.getElementById("basic-plan");
    var proVal = pro.getElementsByClassName("storage-amount")[0].innerHTML;
    var basicVal = basic.getElementsByClassName("storage-amount")[0].innerHTML;
    proVal = parseInt(proVal) * 1.5;
    basicVal = parseInt(basicVal) * 1.25;
    pro.getElementsByClassName("storage-amount")[0].innerHTML = proVal;
    basic.getElementsByClassName("storage-amount")[0].innerHTML = basicVal;
  };