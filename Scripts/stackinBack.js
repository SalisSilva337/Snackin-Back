let iframe = document.querySelector(".iframe");
let homeButton = document.querySelector(".homeButton");
let menuButton = document.querySelector(".menuButton");
let ordersButton = document.querySelector(".ordersButton");
let settingsButton = document.querySelector(".settingsButton");

//Change Iframe Source
homeButton.addEventListener("click", () => {
  iframe.src = "../Pages/Iframes/home.html";
});
menuButton.addEventListener("click", () => {
  iframe.src = "../Pages/Iframes/menu.html";
});
ordersButton.addEventListener("click", () => {
  iframe.src = "../Pages/Iframes/requests.html";
});
settingsButton.addEventListener("click", () => {
  iframe.src = "../Pages/Iframes/settings.html";
});
