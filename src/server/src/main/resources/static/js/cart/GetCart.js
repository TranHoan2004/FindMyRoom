import {GetAmountCart} from "../api/cart/AmountCart.js";

window.addEventListener('load', () => {
    const element = document.getElementById('amountCart')
    GetAmountCart().then(data => {
        element.innerHTML = data;
    }).catch(e => {
        console.log(e.message);
        element.innerHTML = '0';
    });
})