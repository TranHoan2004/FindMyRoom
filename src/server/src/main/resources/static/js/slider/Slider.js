import {GetSlider} from "../api/slider/ExportSlider.js";

document.addEventListener('DOMContentLoaded', () => {
    loadAllSliders()
});

async function loadAllSliders() {
    const data = await GetSlider()
    const container = document.getElementById('image-container')
    const div = document.createElement('div')
    let content = ''
    data.forEach((img, index) => {
        content += `
               <div class="carousel-item ${index === 0 ? 'active' : ''}">
                   <img src="${img}" class="d-block w-100" alt="..." height="400">
               </div>`;
    })
    div.innerHTML = content
    container.appendChild(div)
}