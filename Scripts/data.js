let clientAdd = document.querySelector(".client-add");
let mainArea = document.querySelector(".mainArea");
let options = ["Débito", "Credito", "Pix", "Dinheiro"];

//Botao de adicionar Cliente
clientAdd.addEventListener("click", () => {
  let divData = document.createElement("div");

  let labelClientName = document.createElement("label");
  let inputsClientDataName = document.createElement("input");
  let labelClientPhone = document.createElement("label");
  let inputsClientDataPhone = document.createElement("input");
  let labelClientPaymentMethod = document.createElement("label");
  let inputsClientDataPaymentMethod = document.createElement("select");
  let labelClientOrder = document.createElement("label");
  let inputsClientDataOrder = document.createElement("input");
  let deleteClient = document.createElement("img");

  for (let index = 0; index < options.length; index++) {
    let option = document.createElement("option");
    option.textContent = options[index];
    inputsClientDataPaymentMethod.appendChild(option);
  }

  labelClientName.textContent = "Nome do Cliente:";
  labelClientPhone.textContent = "Telefone:";
  labelClientPaymentMethod.textContent = "Método de Pagamento:";
  labelClientOrder.textContent = "Pedido:";

  deleteClient.className = "deleteClient";
  deleteClient.src = "../Imgs/trashCan.png";

  inputsClientDataName.className = "inputsClientData";
  inputsClientDataPhone.className = "inputsClientData";
  inputsClientDataOrder.className = "inputsClientData";

  divData.className = "divData";

  divData.appendChild(labelClientName);
  divData.appendChild(inputsClientDataName);

  divData.appendChild(labelClientPhone);
  divData.appendChild(inputsClientDataPhone);

  divData.appendChild(labelClientPaymentMethod);
  divData.appendChild(inputsClientDataPaymentMethod);

  divData.appendChild(labelClientOrder);
  divData.appendChild(inputsClientDataOrder);

  divData.appendChild(deleteClient);

  mainArea.appendChild(divData);

  deleteClient.addEventListener("click", () => {
    divData.remove();
  });
});

//Modal config
