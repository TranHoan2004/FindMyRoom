export async function Delete() {
    try {
        const response = await axios.delete(
            '/user/delete',
            {
                headers: {
                    "X-Requested-By": "deleteAccount"
                }
            }
        )
        console.log(response)
        return response
    } catch (err) {
        console.log(err.message)
        return err
    }
}