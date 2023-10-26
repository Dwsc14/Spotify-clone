var login = document.querySelector(".login");
var signup = document.querySelector(".sign-up");
var forget = document.querySelector(".forget");
var submit = document.querySelector(".button");
var emerald = "#19CC8B";
var red = "#BC3E48";
var yellow = "#B8B136";
var lightGrey = "#515866";
var darkGrey = "#2A2D33";

function toLogin() {
    document.querySelectorAll(".security").forEach(function (element) {
        element.classList.add("hide");
    });
    document.querySelectorAll(".full-name, .retype").forEach(function (element) {
        element.classList.add("ani-hide");
    });
    document.querySelectorAll(".password, .password div").forEach(function (element) {
        element.classList.remove("ani-hide");
    });
    login.classList.add("selected");
    signup.classList.remove("selected");
    forget.style.display = "block";
    login.innerHTML = "Login";
    signup.innerHTML = "Sign Up";
}

function toSignup() {
    document.querySelectorAll(".full-name, .retype, .password").forEach(function (element) {
        element.classList.remove("ani-hide");
    });
    signup.classList.add("selected");
    login.classList.remove("selected");
    forget.style.display = "none";
    login.innerHTML = "Login";
    signup.innerHTML = "Sign Up";
}

function toForget() {
    document.querySelectorAll(".full-name, .full-name div, .retype, .retype div, .password, .password div .forget").forEach(function (element) {
        element.classList.add("ani-hide");
    });
    signup.classList.remove("selected");
    login.classList.add("selected");
    forget.style.display = "none";
    login.innerHTML = "Reset Password";
    signup.innerHTML = "Back";
}

login.addEventListener("click", function () {
    if (!login.classList.contains("selected")) {
        toLogin();
    }
});

signup.addEventListener("click", function () {
    if (document.querySelector(".password").classList.contains("ani-hide")) {
        toLogin();
    } else if (!signup.classList.contains("selected")) {
        toSignup();
    }
});

forget.addEventListener("click", function () {
    toForget();
});
