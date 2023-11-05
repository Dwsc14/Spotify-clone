<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> <%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="overlay" id="overlay"></div>

<c:if test="${sessionScope.User != null}">
    <div class="popup" id="popup">
        <p id="addSong">Add to playlist</p>
        <p id="removeSong">Remove to playlist</p>
    </div>

    <div class="popup1" id="">
        <p>Create playlist</p>
        <c:forEach items="${playlists}" var="entry">
            <p name="pl-${entry.key}">${entry.value}</p>
        </c:forEach>
    </div>
</c:if>

<div class="popup2" id="">
    <p>My Playlist #1</p>
</div>

<div class="page">
    <div class="space1"></div>

    <div class="container">
        <div class="inside">
            <div class="top">
                <div class="topLeft">
                    <img src="${img}" alt="" />
                </div>

                <div class="topRight">
                    <p id="line1">Public playlist</p>
                    <br />
                    <p id="line2">${title}</p>
                    <br />
                    <p id="line3">${size} songs ..</p>
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
                        <c:forEach items="${songs}" var="song">
                            <tr class="song">
                                <td scope="row">1</td>
                                <td>
                                    <div class="songInfo">
                                        <div class="songImg">
                                            <img src=".${song.getImagePath()}" alt="" />
                                        </div>
                                        <div class="songDetails">
                                            <p>
                                                <a
                                                    href="#"
                                                    class="playSong"
                                                    data-author="${song.getUser().getFullName()}"
                                                    data-song=".${song.getSrc()}"
                                                    >${song.getTitle()}</a
                                                >
                                            </p>
                                            <a href="">${song.getUser().getFullName()}</a>
                                        </div>
                                    </div>
                                </td>
                                <td><a href="">----</a></td>
                                <td></td>
                                <td>-:-</td>
                                <td>
                                    <button playlist-id="${id}" song-id="${song.getId()}" class="btn-like"><i class="bi bi-heart-fill"></i></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="space-inside"></div>
        </div>
    </div>
    <div class="space2"></div>
</div>
