<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="static/css/header.css" />
        <link rel="stylesheet" href="static/css/footer.css" />
        <link rel="stylesheet" href="static/css/sidebar.css" />
        <link rel="stylesheet" href="static/css/main_container.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />

        <title>SpotyJam</title>
    </head>

    <body>
        <jsp:include page="popup.jsp" />
        <jsp:include page="../include/header.jsp" />
        <jsp:include page="container.jsp" />
        <jsp:include page="../include/sidebar.jsp" />
        <jsp:include page="../include/footer.jsp" />

        <script src="static/js/sidebar.js"></script>
        <script src="static/js/playsoundMain.js"></script>
        <script src="static/js/header.js"></script>

        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/howler/2.2.4/howler.min.js"
            integrity="sha512-xi/RZRIF/S0hJ+yJJYuZ5yk6/8pCiRlEXZzoguSMl+vk2i3m6UjUO/WcZ11blRL/O+rnj94JRGwt/CHbc9+6EA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
        ></script>

        <script>
            const popup = document.querySelector(".popup-container");
            const open = document.getElementsByClassName("bi bi-plus")[0];

            const openChangeProfile = () => {
                console.log(popup);
                popup.style.display = "flex";
            };

            const closeChangeProfile = () => {
                popup.style.display = "none";
            };

            open.addEventListener("click", openChangeProfile);
        </script>
    </body>
</html>
