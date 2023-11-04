<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="static/css/searchPage.css">
    <link rel="stylesheet" href="static/css/sidebar.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>

<body>
    <header>
        <div class="head-bar">
            <div class="left">
                <nav>
                    <div class="for-backward">
                        <i class="bi bi-chevron-left"></i>
                        <i class="bi bi-chevron-right"></i>
                    </div>
                    <div id="myDiv" class="input-search">
                        <form action="../SearchController" method="post">
                            <i class="input-icon bi bi-search"></i>
                            <input type="text" name="txtSearch" id="myInput" placeholder="Search Music...">
                        </form>
                    </div>
                </nav>
            </div>

            <div class="right">
                <nav>
                    <button>Explore Premium</button>
                    <i class="bi bi-bell"></i>
                    <div class="user-profile">
                        <img src="static/img/user.jpg" alt="">
                    </div>
                </nav>
            </div>
        </div>
    </header>

    <article>
        <div class="container">
            <div class="inside">
                <div class="menu">
                    <div class="playList">
                        <p id="type">Songs</p>
                        <div class="list">
                            <a href="#" class="index">
                                <div class="songImg">
                                    <img src="static/img/khongthesay.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">Không Thể Say</p>
                                    <p id="nameAuthor">HIEUTHUHAI</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="menu">
                    <div class="playList">
                        <p id="type">Artists</p>
                        <div class="list">
                            <a href="#" class="index">
                                <div class="usersImg">
                                    <img src="static/img/hieuthuhai.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">HIEUTHUHAI</p>
                                    <p id="nameAuthor">Artist</p>
                                </div>
                            </a>
                            <a href="#" class="index">
                                <div class="usersImg">
                                    <img src="static/img/bray.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">BRAY</p>
                                    <p id="nameAuthor">Artist</p>
                                </div>
                            </a>
                            <a href="#" class="index">
                                <div class="usersImg">
                                    <img src="static/img/andree.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">ANDREE</p>
                                    <p id="nameAuthor">Artist</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="menu">
                    <div class="playList">
                        <p id="type">Profiles</p>
                        <div class="list">
                            <a href="#" class="index">
                                <div class="usersImg">
                                    <img src="static/img/ran.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">Ran Mori</p>
                                    <p id="nameAuthor">Profile</p>
                                </div>
                            </a>
                            <a href="#" class="index">
                                <div class="usersImg">
                                    <img src="static/img/conan.jpg" alt="">
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">Shinichi</p>
                                    <p id="nameAuthor">Profile</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </article>
    <jsp:include page="../mainPage/sidebar.jsp" />
    <jsp:include page="../mainPage/footer.jsp" />
</body>

</html>