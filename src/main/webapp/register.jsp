<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h1>Register</h1>
        <div class="form-group">
            <span style="color: red">${errorMessage}</span>
        </div>
        <form action="register" method="post">
            <div class="form-group">
                <input type="text" name="username" id="username" required placeholder="Please input your username" />
            </div>
            <div class="form-group">
                <input type="password" name="password" id="password" required  placeholder="Please input your password" />
            </div>
            <div class="form-group">
                <input type="text" name="email" id="email" required  placeholder="Please input your email" />
            </div>
            <button type="submit">Register</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>
