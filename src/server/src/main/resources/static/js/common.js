document.addEventListener('DOMContentLoaded', function () {
    const toggle = document.getElementById('themeToggle');

    // Giữ chế độ khi reload
    if (localStorage.getItem('theme') === 'dark') {
        document.body.classList.add('dark-mode');
        toggle.checked = true
    }
    toggle.addEventListener('click', function () {
        document.body.classList.toggle('dark-mode');
        localStorage.setItem('theme', document.body.classList.contains('dark-mode') ? 'dark' : 'light');
    });
});