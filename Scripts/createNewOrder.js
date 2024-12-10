let spanSelectedButton = document.querySelector("#spanSelectedButton");
let buttonsPlaces = document.querySelectorAll(".buttonsLocal");

buttonsPlaces.forEach((btn) => {
  btn.addEventListener("click", () => {
    console.log(btn.value);
    spanSelectedButton.textContent = "Selecionado: " + btn.value;
  });
});

//Client Data Part
let inputsClientData = document.querySelectorAll(".inputsClientData");
let selectPayment = document.querySelector(".selectPayment");

inputsClientData.forEach((input) => {
  input.addEventListener("change", () => {
    if (input.value == "") {
      input.classList.add("emptyInput");
      input.classList.remove("nonEmptyInput");
    } else if (input.value.trimStart() !== input.value) {
      input.classList.add("emptyInput");
      input.classList.remove("nonEmptyInput");
    } else {
      input.classList.remove("emptyInput");
      input.classList.add("nonEmptyInput");
    }
  });
});

selectPayment.addEventListener("change", () => {
  console.log(selectPayment.value);
  if (selectPayment.value == "") {
    selectPayment.classList.add("emptyInput");
    selectPayment.classList.remove("nonEmptyInput");
  } else {
    selectPayment.classList.remove("emptyInput");
    selectPayment.classList.add("nonEmptyInput");
  }
});

//Address Part

let cep = document.querySelector("#cepTxt");
let inputsPlace = document.querySelectorAll(".inputsPlace");

cep.addEventListener("change", () => {
  cepvalue = cep.value;
  if (cepvalue !== "") {
    let url = "https://opencep.com/v1/" + cepvalue;

    let request = new XMLHttpRequest();
    request.open("GET", url);
    request.send();

    request.onload = function () {
      if (request.status === 200) {
        let endereco = JSON.parse(request.response);
        document.querySelector("#ruaTxt").value = endereco.logradouro;
        document.querySelector("#bairroTxt").value = endereco.bairro;
        inputsPlace.forEach((input) => {
          input.classList.remove("emptyInput");
          input.classList.add("nonEmptyInput");
        });
      } else {
        document.querySelector("#ruaTxt").value = "CEP INVÁLIDO";
        document.querySelector("#bairroTxt").value = "CEP INVÁLIDO";
        inputsPlace.forEach((input) => {
          input.classList.add("emptyInput");
          input.classList.remove("nonEmptyInput");
        });
      }
    };
  }
});

//ItemCount func
let itemCount = document.querySelector(".itemCount");
let subButton = document.querySelector("#subButton");
let sumButton = document.querySelector("#sumButton");

let count = 1;

itemCount.value = count;

subButton.addEventListener("click", () => {
  if (count <= 1) {
    count = 1;
  } else {
    count--;
    itemCount.value = count;
  }
});
sumButton.addEventListener("click", () => {
  count++;
  itemCount.value = count;
});

//Block Divs func
let gridLocal = document.querySelector("#gridLocal");
let gridData = document.querySelector("#gridData");
let gridMenu = document.querySelector("#gridMenu");

let backToLocal = document.querySelector("#backToLocal");
let goToMenu = document.querySelector("#goToMenu");
let backToData = document.querySelector("#backToData");
let finishOrder = document.querySelector("#finishOrder");
let buttonGetOnPlace = document.querySelector("#buttonGetOnPlace");
let buttonDelivery = document.querySelector("#buttonDelivery");

gridData.style.pointerEvents = "none";
gridData.style.filter = "blur(2px)";
gridMenu.style.pointerEvents = "none";
gridMenu.style.filter = "blur(2px)";
gridLocal.style.border = "1dvh solid #eda3a3";

//Go To Data Grid
buttonDelivery.addEventListener("click", () => {
  gridLocal.style.pointerEvents = "none";
  gridLocal.style.filter = "blur(2px)";
  gridLocal.style.border = "0px";

  gridData.style.pointerEvents = "";
  gridData.style.filter = "";
  gridData.style.border = "1dvh solid #eda3a3";

  gridMenu.style.pointerEvents = "none";
  gridMenu.style.filter = "blur(2px)";
  gridMenu.style.border = "0px";
});

buttonGetOnPlace.addEventListener("click", () => {
  gridLocal.style.pointerEvents = "none";
  gridLocal.style.filter = "blur(2px)";
  gridLocal.style.border = "0px";

  gridData.style.pointerEvents = "";
  gridData.style.filter = "";
  gridData.style.border = "1dvh solid #eda3a3";

  gridMenu.style.pointerEvents = "none";
  gridMenu.style.filter = "blur(2px)";
  gridMenu.style.border = "0px";
});

//Return to Local Grid
backToLocal.addEventListener("click", () => {
  gridLocal.style.pointerEvents = "";
  gridLocal.style.filter = "";
  gridLocal.style.border = "1dvh solid #eda3a3";

  gridData.style.pointerEvents = "none";
  gridData.style.filter = "blur(2px)";
  gridData.style.border = "0px";

  gridMenu.style.pointerEvents = "none";
  gridMenu.style.filter = "blur(2px)";
  gridMenu.style.border = "0px";
});

//Go To Menu Grid
goToMenu.addEventListener("click", () => {
  gridLocal.style.pointerEvents = "none";
  gridLocal.style.filter = "blur(2px)";
  gridLocal.style.border = "0px";

  gridData.style.pointerEvents = "none";
  gridData.style.filter = "blur(2px)";
  gridData.style.border = "0px";

  gridMenu.style.pointerEvents = "";
  gridMenu.style.filter = "";
  gridMenu.style.border = "1dvh solid #eda3a3";
});

//Return to Data Grid
backToData.addEventListener("click", () => {
  gridLocal.style.pointerEvents = "none";
  gridLocal.style.filter = "blur(2px)";
  gridMenu.style.border = "0px";

  gridData.style.pointerEvents = "";
  gridData.style.filter = "";
  gridData.style.border = "1dvh solid #eda3a3";

  gridMenu.style.pointerEvents = "none";
  gridMenu.style.filter = "blur(2px)";
  gridMenu.style.border = "0px";
});

finishOrder.addEventListener("click", () => {});
