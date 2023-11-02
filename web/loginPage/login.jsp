<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/login.css">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <div class="modal-wrapper">
            <div class="text-wrapper show">
                <div class="nav">
                    <div class="login">Login</div>
                    <div class="sign-up selected">Sign Up</div>
                </div>
                <form class="full-name" id="first-form">
                    <div class="form-title">Full Name</div>
                    <input class="content"></input>
                </form>
                <form class="email">
                    <div class="form-title">Email</div>
                    <input class="content"></input>
                </form>
                <form class="password">
                    <div class="security hide">
                        <div class="security-type">
                            <div class="security-level"><span class="secureValue"></span>%</div>
                            <div class="secure">secure</div>
                        </div>
                        <div class="fill circle"></div>
                        <div class="cover circle"></div>
                        <div class="background circle"></div>
                    </div>
                    <div class="form-title">Password</div>
                    <input type="password" class="content"></input>
                </form>
                <form class="retype" id="last-form">
                    <div class="form-title">Retype Password</div>
                    <input type="password" class="content"></input>
                </form>
                <div class="button">Submit</div>
                <div class="forget">Forget your password?</div>
            </div>
        </div>
        <div class="overlay"></div>
    </div>

    <script src="static/js/login.js"></script>
</body>

</html>