export async function GetStory() {
    try {
        const data = await axios.get(
            "/story/list",
            {
                headers: {
                    "X-Requested-By": "GetStory"
                }
            }
        )
        console.log(data.data)
        return data.data
    } catch (e) {
        console.log(e.message)
    }
}