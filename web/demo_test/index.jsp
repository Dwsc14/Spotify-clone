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

            <div id="popup" style="display: none; position: absolute; background-color: #fff; border: 1px solid #ccc; padding: 10px">
                <span id="playlistName" data-playlist=""></span>
                <ul>
                    <li><a href="#" data-playlist="Playlist 1">Playlist 1</a></li>
                    <li><a href="#" data-playlist="Playlist 2">Playlist 2</a></li>
                    <li><a href="#" data-playlist="Playlist 3">Playlist 3</a></li>
                </ul>
            </div>

            <c:forEach items="${playlist}" var="pl">
                <p>${pl.value}</p>
            </c:forEach>

            <c:forEach items="${Recommend}" var="song">
                <div id="song+${song.id}" style="display: flex; align-items: center">
                    <h3 style="margin-right: 50px">${song.title}</h3>
                    <button class="song-button" data-songid="${song.id}">
                        <i class="bx bxs-bowl-rice" style="cursor: pointer"></i>
                    </button>
                </div>
            </c:forEach>
        </ul>
        <script>
            var buttons = document.querySelectorAll(".song-button");
            var popup = document.getElementById("popup");
            var playlistName = document.getElementById("playlistName");

            buttons.forEach(function (button) {
                button.addEventListener("click", function (event) {
                    var songId = event.currentTarget.getAttribute("data-songid");
                    var rect = event.currentTarget.getBoundingClientRect();
                    popup.style.display = "block";
                    popup.style.top = rect.top + window.scrollY + "px";
                    popup.style.left = rect.right + window.scrollX + "px";

                    var playlistLinks = popup.querySelectorAll("ul li a");
                    playlistLinks.forEach(function (link) {
                        link.addEventListener("click", function (event) {
                            event.preventDefault();
                            var playlist = event.currentTarget.getAttribute("data-playlist");
                            playlistName.setAttribute("data-playlist", playlist);
                            playlistName.textContent = "Playlist: " + playlist;

                            var url = "Songcontroller?songId=" + songId + "&playlist=" + playlist;

                            var xhr = new XMLHttpRequest();
                            xhr.open("GET", url, true);
                            xhr.send();

                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4 && xhr.status === 200) {
                                    // Xử lý phản hồi từ servlet nếu cần
                                }
                            };
                        });
                    });
                });
            });

            document.addEventListener("click", function (event) {
                if (!popup.contains(event.target) && !Array.from(buttons).some((button) => button.contains(event.target))) {
                    popup.style.display = "none";
                }
            });
        </script>
    </body>
</html>
