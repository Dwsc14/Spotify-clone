<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<c:set var="plist" value="${sessionScope.playlist}" />
<c:set var="newPlaylist" value="${plist}" />
<aside>
    <div class="inside">
        <div class="top">
            <div class="icon">
                <a href="home"><i class="bi bi-house-door-fill"></i></a>
                <i class="bi bi-search"></i>
            </div>

            <div class="icon_text">
                <a href="home"><span>Home</span></a>
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
                <c:forEach items="${newPlaylist}" var="playlistEntry">
                    <div class="songItem">
                        <div class="songImg">
                            <a href="playlist?playlistId=${playlistEntry.value.getId()}"
                                ><img src="${playlistEntry.value.getImagePath()}" alt="BigBang"
                            /></a>
                        </div>
                        <div class="songDetails">
                            <a href="ProfileController?playlist=${playlistEntry.value.getId()}">${playlistEntry.value.getTitle()}</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="test"></div>
    </div>
</aside>
