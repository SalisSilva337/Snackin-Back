let modalSection = document.querySelector(".modalSection");
let modalContent = document.querySelector(".modalContent");
let closeButton = document.querySelector(".closeButton");
let createOrder = document.querySelector(".createOrder");
let paymentOptions = ["PIX", "Débito", "Crédito", "Dinheiro"];

createOrder.addEventListener("click", () => {
  modalSection.style.display = "flex";
  // modalContent.innerHTML = "";

  // let labelDiv = document.createElement("div");
  // let createItemLabel = document.createElement("h3");
  // let closeButton = document.createElement("button");

  // let imgItemDivModal = document.createElement("div");
  // let imgItemModal = document.createElement("img");

  // //inputs
  // let inputsDiv = document.createElement("div");

  // let labelName = document.createElement("label");
  // labelName.textContent = "Nome";
  // let inputName = document.createElement("input");

  // let labelCategory = document.createElement("label");
  // labelCategory.textContent = "Categoria";
  // let selectCategory = document.createElement("select");

  // let inputDescription = document.createElement("input");
  // inputDescription.className = "inputDescription";

  // let labelPrice = document.createElement("label");
  // labelPrice.textContent = "Preço";
  // let inputPrice = document.createElement("input");

  // let mainItemDiv = document.createElement("div");

  // //div de confirmacao
  // let buttonCreate = document.createElement("button");
  // let buttonCancel = document.createElement("button");
  // let confirmDiv = document.createElement("div");

  // createItemLabel.textContent = "Crie um novo Item";
  // closeButton.textContent = "X";

  // buttonCancel.textContent = "Cancelar";
  // buttonCreate.textContent = "Criar";

  // labelDiv.className = "labelDiv";
  // labelDiv.appendChild(createItemLabel);
  // labelDiv.appendChild(closeButton);

  // imgItemDivModal.className = "imgItemDivModal";
  // imgItemDivModal.appendChild(imgItemModal);

  // for (let index = 0; index < categoryOptions.length; index++) {
  //   let option = document.createElement("option");
  //   option.textContent = categoryOptions[index];
  //   option.value = categoryOptions[index];
  //   selectCategory.appendChild(option);
  // }

  // inputsDiv.className = "inputsDiv";
  // mainItemDiv.className = "mainItemDiv";

  // mainItemDiv.appendChild(imgItemDivModal);
  // inputsDiv.appendChild(labelName);
  // inputsDiv.appendChild(inputName);
  // inputsDiv.appendChild(labelCategory);
  // inputsDiv.appendChild(selectCategory);

  // inputsDiv.appendChild(inputDescription);

  // inputsDiv.appendChild(labelPrice);
  // inputsDiv.appendChild(inputPrice);

  // mainItemDiv.appendChild(inputsDiv);

  // confirmDiv.appendChild(buttonCancel);
  // confirmDiv.appendChild(buttonCreate);

  // modalContent.appendChild(labelDiv);
  // modalContent.appendChild(mainItemDiv);
  // modalContent.appendChild(confirmDiv);

  closeButton.addEventListener("click", () => {
    modalSection.style.display = "none";
  });
});
