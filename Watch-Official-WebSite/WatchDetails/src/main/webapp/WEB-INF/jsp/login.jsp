<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Login - Watch Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form method="post" action="${pageContext.request.contextPath}/Account/Login">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required />

        <button type="submit">Login</button>
    </form>
    <div class="register-link">
        Don't have an account? <a href="${pageContext.request.contextPath}/register.jsp">Register here</a>
    </div>
</div>

</body>
</html>
