<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h1>User List</h1>
        <table>
            <thead>
                <tr>
                    <th>Username</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
