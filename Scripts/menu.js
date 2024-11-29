let modalSection = document.querySelector(".modalSection");
let modalContent = document.querySelector(".modalContent");
let createItem = document.querySelector(".createItem");
let categoryOptions = ["Lanche", "Acompanhamento", "Bebida", "Combo"];

createItem.addEventListener("click", () => {
  modalSection.style.display = "flex";
  modalContent.innerHTML = "";

  let labelDiv = document.createElement("div");
  let createItemLabel = document.createElement("h3");
  let closeButton = document.createElement("button");

  let labelName = document.createElement("label");
  labelName.textContent = "Nome";
  let inputName = document.createElement("input");

  let labelCategory = document.createElement("label");
  labelCategory.textContent = "Categoria";
  let selectCategory = document.createElement("select");

  let inputDescription = document.createElement("input");

  let labelPrice = document.createElement("label");
  labelPrice.textContent = "Preço";
  let inputPrice = document.createElement("input");

  let mainItemDiv = document.createElement("div");

  let buttonCreate = document.createElement("button");
  let buttonCancel = document.createElement("button");
  let confirmDiv = document.createElement("div");

  createItemLabel.textContent = "Crie um novo Item";
  closeButton.textContent = "X";

  buttonInfo.textContent = "Informações";
  buttonComplements.textContent = "Adicionais";

  buttonCancel.textContent = "Cancelar";
  buttonCreate.textContent = "Criar";

  labelDiv.className = "labelDiv";
  labelDiv.appendChild(createItemLabel);
  labelDiv.appendChild(closeButton);

  for (let index = 0; index < categoryOptions.length; index++) {
    let option = document.createElement("option");
    option.textContent = categoryOptions[index];
    option.value = categoryOptions[index];
    selectCategory.appendChild(option);
  }

  mainItemDiv.appendChild(labelName);
  mainItemDiv.appendChild(inputName);
  mainItemDiv.appendChild(labelCategory);
  mainItemDiv.appendChild(selectCategory);

  mainItemDiv.appendChild(inputDescription);

  mainItemDiv.appendChild(labelPrice);
  mainItemDiv.appendChild(inputPrice);

  confirmDiv.appendChild(buttonCancel);
  confirmDiv.appendChild(buttonCreate);

  modalContent.appendChild(labelDiv);
  modalContent.appendChild(mainItemDiv);
  modalContent.appendChild(confirmDiv);

  closeButton.addEventListener("click", () => {
    modalSection.style.display = "none";
  });
});
