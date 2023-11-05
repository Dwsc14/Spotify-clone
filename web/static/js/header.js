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
