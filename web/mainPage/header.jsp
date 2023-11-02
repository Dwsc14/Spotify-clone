<link rel="stylesheet" href="static/css/header.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<body>
    <header>
        <div class="head-bar">
            <div class="left">
                <nav>
                    <div class="for-backward">
                        <i class="bi bi-chevron-left"></i>
                        <i class="bi bi-chevron-right"></i>
                    </div>
                </nav>
            </div>

            <div class="right">
                <nav>
                    <button>Explore Premium</button>
                    <i class="bi bi-bell"></i>
                    <div class="user-profile">
                        <img src="static/img/user.jpg" alt="">
                    </div>
                </nav>
            </div>
        </div>
    </header>

    <script>
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
    </script>
</body>