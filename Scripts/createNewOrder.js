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
    let url = "https://brasilapi.com.br/api/cep/v1/" + cepvalue;

    let request = new XMLHttpRequest();
    request.open("GET", url);
    request.send();

    request.onload = function () {
      if (request.status === 200) {
        let endereco = JSON.parse(request.response);
        document.querySelector("#ruaTxt").value = endereco.street;
        document.querySelector("#bairroTxt").value = endereco.neighborhood;
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
  if (count <= 0) {
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
