document.addEventListener("DOMContentLoaded", function () {
    var likeButtons = document.querySelectorAll(".btn-like");
    var popup = document.getElementById("popup");
    var popup1 = document.querySelector(".popup1");
    var popup2 = document.querySelector(".popup2");
    var overlay = document.getElementById("overlay");
    var popup1Visible = false;
    var popup2Visible = false;

    likeButtons.forEach(function (button) {
        button.addEventListener("click", function (event) {
            var isChangeColor = event.currentTarget.classList.contains("change-color");

            console.log(event);

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
        console.log("remove");
    });
});

const popup = document.querySelector(".popup-container");
const open = document.getElementsByClassName("bi bi-plus")[0];

const openChangeProfile = () => {
    console.log(popup);
    popup.style.display = "flex";
};

const closeChangeProfile = () => {
    popup.style.display = "none";
};

open.addEventListener("click", openChangeProfile);
