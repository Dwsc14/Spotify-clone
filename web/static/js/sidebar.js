const searchIcon = document.getElementById("search-icon");
const searchInput = document.getElementById("search-input");
const recentText = document.getElementById("recent");

searchIcon.addEventListener("click", function () {
    searchInput.classList.toggle("hidden");
    searchInput.focus();

    if (searchInput.className != "hidden") {
        recentText.innerText = "";
    } else {
        recentText.innerText = "Recents";
    }
});
