<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <div class="form-group">
            <span style="color: green">${successMessage}</span>
        </div>
        <div class="form-group">
            <span style="color: red">${errorMessage}</span>
        </div>
        <form action="login" method="post">
            <div class="form-group">
                <input type="text" name="username" id="username" required placeholder="Please input your username" />
            </div>
            <div class="form-group">
                <input type="password" name="password" id="password" required placeholder="Please input your password" />
            </div>
            <div class="register-link">
                <p>Don't have an account? <a href="register.jsp">Register here</a></p>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
