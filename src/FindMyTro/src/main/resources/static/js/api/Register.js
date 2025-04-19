export async function CheckEmail(email, type) {
    try {
        const response = await axios.post(
            '/verify-email',
            {
                email: email,
                type: type
            }
        );
        return throwData(response)
    } catch (error) {
        console.log('Err: ', error)
        return error
    }
}

export async function CheckCode() {
    try {
        const response = await axios.post(
            '/validate-code'
        )
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

export async function UpdateAccount(email, password) {
    try {
        const response = await axios.put(
            '/update',
            {
                email: email,
                password: password
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