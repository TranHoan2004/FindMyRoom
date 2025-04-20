import {GetData} from "./api/post/ExportPost.js";

document.addEventListener('DOMContentLoaded', () => {
    renderPosts(null, null).catch(e => console.error(e));
});

async function renderPosts(page, filter) {
    page = page === null ? 1 : page;
    try {
        const responseData = await GetData(page, filter);
        let html = '';
        let pageIndex = '';

        const data = responseData._embedded?.postResponseDTOList;
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
                console.log(post)
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

/////////////////////////////////////////////////////////////////
// xử lý bộ lọc và trình bày post theo bộ lọc

// Lấy tất cả các nav-link
const tabs = document.querySelectorAll('#myTab .nav-link');

// bo loc
tabs.forEach(tab => {
    tab.addEventListener('click', function (e) {
        e.preventDefault();

        tabs.forEach(t => t.classList.remove('active'));

        let content = this.dataset.value.trim();
        renderPosts(1, (content === 'null') ? null : `${content}`).catch(e => console.log(e));

        this.classList.add('active');
    });
});

/////////////////////////////////////////////////////////////////
// Xử lý like, comment, share
document.addEventListener('click', function (e) {
    const btn = e.target;
    const action = btn.dataset.action;
    if (!action) return;

    const card = btn.closest('.post-card');
    const postId = card.dataset.postId;

    switch (action) {
        case 'like':
            console.log(`👍 Liked post ${postId}`);
            // Gửi like lên server tại đây nếu muốn
            break;
        case 'comment':
            console.log(`💬 Comment on post ${postId}`);
            // Mở khung bình luận nếu cần
            break;
        case 'share':
            console.log(`🔄 Share post ${postId}`);
            // Mở hộp thoại chia sẻ
            break;
    }
});

document.addEventListener('click', function (e) {
    if (e.target.classList.contains('star')) {
        const star = e.target;
        const value = parseInt(star.getAttribute('data-value'));
        const rating = star.closest('.rating');
        const postId = rating.getAttribute('data-post-id');
        const stars = rating.querySelectorAll('.star');

        // Highlight sao đã chọn
        stars.forEach(s => {
            const v = parseInt(s.getAttribute('data-value'));
            s.classList.toggle('active', v <= value);
        });

        console.log(`Đánh giá ${value} sao cho bài post ${postId}`);
        // Gửi dữ liệu lên server nếu cần
    }
});

/////////////////////////////////////////////////////////////////
// Phương thức hỗ trợ

function getButton(currentPage, totalPage, index, title, filter) {
    // index: 1 or final position
    const classAppend = currentPage === index ? 'disabled' : ''
    const arrow = title === 'Previous' ? `<<` : `>>`
    const nextPage = title === 'Previous' ? currentPage - 1 : currentPage + 1
    return `<li class="page-item">
                <a class="page-link ${classAppend}" onclick="renderPosts(${nextPage}, ${filter !== null ? `'${filter}'` : null})" aria-label=${title}>
                   <span aria-hidden="true">${arrow}</span>
                </a>
            </li>`
}

function renderAllThePosts(post, today) {
    console.log(post)
    return `
                <div class="card card-post shadow-sm mb-4"
                    style="border: none; border-radius: 12px; overflow: hidden;"
                    data-post-id="${post.id}">
                   <div class="card-header d-flex align-items-center">
                        <img src="${post.userAvatar || '/images/default-avatar.png'}" 
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
                         <p class="card-text">${post.content}</p>
                         <div class="rating" data-post-id="${post.id}">
                            <span>Đánh gia: </span>
                            <i class="star fa fa-star" data-value="1"></i>
                            <i class="star fa fa-star" data-value="2"></i>
                            <i class="star fa fa-star" data-value="3"></i>
                            <i class="star fa fa-star" data-value="4"></i>
                            <i class="star fa fa-star" data-value="5"></i>
                         </div>
                   </div>
                   
                   <div class="card-footer d-flex justify-content-around">
                        <button class="btn btn-sm" data-action="like">❤️ Thích</button>
                        <button class="btn btn-sm" data-action="comment">💬 Bình luận</button>
                        <button class="btn btn-sm" data-action="share">🔄 Chia sẻ</button>
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
