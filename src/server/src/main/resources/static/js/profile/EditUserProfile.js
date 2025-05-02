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
        errors.push(alert18Older);
    }

    const phoneRegex = /^(0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5]|9[0-9])[0-9]{7}$/;
    if (!phoneRegex.test(phone)) {
        errors.push(alertPhonenumber);
    }

    if (!province || !district || !houseNumber || !street) {
        errors.push(alertAddress);
    }

    if (errors.length > 0) {
        alert("❌ " + errorTitle + ":\n" + errors.join("\n"));
        return;
    }

    alert("✅ " + updateSuccessfully);
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
        alert(passwordNotAccepted1);
        document.getElementById("newPasswordFeedback").textContent =
            passwordNotAccepted1;
        newPassword.classList.add("is-invalid");
        isValid = false;
    } else {
        newPassword.classList.remove("is-invalid");
    }

    if (newPassword.value !== confirmPassword.value) {
        alert(passwordNotAccepted2);
        document.getElementById("confirmPasswordFeedback").textContent =
            passwordNotAccepted2;
        confirmPassword.classList.add("is-invalid");
        isValid = false;
    } else {
        alert(passwordAccepted);
        confirmPassword.classList.remove("is-invalid");
    }

    if (isValid) {
        passwordMessage.className = "alert alert-success";
        passwordMessage.textContent = "✅ " + updatePasswordSuccessfully;

        setTimeout(() => {
            currentPassword.value = "";
            newPassword.value = "";
            confirmPassword.value = "";
        }, 2000);
    }
});