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

        // Thay đổi màu của btn-like
        likeButtons.forEach(function (button) {
            button.classList.remove("change-color");
        });

        // Đóng popup1 nếu nó đang hiển thị
        if (popup1Visible) {
            popup1.style.display = "none";
            popup1Visible = false;
        }

        // Đóng popup2 nếu nó đang hiển thị
        if (popup2Visible) {
            popup2.style.display = "none";
            popup2Visible = false;
        }
    }

    overlay.addEventListener("click", function (event) {
        // Kiểm tra xem người dùng có ấn vào overlay (ngoài popup) không
        if (event.target === overlay) {
            closePopup();
        }
    });

    // Xử lý khi nhấn vào "Add to playlist"
    var addSong = document.getElementById("addSong");
    addSong.addEventListener("click", function () {
        popup1.style.display = "block";
        popup1Visible = true;
        popup2.style.display = "none";
        popup2Visible = false;
    });

    // Xử lý khi nhấn vào "Remove to playlist"
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
