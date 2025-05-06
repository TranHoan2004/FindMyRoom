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
        return response.data
    } catch (e) {
        console.log(e.message)
    }
}