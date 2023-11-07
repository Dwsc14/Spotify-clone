const popup_name = document.querySelector(".changeProfile");
const open = document.getElementById("line2");

const openChangeProfile = () => {
    console.log(popup_name);
    popup_name.style.display = "flex";
};

const closeChangeProfile = () => {
    popup_name.style.display = "none";
};

open.addEventListener("click", openChangeProfile);

var likeButtons = document.querySelectorAll(".btn-like");
var popup = document.getElementById("popup");
var popup1 = document.querySelector(".popup1");
var popup2 = document.querySelector(".popup2");
var overlay = document.getElementById("overlay");
var popup1Visible = false;
var popup2Visible = false;

var songId;
var playlistId;

likeButtons.forEach(function (button) {
    button.addEventListener("click", function (event) {
        var isChangeColor = event.currentTarget.classList.contains("change-color");

        songId = event.currentTarget.getAttribute("song-id");

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
    var url = "playlist?action=del&playlistId=" + playlistId + "&songId=" + songId;

    xhr.open("POST", url, true);

    xhr.send();
    location.reload();
});

var playlistButton = document.getElementsByClassName("sdhjas");
playlistButton = Array.from(playlistButton);
playlistButton.forEach(function (button) {
    button.addEventListener("click", function (event) {
        var pl_id = event.currentTarget.getAttribute("pl-id");

        var xhr = new XMLHttpRequest();
        var url = "playlist?action=add&playlistId=" + pl_id + "&songId=" + songId;

        console.log(url);

        xhr.open("POST", url, true);

        xhr.send();
        location.reload();
    });
});

const popup_add = document.querySelector(".popup-container");
const open_add = document.getElementsByClassName("bi bi-plus")[0];

const openChangeProfileAdd = () => {
    console.log(popup_add);
    popup_add.style.display = "flex";
};

const closeChangeProfileAdd = () => {
    popup_add.style.display = "none";
};

open_add.addEventListener("click", openChangeProfileAdd);
