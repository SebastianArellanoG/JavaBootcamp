import { cupones } from './data.js';
const cuponesContainer = document.getElementById('content');

Object.keys(cupones).forEach((cuponId) => {
  const cupon = cupones[cuponId];

  const cuponComponent = `
        <div class="card" style="width: 19rem; margin: 20px auto;">
  <img src="${cupon.imglink}" class="card-img-top" alt="${cupon.title}" />
  <div class="card-body" >
    <h5 class="card-title">${cupon.title}</h5>
    <p class="card-text"><strong>Nombre:</strong> ${cupon.name}</p>
    <p class="card-text" style="border-bottom: solid 1px  #C8C6C4 ;"> ${cupon.direcction}</p>
    <p class="card-text text-end"><span class= "mx-2 small "style="color:#C8C6C4"> ${cupon.price}  </span><span class="text-success lead ">${cupon.salePrice}</span></p>

  </div>
</div>
      `;

  cuponesContainer.innerHTML += cuponComponent;
});
