<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h1>Sign In</h1>
<form action="LoginServlet" method="post">
    <input type="text" name="username" required/>
    <br>
    <input type="password" name="password" required/>
    <br>
    <input type="submit" value="Login" name="login"/>
    <p>${errorMessage}</p>
</form>
</body>
</html>

