import { GetData } from "./api/ExportPost.js";

document.addEventListener('DOMContentLoaded', () => {
    renderPosts(null, null).catch(e => console.error(e));
});

async function renderPosts(page, filter) {
    page = page === null ? 1 : page;
    try {
        const responseData = await GetData(page, filter);
        let html = '';
        let pageIndex = '';

        const data = responseData._embedded?.postDTOList;
        if (!data || data.length === 0) {
            html += `
                <div class="card card-post">
                    <div class="card-body text-center">
                        <h5 class="card-title">Not found</h5>
                    </div>
                </div>`
            $('#pagination').html('');
        } else {
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
            $('#pagination').html(pagination);
        }
        $('#post-list').html(html);
    } catch (err) {
        console.log(err)
    }
}
window.renderPosts = renderPosts;

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