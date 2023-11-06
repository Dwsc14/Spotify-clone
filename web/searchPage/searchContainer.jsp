<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<article>
    <div class="container">
        <div class="inside">
            <div class="searchSong">
                <div class="searchSong-type">
                    <p>Songs</p>
                </div>
                <div class="searchSong-row">
                    <div class="searchSong-row-left">
                        <div class="searchSong-row-img">
                            <img src="static/img/def_ava.jpg" alt="">
                        </div>
                        <div class="searchSong-row-details">
                            <a href=""><p id="searchSong-name">Khong The Say</p></a>
                            <a href=""><p id="searchSong-author">HIEUTHUHAI</p></a>
                        </div>
                    </div>
                    <div class="searchSong-row-right">
                        <button class="btn-like">
                            <i class="bi bi-heart-fill"></i>
                        </button>
                    </div>
                </div>

                <!-- bỏ 4 bài -->
                
            </div>
            
            <div class="menu">
                <div class="playList">
                    <p id="type">Playlists</p>
                    <div class="list">
                        <c:forEach items="${searchPlaylist}" var="pl">
                        <a href="#" class="index">
                            <div class="songImg">
                                <img src=".${pl.getImagePath()}" alt="">
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">${pl.getTitle()}</p>
                                <p id="nameAuthor">${pl.getUser().getFullName()}</p>
                            </div>
                        </a>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Artists</p>
                    <div class="list">
                        <c:forEach items="${searchUser}" var="user">
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src=".${user.getImagePath()}" alt="">
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">${user.getFullName()}</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                        </c:forEach>
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