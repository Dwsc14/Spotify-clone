<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<article>
    <div class="overlay" id="overlay"></div>

    <c:if test="${sessionScope.User != null}">
        <div class="popup" id="popup">
            <p id="addSong">Add to playlist</p>
            <p id="removeSong">Remove to playlist</p>
        </div>

        <div class="popup1" id="">
            <p>Add to playlist</p>
            <c:forEach items="${playlists}" var="entry">
                <c:if test="${entry.key != id}">
                    <p class="sdhjas" pl-id="${entry.key}">${entry.value}</p>
                </c:if>
            </c:forEach>
        </div>
    </c:if>


    <div class="container">
        <div class="inside">
            <c:if test="${usr != null}">
            <div class="userInfo">
                <div class="userAva">
                    <img src=".${usr.getImg()}" alt="" />
                </div>

                <div class="userName">
                    <p id="line1">Profile</p>
                    <a class="change-profile" id="line2">${usr.getFullName()}</a>
                    <p id="line3">... Public Playlist</p>
                </div>
            </div>
            </c:if>
                    
            <div class="userProfile-song">
                <div class="userProfile-song-title">
                    <p>Song</p>
                </div>
                <c:forEach items="${songOfUser}" var="sOfu">
                <div class="userProfile-song-each">
                    <div class="userProfile-song-left">
                        <div class="userProfile-song-img">
                            <img src=".${sOfu.getImagePath()}" alt="">
                        </div>
                        <div class="userProfile-song-details">
                            <a href="">
                                <p id="userProfile-song-name">${sOfu.getTitle()}</p>
                            </a>
                            <a href="">
                                <p id="userProfile-song-author">${sOfu.getUser().getFullName()}</p>
                            </a>
                        </div>
                    </div>
                    <div class="userProfile-song-right">
                        <button song-id="${sOfu.getId()}" class="btn-like">
                            <i  class="bi bi-heart-fill"></i>
                        </button>
                    </div>
                </div>
                </c:forEach>

            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Top artists this month</p>
                    <div class="list">
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">HIEUTHUHAI</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">HIEUTHUHAI</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">HIEUTHUHAI</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">HIEUTHUHAI</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                        <a href="#" class="index">
                            <div class="usersImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">HIEUTHUHAI</p>
                                <p id="nameAuthor">Artist</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="menu">
                <div class="playList">
                    <p id="type">Public Playlists</p>
                    <div class="list">
                        <a href="#" class="index">
                            <div class="songImg">
                                <img src="static/img/def_ava.jpg" alt="" />
                            </div>
                            <div class="songDetail">
                                <p id="nameSong">Khong The Say</p>
                                <p id="nameAuthor">HIEUTHUHAI</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="space-inside"></div>
        </div>
</article>