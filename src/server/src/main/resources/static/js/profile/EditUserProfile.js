console.log(readOnly)

const avatarInput = document.getElementById("avatarInput");
const avatarPreview = document.getElementById("avatarPreview");
const editBtn = document.getElementById("editInfoBtn");
const saveBtn = document.getElementById("saveInfoBtn");
const inputs = document.querySelectorAll("#userInfoForm input, #userInfoForm select");

// Hiển thị trước ảnh đại diện
avatarInput.addEventListener("change", function (event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            avatarPreview.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});

// Bật chế độ chỉnh sửa
editBtn.addEventListener("click", function () {
    inputs.forEach(input => {
        if (input.id !== "avatarInput" && input.id !== 'email') {
            input.removeAttribute("readonly");
            input.removeAttribute("disabled");
        }
    });
    editBtn.classList.add("d-none");
    saveBtn.classList.remove("d-none");
    const field = document.getElementById('emailField')
    field.innerHTML += ' (' + readOnly + ')'
});

document.getElementById("userInfoForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const phone = document.getElementById("phone").value.trim();
    const dob = document.getElementById("dob").value;
    const province = document.getElementById("province").value.trim();
    const district = document.getElementById("district").value.trim();
    const houseNumber = document.getElementById("houseNumber").value.trim();
    const street = document.getElementById("street").value.trim();

    const errors = [];

    const age = getAge(dob);
    if (isNaN(age) || age < 18) {
        errors.push("Bạn phải từ 18 tuổi trở lên.");
    }

    const phoneRegex = /^(0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5]|9[0-9])[0-9]{7}$/;
    if (!phoneRegex.test(phone)) {
        errors.push("Số điện thoại không hợp lệ. Vui lòng nhập đúng định dạng Việt Nam (10 số, bắt đầu bằng 0).");
    }

    if (!province || !district || !houseNumber || !street) {
        errors.push("Vui lòng nhập đầy đủ địa chỉ (Tỉnh/TP, Quận/Huyện, Số nhà, Tên đường).");
    }

    if (errors.length > 0) {
        alert("❌ Lỗi:\n" + errors.join("\n"));
        return;
    }

    alert("✅ Thông tin đã được cập nhật thành công!");
    inputs.forEach(input => {
        input.setAttribute("readonly", true);
        input.setAttribute("disabled", true);
    });
    editBtn.classList.remove("d-none");
    saveBtn.classList.add("d-none");
});

function getAge(dob) {
    const today = new Date();
    const birthDate = new Date(dob);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}

// xu ly mat khau
document.getElementById("changePasswordForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const currentPassword = document.getElementById("currentPassword");
    const newPassword = document.getElementById("newPassword");
    const confirmPassword = document.getElementById("confirmPassword");
    const passwordMessage = document.getElementById("passwordMessage");

    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[.@$!%*?&])[A-Za-z\d.@$!%*?&]{8,}$/;

    let isValid = true;

    document.getElementById("newPasswordFeedback").textContent = "";
    document.getElementById("confirmPasswordFeedback").textContent = "";
    passwordMessage.textContent = "";
    passwordMessage.className = "";

    if (!passwordRegex.test(newPassword.value)) {
        alert("Mật khẩu chưa đáp ứng yêu cầu.");
        document.getElementById("newPasswordFeedback").textContent =
            "Mật khẩu chưa đáp ứng yêu cầu.";
        newPassword.classList.add("is-invalid");
        isValid = false;
    } else {
        newPassword.classList.remove("is-invalid");
    }

    if (newPassword.value !== confirmPassword.value) {
        alert("Mật khẩu xác nhận không khớp.");
        document.getElementById("confirmPasswordFeedback").textContent =
            "Mật khẩu xác nhận không khớp.";
        confirmPassword.classList.add("is-invalid");
        isValid = false;
    } else {
        alert("Mật khẩu xác nhận khớp.");
        confirmPassword.classList.remove("is-invalid");
    }

    if (isValid) {
        passwordMessage.className = "alert alert-success";
        passwordMessage.textContent = "✅ Mật khẩu đã được đổi thành công!";

        setTimeout(() => {
            currentPassword.value = "";
            newPassword.value = "";
            confirmPassword.value = "";
        }, 2000);
    }
});