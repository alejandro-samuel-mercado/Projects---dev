// Control manual del menú para evitar el delay de Bootstrap
const toggler = document.getElementById("navbar-toggler");
const navbar = document.getElementById("navbarNav");

toggler.addEventListener("click", function () {
  if (navbar.style.right === "0px") {
    navbar.style.right = "-250px";
  } else {
    navbar.style.right = "0px";
  }
});
