let modalSection = document.querySelector(".modalSection");
let modalContent = document.querySelector(".modalContent");
let closeButton = document.querySelector(".closeButton");
let createItem = document.querySelector(".createItem");
let buttonCancel = document.querySelector(".buttonCancel");
let buttonCreate = document.querySelector(".buttonCreate");
let categoryOptions = ["Lanche", "Acompanhamento", "Bebida", "Combo"];

let inputName = document.querySelector("#inputName");
let selectCategory = document.querySelector("#selectCategory");
let inputPrice = document.querySelector("#inputPrice");
let inputDesc = document.querySelector("#inputDesc");

let gridSection = document.querySelector(".gridSection");

const inputFile = document.querySelector("#files");
const imgArea = document.querySelector(".imgDivModal");
//Abrir Modal
let createListenerAdded = false;

createItem.addEventListener("click", () => {
  modalSection.style.display = "flex";

  // Remove the existing event listener if it has already been added
  if (createListenerAdded) {
    buttonCreate.removeEventListener("click", handleCreateButtonClick);
  }

  // Add the event listener for "Create"
  buttonCreate.addEventListener("click", handleCreateButtonClick);
  createListenerAdded = true;

  // Close modal when cancel button is clicked
  buttonCancel.addEventListener("click", () => {
    modalSection.style.display = "none";
    clearModalInputs(); // Clear inputs on cancel
  });

  closeButton.addEventListener("click", () => {
    modalSection.style.display = "none";
    clearModalInputs(); // Clear inputs on close
  });
});

// Handle button create click
function handleCreateButtonClick() {
  let grid = document.createElement("div");
  let productName = document.createElement("h2");
  let itemImageDiv = document.createElement("div");
  let itemImage = document.createElement("img");
  let productCategory = document.createElement("h2");
  let productPrice = document.createElement("h3");
  let editButton = document.createElement("button");
  let editImg = document.createElement("img");
  let deleteButton = document.createElement("button");
  let deleteImg = document.createElement("img");
  let buttonsGridDiv = document.createElement("div");

  grid.className = "grid";
  itemImageDiv.className = "itemImage";
  editButton.className = "editButton";
  deleteButton.className = "editButton";

  buttonsGridDiv.style.display = "flex";
  buttonsGridDiv.style.gap = "10px";
  productName.textContent = inputName.value;
  productCategory.textContent = selectCategory.value;
  productPrice.textContent = "R$" + inputPrice.value;

  itemImage.src = imgArea.querySelector("img")
    ? imgArea.querySelector("img").src
    : "";
  editImg.src = "../../Imgs/icons/editIcon.svg";

  deleteImg.src = "../../Imgs/icons/deleteIcon.svg";
  grid.appendChild(productName);
  itemImageDiv.appendChild(itemImage);
  grid.appendChild(itemImageDiv);
  grid.appendChild(productCategory);
  grid.appendChild(productPrice);
  buttonsGridDiv.appendChild(editButton);
  buttonsGridDiv.appendChild(deleteButton);
  editButton.appendChild(editImg);

  deleteButton.appendChild(deleteImg);
  grid.appendChild(buttonsGridDiv);
  gridSection.appendChild(grid);

  modalSection.style.display = "none";
  deleteButton.addEventListener("click", () => {
    grid.remove();
  });
  clearModalInputs(); // Clear inputs after creating the item
}

//Selecionar Imagem
inputFile.addEventListener("change", function () {
  const image = this.files[0];

  const reader = new FileReader();
  reader.onload = () => {
    const allImg = imgArea.querySelectorAll("img");
    allImg.forEach((item) => item.remove());
    const imgUrl = reader.result;
    const img = document.createElement("img");
    img.src = imgUrl;
    imgArea.appendChild(img);
    imgArea.dataset.img = image.name;
  };
  reader.readAsDataURL(image);
});
