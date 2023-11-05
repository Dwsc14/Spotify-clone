const popup = document.querySelector(".changeProfile");
const open = document.getElementById("line2");

const openChangeProfile = () => {
    console.log(popup);
    popup.style.display = "flex";
};

const closeChangeProfile = () => {
    popup.style.display = "none";
};

open.addEventListener("click", openChangeProfile);
