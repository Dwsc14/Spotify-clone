const inputElement = document.getElementById("myInput");

if (inputElement) {
    inputElement.addEventListener("focus", function () {
        const divElement = document.querySelector("header .head-bar .left nav .input-search::before");
        if (divElement) {
            divElement.style.border = "3px solid blue";
        }
    });

    inputElement.addEventListener("blur", function () {
        const divElement = document.querySelector("header .head-bar .left nav .input-search::before");
        if (divElement) {
            divElement.style.border = "3px solid black";
        }
    });
}
divElement = document.querySelector("header .head-bar .left nav .input-search::before");
console.log(divElement);

document.addEventListener("DOMContentLoaded", function () {
    var imgUser = document.querySelector(".user-profile a");
    var popup = document.getElementById("profilePopup");
    var overlay = document.getElementById("header-overlay");

    imgUser.addEventListener("click", function (event) {
        event.preventDefault();
        popup.style.display = "block";
        overlay.style.display = "block";
    });

    overlay.addEventListener("click", function () {
        popup.style.display = "none";
        overlay.style.display = "none";
    });
});

