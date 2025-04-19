export async function CheckEmail(email) {
    try {
        const response = await axios.post(
            '/verify-email',
            {email: email}
        );
        console.log('CheckEmail: ', response.data)
        return response.data;
    } catch (error) {
        console.log(error)
        return false
    }
}

export async function CheckCode() {
    try {
        const response = await axios.post(
            '/validate-code'
        )
        console.log(response.data)
        return response.data;
    } catch (error) {
        console.log('Register.js: ', error)
    }
}

export async function CreateAccount(email, password, phone) {
    try {
        const response = await axios.post(
            '/create',
            {
                email: email,
                password: password,
                phoneNumber: phone
            }
        )
        return throwData(response)
    } catch (err) {
        if (err.response) {
            console.log('server err: ', err.response) // 400, 500
            return err.response.message
        } else if (err.request) {
            console.log('no response from server: ', err.request)
            return err.request.message
        } else {
            console.error('unexpected: ', err.message)
            return err.message
        }
    }
}

function throwData(data) {
    return {
        status: data.status,
        data: data.data
    }
}