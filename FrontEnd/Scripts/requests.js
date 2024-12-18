let grid = document.querySelectorAll(".grid");

grid.forEach((gridElement) => {
  gridElement.addEventListener("mouseover", () => {
    // Adicionar ouvintes de click apenas para o gridElement específico
    const orderDone = gridElement.querySelector("#orderDone");
    const orderDelete = gridElement.querySelector("#orderDelete");
    const preparingOrder = gridElement.querySelector(".preparingOrder");

    if (orderDone && orderDelete && preparingOrder) {
      // Ouvinte para "Pedido concluído"
      orderDone.addEventListener("click", () => {
        orderDone.remove();
        orderDelete.remove();
        preparingOrder.textContent = "Pedido concluído";
        preparingOrder.style.backgroundColor = "#DCEE8A";
        preparingOrder.style.width = "100%";
      });

      // Ouvinte para "Pedido cancelado"
      orderDelete.addEventListener("click", () => {
        orderDone.remove();
        orderDelete.remove();

        preparingOrder.style.width = "100%";
        preparingOrder.textContent = "Pedido cancelado";
        preparingOrder.style.backgroundColor = "#FF7070";
      });
    }
  });
});
