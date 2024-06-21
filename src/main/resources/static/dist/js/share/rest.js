function send (method, url, data, headers, successCallback, errorCallback) {
    let clientId = getCookie("clientId");
    if (!getCookie("clientId")) {
        issueClientIdAndSetCookie();
    }

    headers['x-client-id'] = getCookie("clientId");

    const token = localStorage.getItem("access_token");
    if (token) {
        headers['Authorization'] = "Bearer " + token;
    }

    $.ajax({
        type: method,
        url: url,
        headers: headers,
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
    const token = localStorage.getItem("refresh_token");

    $.ajax({
        type: "POST",
        url: "/refresh-token",
        headers: {
            "Authorization": "Bearer " + token
        },
        success: function (response) {
            callback(response.access_token);
        },
        error: function (xhr, status, error) {
            console.error("Failed to refresh access token:", xhr.responseText);
            callback(null);
        }
    });
}

function getCookie(name) {
    const cookieName = name + "=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const cookieArray = decodedCookie.split(';');

    for (let i = 0; i < cookieArray.length; i++) {
        let cookie = cookieArray[i].trim();
        if (cookie.indexOf(cookieName) === 0) {
            return cookie.substring(cookieName.length, cookie.length);
        }
    }
    return null;
}

function issueClientIdAndSetCookie() {
    $.ajax({
        type: "POST",
        url: "/public/v1/commons/client-id", // 클라이언트 ID 발급 엔드포인트
        success: function(response) {
            const clientId = response.contents.result;
            console.log("Client ID issued successfully: " + clientId);


            // 클라이언트 ID를 쿠키로 설정
            // document.cookie = `clientId=${clientId}; max-age=${60 * 60 * 24 * 365}; path=/; Secure; SameSite=Strict`;
            // 이후 필요한 작업 수행 (예: 다음 단계 요청 등)
        },
        error: function(xhr, status, error) {
            console.error("Failed to issue client ID:", error);
        }
    });
}