export async function GetAllNotification() {
    try {
        const response = await axios.get(
            '/notification/list'
        )
        return response.data
    } catch (e) {
        console.log(e)
    }
}