<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="loginPage/static/css/login.css">
    <title>Document</title>
</head>

<body>

    <c:url value="login" var="loginUrl" />
    
    <div class="container">
        <div class="modal-wrapper">
            <div class="text-wrapper show">
                <div class="nav">
                    <div class="login">Login</div>
                    <div class="sign-up selected">Sign Up</div>
                </div>
                <form action="${loginUrl}" method="post">
                    <div class="full-name form" id="first-form">
                        <div class="form-title">Full Name</div>
                        <input class="content" name="full_name"></input>
                    </div>
                    <div class="email form">
                        <div class="form-title">Email</div>
                        <input class="content" name="email"></input>
                    </div>
                    <div class="password form">
                        <div class="form-title">Password</div>
                        <input type="password" class="content" name="pswd" ></input>
                    </div>
                    <div class="retype form" id="last-form">
                        <div class="form-title">Retype Password</div>
                        <input type="password" class="content" name="repswd"></input>
                    </div>
                    <button class="button" type="submit">Submit</button>
                    <a class="forget">Forget your password?</a>
                </form>
            </div>
        </div>
        <div class="overlay"></div>
    </div>

    <input type="hidden" id="status" value="${status}">

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="<c:url value='loginPage/static/js/login.js' />"></script>
    
</body>

</html>