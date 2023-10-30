<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Document</title>
    </head>
    <body>
        <c:forEach items="${sessionScope.playlist}" var="playlistItem">
            <a href="ProfileController?playlist=${playlistItem.value.id}">${playlistItem.value.title}</a>
            <br>
        </c:forEach>

        <div id="playlist">
        <c:forEach items="${songs}" var="song">
                <h2>${song.title}</h2>
                <p>Artist: ${song.user.fullName}</p>

                <img width="300" height="300" src=".${song.imagePath}" alt="">

                <audio controls=""><source src=".${song.src}" type="audio/mpeg"></audio>
        </c:forEach>    
        </div>


        <!-- <script>
            const playlist = document.getElementById("playlist");
            const audioElements = playlist.querySelectorAll("audio");
            let currentSongIndex = 0;

            function playNextSong() {
                if (currentSongIndex < audioElements.length) {
                    audioElements[currentSongIndex].addEventListener("ended", playNextSong);
                    audioElements[currentSongIndex].play();
                    currentSongIndex++;
                }
            }

            playNextSong(); 
        </script> -->
    </body>
</html>
