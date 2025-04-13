const postData = {
    1: [
        { title: "Phòng trọ sạch sẽ giá rẻ", text: "Quận 10, TP.HCM | 2.5 triệu/tháng" },
        { title: "Phòng mới xây gần Bách Khoa", text: "Q.5, TP.HCM | 3 triệu/tháng" },
    ],
    2: [
        { title: "Phòng ở ghép giá sinh viên", text: "Thủ Đức | 1.2 triệu/tháng" },
        { title: "Căn hộ mini full nội thất", text: "Quận 7 | 4.5 triệu/tháng" },
    ],
    3: [
        { title: "Phòng đẹp gần ĐH Kinh Tế", text: "Q.3 | 2.8 triệu/tháng" },
        { title: "Phòng trọ rộng rãi, có gác", text: "Bình Thạnh | 3.2 triệu/tháng" },
    ]
};

function loadPosts(page) {
    const posts = postData[page] || [];
    let html = '';
    posts.forEach(post => {
        html += `
<div class="card card-post">
  <div class="card-body">
    <h5 class="card-title">${post.title}</h5>
    <p class="card-text">${post.text}</p>
  </div>
</div>`;
    });
    $('#post-list').html(html);
}

// Load trang đầu tiên khi mở web
$(document).ready(function () {
    loadPosts(1);

    $('#pagination').on('click', 'a', function (e) {
        e.preventDefault();
        const page = $(this).data('page');
        loadPosts(page);
        $('#pagination .page-item').removeClass('active');
        $(this).parent().addClass('active');
    });
});

// Lấy tất cả các nav-link
const tabs = document.querySelectorAll('#myTab .nav-link');

tabs.forEach(tab => {
    tab.addEventListener('click', function (e) {
        e.preventDefault(); // Ngăn load lại trang nếu là thẻ <a>

        // Xóa 'active' khỏi tất cả các tab
        tabs.forEach(t => t.classList.remove('active'));

        // Thêm 'active' vào tab vừa click
        this.classList.add('active');
    });
});