// script.js
const divElement = document.getElementById("myDiv");
const inputElement = document.getElementById("myInput");

inputElement.addEventListener("focus", function() {
    divElement.style.borderColor = "blue"; // Thay đổi màu viền thành màu xanh khi input được tương tác
});
