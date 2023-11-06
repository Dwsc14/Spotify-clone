<div class="popup-container">
    <div class="popup-card">
        <div class="popup-cardHeader">
            <p>Create Playlist</p>
            <a href="" id="exit"><i class="bi bi-x-lg"></i></a>
        </div>
        <div class="popup-cardBody">
            <div class="popup-cardBody-left">
                <input type="file" name="image" id="uploadImage" accept="image/*" style="display: none" />
                <label for="uploadImage">
                    <img id="previewImage" name="plist-name" src="static/img/def_ava.jpg" alt="Upload Image" />
                </label>
            </div>
            <div class="popup-cardBody-right">
                <div class="changeName">
                    <input type="text" placeholder="Playlist" maxlength="32" />
                </div>
                <div class="popup-cardBody-rightButton">
                    <button id="saveButton">Save</button>
                </div>
            </div>
        </div>
        <div class="popup-cardFooter">
            <p>By continuing, you agree to allow us access to the images you have chosen to upload.</p>
            <p>Please ensure you have permission to upload images.</p>
        </div>
    </div>
</div>

<script>
    var imageData;

    document.getElementById("uploadImage").addEventListener("change", function (event) {
        const selectedImage = event.target.files[0];
        const previewImage = document.getElementById("previewImage");

        if (selectedImage) {
            const reader = new FileReader();
            reader.onload = function (e) {
                previewImage.src = e.target.result;

                imageData = e.target.result;
            };
            reader.readAsDataURL(selectedImage);
        } else {
            previewImage.src = "static/img/def_ava.jpg";
        }
    });

    var save_button = document.getElementById("saveButton");

    save_button.addEventListener("click", function (event) {
        // console.log("Saved");
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "Image", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("image=" + encodeURIComponent(imageData));
    });
</script>
