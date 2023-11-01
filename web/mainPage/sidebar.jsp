<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="mainPage/static/css/sidebar.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" />
    </head>

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

                <div class="middle_search">
                    <div class="search_bar">
                        <div class="left">
                            <i class="bi bi-search" id="search-icon"></i>
                            <input type="text" id="search-input" placeholder="Search" class="hidden" />
                        </div>
                        <div class="right">
                            <span id="recent">Recents</span>
                            <i class="bi bi-list-ul"></i>
                        </div>
                    </div>
                </div>

                <div class="bottom">
                    <div class="menu_song">
                        <div class="songItem">
                            <div class="songImg">
                                <img src="static/img/bigbang.jpg" alt="BigBang" />
                            </div>
                            <div class="songDetails">
                                <span>Bang Bang Bang</span>
                            </div>
                        </div>

                        <div class="songItem">
                            <div class="songImg">
                                <img src="static/img/bigbang.jpg" alt="BigBang" />
                            </div>
                            <div class="songDetails">
                                <span>Bang Bang Bang</span>
                            </div>
                        </div>

                        <div class="songItem">
                            <div class="songImg">
                                <img src="static/img/bigbang.jpg" alt="BigBang" />
                            </div>
                            <div class="songDetails">
                                <span>Bang Bang Bang</span>
                            </div>
                        </div>

                        <div class="songItem">
                            <div class="songImg">
                                <img src="static/img/bigbang.jpg" alt="BigBang" />
                            </div>
                            <div class="songDetails">
                                <span>Bang Bang Bang</span>
                            </div>
                        </div>
                    </div>
                </div>

            <div class="resizer" id="resizer"></div>
        </div>
        <script src="static/js/sidebar.js"></script>
    </body>
</html>
