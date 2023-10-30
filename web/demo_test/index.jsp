<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Danh sách phát</h1>
        <ul id="playlist">
            <form action="SearchController">
                <label for="search">Tìm kiếm:</label>
                <input type="search" id="search" name="search" placeholder="Nhập từ khóa tìm kiếm" />
                <input type="submit" value="Tìm" />
            </form>

            <c:forEach items="${Recommend}" var="song">
                <div action="Songcontroller?songId=${song.id}" style="display: flex; align-items: center">
                    <h3 style="margin-right: 50px">${song.title}</h3>
                    <button><i class="bx bxs-bowl-rice" style="cursor: pointer"></i></button>
                </div>
            </c:forEach>
        </ul>
    </body>
</html>
