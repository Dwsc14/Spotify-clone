<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> <%@page contentType="text/html" pageEncoding="UTF-8" %>

<article>
    <div class="container">
        <div class="inside">
            <div class="advertise">
                <div class="left">
                    <a href=""><img src="static/img/def_playlist.jpeg" alt="" /></a>
                </div>

                <div class="right">
                    <h5>PLAYLIST</h5>
                    <a href="">Buy Premium</a>
                    <p>I've been looking for this playlist for a long time...</p>
                    <button id="playButton">Play</button>
                    <button id="followButton">Follow</button>
                    <i class="bi bi-three-dots"></i>
                </div>
            </div>
            <div class="menu">
                <div class="playList">
                    <p id="type">Random Song You Might Enjoy</p>
                    <div class="list">
                        <c:forEach items="${Random}" var="song">
                            <a class="song">
                                <div data-author="${song.getUser().getFullName()}" data-song=".${song.getSrc()}" class="songImg playSong">
                                    <img class="abcbc" src=".${song.imagePath}" alt="" />
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">${song.title}</p>
                                    <p id="nameAuthor">${song.getUser().getFullName()}</p>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Latest Songs</p>
                    <div class="list">
                        <c:forEach items="${Recommend}" var="song">
                            <a href="#" class="song">
                                <div data-author="${song.getUser().getFullName()}" data-song=".${song.getSrc()}" class="songImg playSong">
                                    <img class="abcbc" src=".${song.imagePath}" alt="" />
                                </div>
                                <div class="songDetail">
                                    <p id="nameSong">${song.title}</p>
                                    <p id="nameAuthor">${song.getUser().getFullName()}</p>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="space-inside"></div>
        </div>
    </div>
</article>
