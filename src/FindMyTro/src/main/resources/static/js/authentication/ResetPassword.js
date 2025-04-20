import {CheckEmail, CheckCode, UpdateAccount} from '../api/Register.js'

const step1 = document.getElementById('step1')
const step2 = document.getElementById('step2')
const step3 = document.getElementById('step3')

const error1 = document.getElementById('error1')
const error2 = document.getElementById('error2')
const error3 = document.getElementById('error3')

// reset password screen
async function isValidEmail() {
    const email = document.getElementById('email').value;
    if (!checkEmailFormat(email)) {
        return;
    }
    const result = await CheckEmail(email, false);
    if (checkExistingEmail(result)) {
        return;
    }
    step1.hidden = true;
    step2.hidden = false;
}

const sendCodeBtn = document.querySelector('.sendCode');
sendCodeBtn.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(error1);
    isValidEmail();
});
/////////////////////////////////////

async function isValidCode() {
    const code = document.getElementById('code').value
    const result = await CheckCode();

    if (code === String(result)) {
        step2.hidden = true;
        step3.hidden = false;
    } else {
        error2.innerHTML = 'Wrong code';
    }
}

const button1 = document.querySelector('.checkCode');
button1.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(error2);
    isValidCode();
});
/////////////////////////////////////

const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,32}$/;

async function isRightPassword() {
    const password = document.getElementById('password').value.trim()
    const retypePassword = document.getElementById('rewrite-password').value.trim()

    if (!password.match(passwordRegex)) {
        error3.innerHTML = 'Password must have 8 to 32 characters and contain special characters'
        return;
    }
    if (password !== retypePassword) {
        error3.innerHTML = 'Password does not match';
        return;
    }

    const email = document.getElementById('email').value.trim()
    const response = UpdateAccount(email, password);
    if ((await response).status === 200) {
        window.location.href = '/login'
    } else {
        error3.innerHTML = (await response).data
    }
}

const button2 = document.querySelector('.create-account')
button2.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(error3);
    isRightPassword();
});
/////////////////////////////////////

function deleteErrContent(err) {
    err.innerHTML = ''
}

function checkEmailFormat(email) {
    const emailRegex = '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'
    if (!email.match(emailRegex)) {
        error1.innerHTML = `Must follow the format <account name>@<domain>`
        return false;
    }
    return true
}

function checkExistingEmail(result) {
    if (result.status === 400) {
        error1.innerHTML = result.response.data
        return true
    }
    return false
}