$(document).ready(function () {
    renderPosts(null)
})

function renderPosts(page) {
    page = page === null ? 1 : page;
    $.ajax({
        url: '/posts/list/' + page,
        type: 'GET',
        data: {},
        success: function (responseData) {
            let html = ''
            let pageIndex = ''

            const data = responseData._embedded?.postDTOList;
            data.forEach(post => {
                html += `
                        <div class="card card-post">
                            <div class="card-body">
                                <h5 class="card-title">${post.title}</h5>
                                <p class="card-text">${post.content}</p>
                            </div>
                        </div>`;
            });

            // Hien thi so trang
            const totalPages = responseData.page?.totalPages
            for (let i = 1; i <= totalPages; i++) {
                pageIndex += `<li class="page-item"><a class="page-link" onclick="renderPosts(${i})" data-page=${i}>${i}</a></li>`
            }
            let pagination = ''
            pagination += getButton(page, totalPages, 1, 'Previous')
            pagination += pageIndex
            pagination += getButton(page, totalPages, totalPages, 'Next')

            $('#post-list').html(html);
            $('#pagination').html(pagination);
        }
    })
}

function getButton(currentPage, totalPage, index, title) {
    // index: 1 or final position
    const classAppend = currentPage === index || currentPage === totalPage ? 'disabled' : ''
    const arrow = title === 'Previous' ? `<<` : `>>`
    const nextPage = title === 'Previous' ? currentPage - 1 : currentPage + 1
    return `<li class="page-item">
                <a class="page-link ${classAppend}" href="/notification/list/${nextPage}" aria-label=${title}>
                   <span aria-hidden="true">${arrow}</span>
                </a>
            </li>`
}

// Lấy tất cả các nav-link
const tabs = document.querySelectorAll('#myTab .nav-link');

// bo loc
tabs.forEach(tab => {
    tab.addEventListener('click', function (e) {
        e.preventDefault(); // Ngăn load lại trang nếu là thẻ <a>

        // Xóa 'active' khỏi tất cả các tab
        tabs.forEach(t => t.classList.remove('active'));

        // Thêm 'active' vào tab vừa click
        this.classList.add('active');
    });
});