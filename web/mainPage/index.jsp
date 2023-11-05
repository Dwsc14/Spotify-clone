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
        <jsp:include page="../include/header.jsp" />
        <jsp:include page="container.jsp" />
        <jsp:include page="../include/sidebar.jsp" />
        <jsp:include page="../include/footer.jsp" />

        <script src="static/js/sidebar.js"></script>
        <script src="static/js/header.js"></script>
    </body>
</html>
