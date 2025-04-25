const MOCK_INTERACTIONS = [
    {title: "Phòng trọ Nguyễn Văn Cừ", action: "viewed", time: "2025-04-24 10:30"},
    {title: "Căn hộ mini Gò Vấp", action: "saved", time: "2025-04-24 12:45"},
    {title: "Phòng có gác ở Tân Bình", action: "contacted", time: "2025-04-25 08:10"},
];

function loadInteractions() {
    const data = localStorage.getItem("interactionHistory");
    return data ? JSON.parse(data) : MOCK_INTERACTIONS;
}

function saveInteractions(data) {
    localStorage.setItem("interactionHistory", JSON.stringify(data));
}

function renderInteractions() {
    const filter = document.getElementById("filterType").value;
    const tbody = document.getElementById("interactionTableBody");
    const data = loadInteractions();

    tbody.innerHTML = "";

    data
        .filter(item => filter === "all" || item.action === filter)
        .forEach((item, index) => {
            const row = `<tr>
        <td>${item.title}</td>
        <td>${translateAction(item.action)}</td>
        <td>${item.time}</td>
        <td><button class="btn btn-sm btn-outline-danger" onclick="deleteInteraction(${index})">Xóa</button></td>
      </tr>`;
            tbody.insertAdjacentHTML("beforeend", row);
        });
}

function translateAction(action) {
    switch (action) {
        case "viewed":
            return "👁️ Đã xem";
        case "saved":
            return "📌 Đã lưu";
        case "contacted":
            return "📞 Đã liên hệ";
        default:
            return "";
    }
}

function deleteInteraction(index) {
    const data = loadInteractions();
    data.splice(index, 1);
    saveInteractions(data);
    renderInteractions();
}

function clearInteractionHistory() {
    if (confirm("Bạn có chắc chắn muốn xóa toàn bộ lịch sử không?")) {
        localStorage.removeItem("interactionHistory");
        renderInteractions();
    }
}

// Gọi khi tải trang
document.addEventListener("DOMContentLoaded", () => {
    if (!localStorage.getItem("interactionHistory")) {
        saveInteractions(MOCK_INTERACTIONS);
    }
    renderInteractions();
});