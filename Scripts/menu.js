let modalSection = document.querySelector(".modalSection");
let modalContent = document.querySelector(".modalContent");
let closeButton = document.querySelector(".closeButton");
let createItem = document.querySelector(".createItem");
let buttonCancel = document.querySelector(".buttonCancel");
let buttonCreate = document.querySelector(".buttonCreate");
let categoryOptions = ["Lanche", "Acompanhamento", "Bebida", "Combo"];

createItem.addEventListener("click", () => {
  modalSection.style.display = "flex";

  buttonCancel.addEventListener("click", () => {
    modalSection.style.display = "none";
  });
  closeButton.addEventListener("click", () => {
    modalSection.style.display = "none";
  });
});

const inputFile = document.querySelector("#files");
const imgArea = document.querySelector(".imgDivModal");

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
