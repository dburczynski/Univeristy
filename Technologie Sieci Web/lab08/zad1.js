const zad1 = () => {
    var list = document
      .getElementById("pro-plan")
      .getElementsByClassName("card-body")[0]
      .getElementsByTagName("ul")[0];
    var element = document.createElement("li");
    element.appendChild(document.createTextNode("Wsparcie telefoniczne 24/7"));
    list.appendChild(element);
  };