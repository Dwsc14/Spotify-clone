<link rel="stylesheet" href="mainPage/static/css/sidebar.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />

<body>
    <div class="sidebar">
        <div class="inside">
            <div class="top">
                <div class="icon">
                    <i class="bi bi-house-door-fill"></i>
                    <i class="bi bi-search"></i>
                </div>

                <div class="icon_text">
                    <span>Home</span>
                    <span>Search</span>
                </div>
            </div>

            <div class="middle">
                <div class="left_middle">
                    <i class="bi bi-music-note-list"></i>
                </div>
                <div class="right_middle">
                    <span>Your List</span>
                    <i class="bi bi-plus"></i>
                    <i class="bi bi-arrow-right-short"></i>
                </div>
            </div>

            <div class="bottom">
                <div class="search_bar">
                    <div class="left">
                        <i class="bi bi-search" id="search-icon"></i>
                        <input type="text" id="search-input" placeholder="Search" class="hidden" />
                    </div>
                    <div class="right">
                        <i class="bi bi-list-ul"></i>
                    </div>
                </div>

                <div class="menu_song">
                    <c:forEach items="${sessionScope.playlist}" var="playlistItem">
                        <div class="songItem">
                            <div class="songImg">
                                <a href=""><img src="mainPage/static/img/bigbang.jpg" alt="BigBang" /></a>
                            </div>
                            <div class="songDetails">
                                <a href="ProfileController?playlist=${playlistItem.value.id}">${playlistItem.value.title}</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="test"></div>
        </div>
    </div>

    <script src="mainPage/static/js/sidebar.js"></script>
</body>
