import {GetData} from "../api/post/ExportPost.js";

document.addEventListener('DOMContentLoaded', () => {
    renderPosts(null, null).catch(e => console.error(e));
});

async function renderPosts(page, filter) {
    page = page === null ? 1 : page;
    try {
        const rawResponseData = await GetData(page, filter);
        const responseData = rawResponseData.data
        let html = '';
        let pageIndex = '';

        const data = responseData.content;
        if (!data || data.length === 0) {
            html += `
                <div class="card card-post">
                    <div class="card-body text-center">
                        <h5 class="card-title">Not found</h5>
                    </div>
                </div>`
            $('#pagination').html('');
        } else {
            const date = new Date()
            const pad = n => n.toString().padStart(2, '0');
            const today = `${date.getFullYear()}-${pad(date.getMonth() + 1)}-${pad(date.getDate())}`;
            data.forEach(post => {
                html += renderAllThePosts(post, today)
            });

            // Hien thi so trang
            $('#pagination').html(renderPagination(pageIndex, filter, responseData, page));
        }
        $('#post-list').html(html);
    } catch (err) {
        console.log(err)
    }
}

window.renderPosts = renderPosts;

// xử lý bộ lọc và trình bày post theo bộ lọc
const tabs = document.querySelectorAll('#myTab .nav-link');
tabs.forEach(tab => {
    tab.addEventListener('click', function (e) {
        e.preventDefault();

        tabs.forEach(t => t.classList.remove('active'));

        let content = this.dataset.value.trim();
        renderPosts(1, (content === 'null') ? null : `${content}`).catch(e => console.log(e));

        this.classList.add('active');
    });
});

// xử lý like, comment, share
document.addEventListener('click', function (e) {
    const btn = e.target;
    const action = btn.dataset.action;
    if (!action) return;

    const card = btn.closest('.post-card');
    const postId = card.dataset.postId;

    switch (action) {
        case 'like':
            console.log(`👍 Liked post ${postId}`);
            break;
        case 'comment':
            console.log(`💬 Comment on post ${postId}`);
            break;
        case 'share':
            console.log(`🔄 Share post ${postId}`);
            break;
    }
});

// document.addEventListener('click', function (e) {
//     if (e.target.classList.contains('star')) {
//         const star = e.target;
//         const value = parseInt(star.getAttribute('data-value'));
//         const rating = star.closest('.rating');
//         const postId = rating.getAttribute('data-post-id');
//         const stars = rating.querySelectorAll('.star');
//
//         stars.forEach(s => {
//             const v = parseInt(s.getAttribute('data-value'));
//             s.classList.toggle('active', v <= value);
//         });
//
//         console.log(`Đánh giá ${value} sao cho bài post ${postId}`);
//     }
// });

// Phương thức hỗ trợ
function getButton(currentPage, totalPage, index, title, filter) {
    // index: 1 or final position
    const classAppend = currentPage === index ? 'disabled' : ''
    const btn = currentPage === index ? 'previous' : 'next'
    const arrow = title === 'Previous' ? `<<` : `>>`
    const nextPage = title === 'Previous' ? currentPage - 1 : currentPage + 1
    return `<li class="page-item" id=${btn}>
                <a class="page-link ${classAppend}" onclick="renderPosts(${nextPage}, ${filter !== null ? `'${filter}'` : null})" aria-label=${title}>
                   <span aria-hidden="true">${arrow}</span>
                </a>
            </li>`
}

function renderAllThePosts(post, today) {
    return `
                <div class="card card-post shadow-sm mb-4"
                    style="border: none; border-radius: 12px; overflow: hidden;"
                    data-post-id="${post.id}">
                   <div class="card-header d-flex align-items-center">
                        <img src="${post.userAvatar || '/images/Facebook_Logo_(2019).png'}" 
                            alt="Avatar" 
                            class="rounded-circle me-2" 
                            width="40" height="40">
                        <div>
                            <h6 class="mb-0 fw-bold">${post.username || 'Người dùng'}</h6>
                            <small class="text-muted">${post.createdDate === today ? 'Vừa xong' : post.createdDate}</small>
                        </div>
                        <div class="ms-auto text-muted">
                             👁️ ${post.view || 0}
                        </div>
                   </div>
                   
                   <img src="${post.thumbnailURL}" class="card-img-top" 
                        alt="Thumbnail" 
                        style="object-fit: contain; width: 100%; height: 200px; background-color: #f0f0f0;">
                   <div class="card-body">
                         <h5 class="card-title">${post.title}</h5>
                         <div class="card-text">
                            <p>${post.content}</p>
<!--                            <a href="/post/${post.id}" class="text-decoration-none fw-semibold text-primary">››› Xem chi tiết</a>-->
                            <a href="#" class="text-decoration-none text-primary">››› Xem chi tiết</a>
                         </div>
<!--                         <div class="rating" data-post-id="${post.id}">-->
<!--                            <span>Đánh gia: </span>-->
<!--                            <i class="star fa fa-star" data-value="1"></i>-->
<!--                            <i class="star fa fa-star" data-value="2"></i>-->
<!--                            <i class="star fa fa-star" data-value="3"></i>-->
<!--                            <i class="star fa fa-star" data-value="4"></i>-->
<!--                            <i class="star fa fa-star" data-value="5"></i>-->
<!--                         </div>-->
                         <div class="card-text d-flex">
                            <p>❤️ ${post.like}</p>
                            <div class="d-flex ms-auto">
                                <p>💬 ${post.like}</p>
                                <p>🔄 ${post.like}</p>
                            </div>
                         </div>
                   </div>
                   
                   <div class="card-footer d-flex justify-content-around">
                        <button class="btn btn-sm" data-action="like"><i class="fas fa-thumbs-up"></i> Thích</button>
                        <button class="btn btn-sm" data-action="comment"><i class="fas fa-comment"></i> Bình luận</button>
                        <button class="btn btn-sm" data-action="share"><i class="fas fa-share"></i> Chia sẻ</button>
                   </div>
                </div>`;
}

function renderPagination(pageIndex, filter, responseData, page) {
    const totalPages = responseData.page?.totalPages
    for (let i = 1; i <= totalPages; i++) {
        pageIndex += `
                    <li class="page-item">
                        <a class="page-link" onclick="renderPosts(${i}, ${filter !== null ? `'${filter}'` : null})" 
                            data-page=${i} style="cursor: pointer;">
                            ${i}
                        </a>
                    </li>`
    }
    let pagination = ''
    pagination += getButton(page, totalPages, 1, 'Previous', filter)
    pagination += pageIndex
    pagination += getButton(page, totalPages, totalPages, 'Next', filter)
    return pagination
}