// Chế độ sáng-tối
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

// Thanh hiển thị thông báo
const div = document.createElement('div')
div.className = 'notification-container'
div.id = 'notificationContainer'

const iconMap = {
    success: 'check-circle',
    error: 'exclamation-circle',
    warning: 'exclamation-triangle',
    info: 'info-circle'
}

let stompClient = null;

const socket = new SockJS('/ws');
stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/messages', function (frame) {
        setTimeout(() => showNotification('New Notification', 'You have a new message!', 'info'), 10);
    });

    stompClient.subscribe('/topic/guess', function (frame) {
        const data = JSON.parse(frame.body)
        setTimeout(() => showNotification(data.title, data.message.content.link, 'info'), 10);
    });
});

function sendMessage() {
    const payload = {
        message: {
            from: 'interview',
            content: {
                link: 'link',
                message: 'message'
            },
            to: 11
        },
        title: 'Notification'
    };
    // stompClient.send("/app/application", {}, JSON.stringify(payload));
    stompClient.send("/app/get", {}, JSON.stringify(payload));
}

const container = document.getElementById('notificationContainer')

function showNotification(title, message, type) {
    if (!container) return;

    const toast = createToastElement(title, message, type)
    container.appendChild(toast)

    requestAnimationFrame(() => {
        requestAnimationFrame(() => {
            toast.classList.add('show')
        })
    })

    setTimeout(() => {
        toast.classList.remove('show')
        toast.classList.add('hiding')
        setTimeout(() => {
            if (toast.parentElement === container) {
                container.removeChild(toast)
            }
        }, 300)
    }, 5000)
}

function createToastElement(title, message, type) {
    const toast = document.createElement('div')
    toast.className = `toast-notification toast-${type}`

    const icon = iconMap[type] || 'info-circle'

    toast.innerHTML = `
            <div class="toast-header">
                <i class="fas fa-${icon} me-2"></i>
                <strong>${title}</strong>
                <button type="button" class="btn-close ms-auto" onclick="this.closest('.toast-notification').remove()"></button>
            </div>
            <div class="toast-body">${message}</div>`
    return toast;
}