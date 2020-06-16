const toggle = event => {
    var pro = document.getElementById("pro-plan");
    var basic = document.getElementById("basic-plan");
    var proPricing = pro.getElementsByClassName("pricing")[0].innerHTML;
    var basicPricing = basic.getElementsByClassName("pricing")[0].innerHTML;
    var proPricingList = proPricing.split(" ");
    var basicPricingList = basicPricing.split(" ");
    if (proPricingList[proPricingList.length - 1] == "miesiąc") {
      proPricingList[proPricingList.length - 1] = "rok";
      proPricingList[0] = parseInt(proPricingList[0]) * 10;
    } else {
      proPricingList[proPricingList.length - 1] = "miesiąc";
      proPricingList[0] = parseInt(proPricingList[0]) / 10;
    }
    if (basicPricingList[basicPricingList.length - 1] == "miesiąc") {
      basicPricingList[basicPricingList.length - 1] = "rok";
      basicPricingList[0] = parseInt(basicPricingList[0]) * 10;
    } else {
      basicPricingList[basicPricingList.length - 1] = "miesiąc";
      basicPricingList[0] = parseInt(basicPricingList[0]) / 10;
    }
    pro.getElementsByClassName("pricing")[0].innerHTML = proPricingList.join(" ");
    basic.getElementsByClassName("pricing")[0].innerHTML = basicPricingList.join(
      " "
    );
  };