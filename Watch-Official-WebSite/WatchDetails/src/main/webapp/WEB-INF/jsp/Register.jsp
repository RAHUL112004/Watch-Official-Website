<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration</h2>

<form id="registerForm">
    <label>Name:</label>
    <input type="text" id="name" required><br><br>

    <label>Email:</label>
    <input type="email" id="email" required><br><br>

    <label>Number:</label>
    <input type="text" id="number" required><br><br>

    <label>Password:</label>
    <input type="password" id="password" required><br><br>

    <button type="submit">Register</button>
</form>

<script>
    console.log("JS loaded");

    document.getElementById("registerForm").addEventListener("submit", function (event) {
        event.preventDefault();

        const userData = {
            name: document.getElementById("name").value,
            email: document.getElementById("email").value,
            number: document.getElementById("number").value,
            password: document.getElementById("password").value
        };

        fetch("${pageContext.request.contextPath}/Account/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
        .then(response => response.text())
        .then(data => {
            alert("Response: " + data);
        })
        .catch(error => {
            alert("Error: " + error.message);
        });
    });
</script>

</body>
</html>
