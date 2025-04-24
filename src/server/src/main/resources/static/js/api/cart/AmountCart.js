export async function GetAmountCart() {
    try {
        const response = await axios.get(
            '/cart/list',
            {
                headers: {
                    "X-Requested-By": "amount"
                }
            }
        )
        const data = response.data
        console.log(data)
        return data
    } catch (e) {
        console.log(e.message)
    }
}