function send (method, url, data, successCallback, errorCallback) {
    const token = localStorage.getItem("accessToken");
    $.ajax({
        type: method,
        url: url,
        headers: {
            "Authorization": "Bearer " + token
        },
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: successCallback,
        error: function (xhr, status, error) {
            if (xhr.status === 401) {
                // error type 확인
                reIssueAccessToken(function(newAccessToken) {
                    if (newAccessToken) {
                        localStorage.setItem("accessToken", newAccessToken);
                        send(method, url, data, successCallback, errorCallback);
                    } else {
                        errorCallback(xhr, status, error);
                    }
                });
            } else {
                errorCallback(xhr, status, error);
            }
        }
    });
}

function reIssueAccessToken(callback) {
    const token = localStorage.getItem("refreshToken");

    $.ajax({
        type: "POST",
        url: "/refresh-token",
        headers: {
            "Authorization": "Bearer " + token
        },
        success: function (response) {
            callback(response.accessToken);
        },
        error: function (xhr, status, error) {
            console.error("Failed to refresh access token:", xhr.responseText);
            callback(null);
        }
    });
}