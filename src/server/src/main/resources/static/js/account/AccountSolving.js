import {Delete} from '../api/account/DeleteAccount.js'

export async function DeleteAccount() {
    const response = await Delete()
    if (response.status === 200) {
        const modal = document.getElementById('deleteAccount')
        const modalInstance = bootstrap.Modal.getInstance(modal);
        if (modalInstance) {
            modalInstance.hide()
        }
        setTimeout(() => {
            window.location.href = '/logout';
        }, 3000)
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const button = document.getElementById('deletebtn')
    if (button) {
        button.addEventListener('click', DeleteAccount)
    }
})