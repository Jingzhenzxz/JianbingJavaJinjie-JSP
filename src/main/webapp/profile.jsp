<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h1>User Profile</h1>
        <form action="updateProfile" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" value="${user.username}" required />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" value="${user.password}" required />
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" value="${user.email}" required />
            </div>
            <button type="submit">Update Profile</button>
        </form>
        <form action="logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
