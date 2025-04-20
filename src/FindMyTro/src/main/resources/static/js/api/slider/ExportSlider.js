export async function GetSlider() {
    try {
        const response = await axios.get(
            '/slider/list',
            {
                headers: {
                    "X-Requested-By": "Slider"
                }
            }
        )
        return response.data;
    } catch (err) {
        console.error('err when loading images ', err)
    }
}