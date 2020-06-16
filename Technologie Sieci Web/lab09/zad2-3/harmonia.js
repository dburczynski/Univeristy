
window.addEventListener("DOMContentLoaded", function () {
    var headers = document.querySelectorAll(".hd");
    headers.forEach((header) => {
      header.onclick = fold;
    });
  });
  
  function foo() {
    return false;
  }
  function hide(x) {
    var next = x.target.nextElementSibling;
    next.style.display = "none";
  }
  function show(x) {
    var next = x.target.nextElementSibling;
    next.style.display = "block";
  }
  function fold(x) {
    var next = x.target.nextElementSibling;
    if (next.style.display === "none") {
      next.style.display = "block";
    } else if (!!x.target.onmouseover && x.target.onmouseover != foo) {
      x.target.onmouseover = nic;
      x.target.onmouseout = nic;
    } else {
      next.style.display = "none";
      x.target.onmouseover = show
      x.target.onmouseout = hide;
    }
}