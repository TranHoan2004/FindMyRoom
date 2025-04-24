export async function GetAllNotification() {
    try {
        const response = await axios.get(
            '/notification/list'
        )
        const data = response.data
        console.log(data)
        return data
    } catch (e) {
        console.log(e)
    }
}