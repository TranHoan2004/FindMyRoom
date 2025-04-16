export function GetData(page, filter) {
    let url = ''
    if (filter !== null) {
        url = 'http://localhost:8080/posts/list?filter=' + filter + '&page=' + page
    } else {
        url = 'http://localhost:8080/posts/list?page=' + page
    }

    return new Promise((resolve, reject) => {
        $.ajax({
            url: url,
            type: 'GET',
            data: {},
            success: function (responseData) {
                resolve(responseData)
            },
            error: function (err) {
                reject(err)
            },
        })
    })
}