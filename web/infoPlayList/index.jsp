<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>SpotyJam</title>
        <link rel="stylesheet" href="static/css/header.css" />
        <link rel="stylesheet" href="static/css/footer.css" />
        <link rel="stylesheet" href="static/css/sidebar.css" />
        <link rel="stylesheet" href="static/css/infoPlayList.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
    </head>

    <body>
        <jsp:include page="../include/header.jsp" />
        <jsp:include page="infoPlayList.jsp" />
        <jsp:include page="../include/sidebar.jsp" />
        <jsp:include page="../include/footer.jsp" />

        <script src="static/js/sidebar.js"></script>
        <script src="static/js/header.js"></script>
        <script src="static/js/infoplaylist.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/howler/2.2.3/howler.min.js"></script>
        <script src="static/js/playsound.js"></script>
    </body>
</html>
