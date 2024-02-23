import { cupones } from './data.js';
const cuponesContainer = document.getElementById('content');

console.log(cupones);
Object.keys(cupones).forEach((cuponId) => {
  const cupon = cupones[cuponId];

  const cuponComponent = `
        <div class="card" style="width: 18rem;">
  <img src="${cupon.imglink}" class="card-img-top" alt="${cupon.title}" />
  <div class="card-body">
    <h5 class="card-title">${cupon.title}</h5>
    <p class="card-text"><strong>Nombre:</strong> ${cupon.name}</p>
    <p class="card-text"><strong>Dirección:</strong> ${cupon.direcction}</p>
    <p class="card-text"><strong>Precio:</strong> ${cupon.price}</p>
    <p class="card-text"><strong>Precio en oferta:</strong> ${cupon.salePrice}</p>
  </div>
</div>
      `;

  cuponesContainer.innerHTML += cuponComponent;
});
