function markAsRead(btn) {
    const badge = btn.closest('.alert').querySelector('.badge');
    badge.textContent = "Đã đọc";
    badge.classList.remove('bg-secondary');
    badge.classList.add('bg-success');
    btn.disabled = true;
}

function deleteNotification(btn) {
    const alertBox = btn.closest('.alert');
    alertBox.classList.add('fade');
    setTimeout(() => alertBox.remove(), 300);
}

function saveNotificationSettings() {
    const settings = {
        promo: {
            enabled: document.getElementById('promoNotify').checked,
            method: document.getElementById('promoEmail').checked ? 'email' : 'web'
        }, system: {
            enabled: document.getElementById('systemNotify').checked,
            method: document.getElementById('systemEmail').checked ? 'email' : 'web'
        }, owner: {
            enabled: document.getElementById('ownerNotify').checked,
            method: document.getElementById('ownerEmail').checked ? 'email' : 'web'
        }
    };

    localStorage.setItem("notificationSettings", JSON.stringify(settings));
    alert("✅ Cài đặt thông báo đã được lưu!");
}

document.addEventListener("DOMContentLoaded", function () {
    const saved = localStorage.getItem("notificationSettings");
    if (saved) {
        const settings = JSON.parse(saved);

        // Ưu đãi
        document.getElementById('promoNotify').checked = settings.promo.enabled;
        document.getElementById(settings.promo.method === 'email' ? 'promoEmail' : 'promoWeb').checked = true;

        // Hệ thống
        document.getElementById('systemNotify').checked = settings.system.enabled;
        document.getElementById(settings.system.method === 'email' ? 'systemEmail' : 'systemWeb').checked = true;

        // Từ chủ trọ
        document.getElementById('ownerNotify').checked = settings.owner.enabled;
        document.getElementById(settings.owner.method === 'email' ? 'ownerEmail' : 'ownerWeb').checked = true;
    }
});