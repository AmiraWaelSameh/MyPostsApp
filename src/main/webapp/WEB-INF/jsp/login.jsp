<html>

<head>
<title>My Posts</title>
<link rel="stylesheet" href="/css/loginStyling.css"/>
</head>

<body>
	<h1>My Posts</h1>
    <form method="post" class="login-form">
        <input type="text" name="name" placeholder="username"/>
        <input type="password" name="password" placeholder="password"/> 
        <button type="submit">Login</button>
    	<font color="red">${errorMessage}</font>
    </form>
</body>

</html>