<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h1>User Profile</h1>
        <div class="form-group">
            <span style="color: green">${successMessage}</span>
        </div>
        <div class="form-group">
            <span style="color: red">${errorMessage}</span>
        </div>
        <form id="updateProfileForm" action="updateProfile" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" value="${currentUser.username}" required />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" value="${currentUser.password}" required />
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" value="${currentUser.email}" required />
            </div>
        </form>
        <form id="logoutForm" action="logout" method="get"></form>
        <form id="deleteForm" action="delete" method="get"></form>
        <form id="userListForm" action="userList" method="get"></form>

        <div class="button-group">
            <button type="submit" form="updateProfileForm">Update Profile</button>
            <button type="submit" form="logoutForm">Logout</button>
            <button type="submit" form="userListForm">UserList</button>
            <button type="submit" class="delete-btn" form="deleteForm">Delete</button>
        </div>
    </div>
</body>
</html>
