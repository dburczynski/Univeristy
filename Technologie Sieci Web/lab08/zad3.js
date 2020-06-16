const zad3 = () => {
    var guzik = document
      .getElementById("pro-plan")
      .getElementsByClassName("card-body")[0]
      .getElementsByTagName("button")[0];
    guzik.style.background = "red";
    guzik.style.color = "white";
    guzik.innerHTML = "Kup teraz";
  };