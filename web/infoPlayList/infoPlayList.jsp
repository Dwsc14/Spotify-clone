<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="static/css/infoPlayList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>

<body>
    <div class="overlay" id="overlay"></div>

    <div class="popup" id="popup">
        <p id="addSong">Add to playlist</p>
        <p id="removeSong">Remove to playlist</p>
    </div>

    <div class="popup1" id="">
        <p>Create playlist</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
        <p>My Playlist #1</p>
    </div>

    <div class="popup2" id="">
        <p>My Playlist #1</p>
    </div>

    <div class="page">
        <div class="space1"></div>

        <div class="container">
            <div class="inside">
                <div class="top">
                    <div class="topLeft">
                        <img src="static/img/gdragon.jpg" alt="">
                    </div>

                    <div class="topRight">
                        <p id="line1">Public playlist</p><br>
                        <p id="line2">BIGBANG Radio</p><br>
                        <p id="line3">With G-DRAGON, GD&TOP, BLACKPINK and more</p>
                    </div>
                </div>

                <div class="middle">
                    <div class="middleLeft">
                        <a href=""><i class="bi bi-play-circle-fill" id="startList"></i></a>
                        <a href=""><i class="bi bi-heart" id="loveList"></i></a>
                        <a href=""><i class="bi bi-three-dots" id="threeDot"></i></a>
                    </div>

                </div>

                <div class="bottom">
                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col" id="col5">#</th>
                                <th scope="col" id="col30">Title</th>
                                <th scope="col" id="col30">Album</th>
                                <th scope="col" id="col20">Date added</th>
                                <th scope="col" id="col5"><i class="bi bi-clock"></i></th>
                                <th scope="col" id="col10"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="song">
                                <td scope="row">1</td>
                                <td>
                                    <div class="songInfo">
                                        <div class="songImg">
                                            <img src="static/img/stillLife.jpg" alt="">
                                        </div>
                                        <div class="songDetails">
                                            <p>Still Life</p>
                                            <a href="">BIGBANG</a>
                                        </div>
                                    </div>
                                </td>
                                <td><a href="">Still Life</a></td>
                                <td></td>
                                <td>3:08</td>
                                <td>
                                    <button class="btn-like"><i class="bi bi-heart-fill"></i></button>
                                </td>
                            </tr>
                            <tr class="song">
                                <td scope="row">2</td>
                                <td>
                                    <div class="songInfo">
                                        <div class="songImg">
                                            <img src="static/img/untitled2019.jpg" alt="">
                                        </div>
                                        <div class="songDetails">
                                            <p>Untitled,2014</p>
                                            <a href="">G-DRAGON</a>
                                        </div>
                                    </div>
                                </td>
                                <td><a href="">Kwon Jiyong</a></td>
                                <td></td>
                                <td>3:49</td>
                                <td>
                                    <button class="btn-like"><i class="bi bi-heart-fill"></i></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="space-inside"></div>
            </div>
        </div>
        <div class="space2"></div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var likeButtons = document.querySelectorAll(".btn-like");
            var popup = document.getElementById("popup");
            var popup1 = document.querySelector(".popup1");
            var popup2 = document.querySelector(".popup2");
            var overlay = document.getElementById("overlay");
            var popup1Visible = false;
            var popup2Visible = false;

            likeButtons.forEach(function (button) {
                button.addEventListener("click", function (event) {
                    var isChangeColor = event.currentTarget.classList.contains("change-color");

                    if (isChangeColor) {
                        // Đóng popup và thay đổi màu của btn-like
                        closePopup();
                    } else {
                        // Hiển thị popup và lớp overlay
                        popup.style.display = "block";
                        overlay.style.display = "block";

                        // Khi popup hiển thị, đóng băng màn hình nền bằng cách ngăn scroll
                        document.body.style.overflow = "hidden";

                        // Thay đổi màu của btn-like
                        event.currentTarget.classList.add("change-color");
                    }
                });
            });

            // Hàm để đóng popup và thay đổi màu btn-like
            function closePopup() {
                popup.style.display = "none";
                overlay.style.display = "none";
                document.body.style.overflow = "auto";

                // Thay đổi màu của btn-like
                likeButtons.forEach(function (button) {
                    button.classList.remove("change-color");
                });

                // Đóng popup1 nếu nó đang hiển thị
                if (popup1Visible) {
                    popup1.style.display = "none";
                    popup1Visible = false;
                }

                // Đóng popup2 nếu nó đang hiển thị
                if (popup2Visible) {
                    popup2.style.display = "none";
                    popup2Visible = false;
                }
            }

            overlay.addEventListener("click", function (event) {
                // Kiểm tra xem người dùng có ấn vào overlay (ngoài popup) không
                if (event.target === overlay) {
                    closePopup();
                }
            });

            // Xử lý khi nhấn vào "Add to playlist"
            var addSong = document.getElementById("addSong");
            addSong.addEventListener("click", function () {
                popup1.style.display = "block";
                popup1Visible = true;
                popup2.style.display = "none";
                popup2Visible = false;
            });

            // Xử lý khi nhấn vào "Remove to playlist"
            var removeSong = document.getElementById("removeSong");
            removeSong.addEventListener("click", function () {
                popup2.style.display = "block";
                popup2Visible = true;
                popup1.style.display = "none";
                popup1Visible = false;
            });

        });
    </script>
</body>

</html>