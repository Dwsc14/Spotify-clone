document.addEventListener("DOMContentLoaded", function () {
    var likeButtons = document.querySelectorAll(".btn-like");
    var popup = document.getElementById("popup");
    var popup1 = document.querySelector(".popup1");
    var popup2 = document.querySelector(".popup2");
    var overlay = document.getElementById("overlay");
    var popup1Visible = false;
    var popup2Visible = false;

    var playlist_id;
    var song_id;

    likeButtons.forEach(function (button) {
        button.addEventListener("click", function (event) {
            var isChangeColor = event.currentTarget.classList.contains("change-color");

            playlist_id = event.currentTarget.getAttribute("playlist-id");
            song_id = event.currentTarget.getAttribute("song-id");

            if (isChangeColor) {
                closePopup();
            } else {
                popup.style.display = "block";
                overlay.style.display = "block";

                document.body.style.overflow = "hidden";

                event.currentTarget.classList.add("change-color");
            }
        });
    });

    function closePopup() {
        popup.style.display = "none";
        overlay.style.display = "none";
        document.body.style.overflow = "auto";

        likeButtons.forEach(function (button) {
            button.classList.remove("change-color");
        });

        if (popup1Visible) {
            popup1.style.display = "none";
            popup1Visible = false;
        }

        if (popup2Visible) {
            popup2.style.display = "none";
            popup2Visible = false;
        }
    }

    overlay.addEventListener("click", function (event) {
        if (event.target === overlay) {
            closePopup();
        }
    });

    var addSong = document.getElementById("addSong");
    addSong.addEventListener("click", function () {
        popup1.style.display = "block";
        popup1Visible = true;
        popup2.style.display = "none";
        popup2Visible = false;
    });

    var removeSong = document.getElementById("removeSong");
    removeSong.addEventListener("click", function () {
        var xhr = new XMLHttpRequest();
        var url = "playlist?playlistId=" + playlist_id + "&songId=" + song_id + "&action=del";

        xhr.open("POST", url, true);

        xhr.addEventListener("load", function () {
            if (xhr.status === 200) {
                window.location.reload();
            } else {
            }
        });
        xhr.send();
    });
});
