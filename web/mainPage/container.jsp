<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> <%@page contentType="text/html" pageEncoding="UTF-8" %>

<article>
    <div class="container">
        <div class="inside">
            <div class="advertise">
                <div class="left">
                    <a href=""><img src="mainPage/static/img/exo.jpg" alt="" /></a>
                </div>

                <div class="right">
                    <h5>PLAYLIST</h5>
                    <a href="">Let Me In</a>
                    <p>I've been looking for this playlist for a long time...</p>
                    <button id="playButton">Play</button>
                    <button id="followButton">Follow</button>
                    <i class="bi bi-three-dots"></i>
                </div>
            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Recent Played</p>
                    <div class="list">
                        <a href="#" class="song">
                            <div class="songImg">
                                <img src="mainPage/static/img/bigbang.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Bang Bang Bang</p>
                                <p id="nameAuthor">Big Bang</p>
                            </div>
                        </a>

                        <a href="#" class="song">
                            <div class="songImg">
                                <img src="mainPage/static/img/nct.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Glitch Mode</p>
                                <p id="nameAuthor">NCT</p>
                            </div>
                        </a>

                        <a href="#" class="song">
                            <div class="songImg">
                                <img src="mainPage/static/img/blackpink.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Boombayah</p>
                                <p id="nameAuthor">BlackPink</p>
                            </div>
                        </a>

                        <a href="#" class="song">
                            <div class="songImg">
                                <img src="mainPage/static/img/exo.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Love Shot</p>
                                <p id="nameAuthor">EXO</p>
                            </div>
                        </a>

                        <a href="#" class="song">
                            <div class="songImg">
                                <img src="mainPage/static/img/bts.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Love Yourself</p>
                                <p id="nameAuthor">BTS</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Random Song You Might Enjoy</p>
                    <div class="list">
                        <c:forEach items="${Random}" var="song">
                            <a href="#" class="song">
                                <div class="songImg">
                                    <img src=".${song.imagePath}" alt="" />
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
                                <div class="songImg">
                                    <img src=".${song.imagePath}" alt="" />
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
