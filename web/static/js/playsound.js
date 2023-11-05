let currentSound = null;

const playButtons = document.querySelectorAll(".playSong");
playButtons.forEach((button) => {
    button.addEventListener("click", function (event) {
        event.preventDefault();
        const audioPath = this.getAttribute("data-song");
        const songName = this.value;
        const songAuthor = this.getAttribute("data-author");

        if (currentSound) {
            currentSound.stop();
        }

        currentSound = new Howl({
            src: [audioPath],
        });
        currentSound.play();

        updateFooter(songName, songAuthor);
    });
});

function updateFooter(name, author) {
    const songName = document.getElementById("songPlaying-details-name");
    const songAuthor = document.getElementById("songPlaying-details-author");

    songName.textContent = name;
    songAuthor.textContent = author;
}
