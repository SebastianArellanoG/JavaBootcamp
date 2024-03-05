import { cupones } from './data.js';
const cuponesContainer = document.getElementById('content');

Object.keys(cupones).forEach((cuponId) => {
  const cupon = cupones[cuponId];

  const cuponComponent = `
        <div class="card" style="width: 19rem; margin: 20px auto;">
  <img src="${cupon.imglink}" class="card-img-top" alt="${cupon.title}" />
  <div class="card-body" >
    <h5 class="card-title text-ligth">${cupon.title}</h5>
    <span class="card-text text-gray text-ligth">${cupon.name}</span>
    <p class="card-text text-gray text-ligth" style="border-bottom: solid 1px  #C8C6C4 ;"><img src="/assets/svg/map-pin-alt-svgrepo-com.svg"> ${cupon.direcction}</p>
    <p class="card-text text-end"><span class= "mx-2 small text-gray text-ligth"> ${cupon.price}  </span><span class="text-green lead ">${cupon.salePrice}</span></p>

  </div>
</div>
      `;

  cuponesContainer.innerHTML += cuponComponent;
});
