import {CheckEmail, CheckCode, CreateAccount} from '../api/Register.js'

const step1 = document.getElementById('step1')
const step2 = document.getElementById('step2')
const step3 = document.getElementById('step3')

const err1 = document.getElementById('err1')
const err2 = document.getElementById('err2')
const err3 = document.getElementById('err3')

// register screen
async function isValidEmail() {
    const email = document.getElementById('email').value;
    if (!checkEmailFormat(email)) {
        return;
    }
    const result = await CheckEmail(email, true);
    if (!checkExistingEmail(result)) {
        return
    }
    step1.hidden = true;
    step2.hidden = false;
}

const button = document.querySelector('.getCode');
button.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(err1);
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
        err2.innerHTML = 'Wrong code';
    }
}

const button1 = document.querySelector('.getCode1');
button1.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(err2);
    isValidCode();
});
/////////////////////////////////////

const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,32}$/;
const phoneRegex = /^0[3-9][0-9]{8}$/

async function isRightPassword() {
    const password = document.getElementById('password').value.trim()
    const retypePassword = document.getElementById('rewrite-password').value.trim()
    const phone = document.getElementById('phone-number').value.trim()

    if (!password.match(passwordRegex)) {
        err3.innerHTML = 'Password must have 8 to 32 characters and contain special characters'
        return;
    }
    if (password !== retypePassword) {
        err3.innerHTML = 'Password does not match';
        return;
    }
    if (!phone.match(phoneRegex)) {
        err3.innerHTML = 'Wrong phone number format'
        return
    }

    const email = document.getElementById('email').value.trim()
    const response = CreateAccount(email, password, phone);
    if ((await response).status === 200) {
        window.location.href = '/login'
    } else {
        err3.innerHTML = (await response).data
    }
}

const button2 = document.querySelector('.create-account')
button2.addEventListener('click', (event) => {
    event.preventDefault();
    deleteErrContent(err3);
    isRightPassword();
});
/////////////////////////////////////

function deleteErrContent(err) {
    err.innerHTML = ''
}

function checkEmailFormat(email) {
    const emailRegex = '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'
    if (!email.match(emailRegex)) {
        err1.innerHTML = `Must follow the format <account name>@<domain>`
        return false;
    }
    return true
}

function checkExistingEmail(result) {
    console.log(result.status)
    // console.log(result.response.data)
    if (result.status === 400) {
        err1.innerHTML = result.response.data
        console.log(err1)
        return false
    }
    return true
}