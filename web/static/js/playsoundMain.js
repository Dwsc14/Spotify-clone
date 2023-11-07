let currentSound = null;
let isPlaying = false;
let intervalId = null;
const seekBar = document.getElementById("seek-bar");

const pauseButton = document.querySelector(".bi.bi-play-circle-fill");
var status = "play";

if (pauseButton) {
    pauseButton.addEventListener("click", function () {
        if (currentSound != null) {
            if (status == "pause") {
                currentSound.play();
                status = "play";
            } else {
                currentSound.pause();
                status = "pause";
            }
        }
    });
}

const playButtons = document.querySelectorAll(".playSong");
playButtons.forEach((button) => {
    button.addEventListener("click", function (event) {
        event.preventDefault();

        const audioPath = this.getAttribute("data-song");
        const songName = this.textContent;
        const songAuthor = this.getAttribute("data-author");

        const src = button.querySelector(".abcbc").src;
        console.log(src);

        if (currentSound) {
            currentSound.stop();
        }

        currentSound = new Howl({
            src: [audioPath],
            onplay: function () {
                console.log("Nhạc đang phát...");
                isPlaying = true;
                intervalId = setInterval(updateTimeAndSeekBar, 1000);
            },
            onpause: function () {
                console.log("Nhạc đã tạm dừng...");
                isPlaying = false;
                clearInterval(intervalId);
            },
            onend: function () {
                console.log("Nhạc đã kết thúc...");
                isPlaying = false;
                clearInterval(intervalId);
                seekBar.value = 0;
            },
        });
        currentSound.play();

        updateFooter(songName, songAuthor, src);
    });
});

function updateFooter(name, author, src) {
    const songName = document.getElementById("songPlaying-details-name");
    const songAuthor = document.getElementById("songPlaying-details-author");
    const img_div = document.getElementsByClassName("songPlaying-img");
    const img = img_div[0].querySelector("img");
    img.src = src;

    songName.textContent = name;
    songAuthor.textContent = author;
}

function updateTimeAndSeekBar() {
    if (isPlaying && currentSound) {
        const currentTime = currentSound.seek();
        const duration = currentSound.duration();
        const percentage = (currentTime / duration) * 100;

        const currentTimeSpan = document.getElementById("current-time");
        currentTimeSpan.textContent = formatTime(currentTime);

        seekBar.value = percentage;

        const totalTimeSpan = document.getElementById("total-time");
        totalTimeSpan.textContent = formatTime(duration);
    }
}

function formatTime(seconds) {
    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = Math.floor(seconds % 60);
    return `${minutes}:${remainingSeconds < 10 ? "0" : ""}${remainingSeconds}`;
}
