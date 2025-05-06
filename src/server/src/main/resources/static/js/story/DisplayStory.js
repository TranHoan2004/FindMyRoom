import {GetStory} from "../api/story/GetStory.js";

const swiper = new Swiper(".mySwiper", {
    slidesPerView: 4,
    spaceBetween: 15,
    freeMode: true,
    breakpoints: {
        576: {
            slidesPerView: 5
        },
        768: {
            slidesPerView: 6
        }
    }
});

const container = document.getElementById('story-container')
const div = document.getElementById('story-content')
let content = ''
const data = await GetStory()
data.data.forEach((d) => {
    content += `
              <div class="swiper-slide text-center">
                   <img src="${d.thumbnailImg}" width="100" height="100"
                           class="rounded-circle mb-1" alt="">
                   <div><small>${d.storyType}</small></div>
              </div>`;
})
div.innerHTML = content
container.appendChild(div)