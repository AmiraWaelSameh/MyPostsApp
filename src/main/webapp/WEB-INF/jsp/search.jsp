<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
	<title>My Posts</title>
	<link rel="stylesheet" href="/css/loginStyling.css"/>
	</head>
	
	<body>
	    <form method="post">
	        Search : <input type="text" name="searchContent" />
	        <button type="submit">Search</button>
	        <font color="red">${errorMessage}</font>
	    </form>
	    <h3>Search Results:</h3>
	    <font color="blue" class="emptyMessage">${emptySearchMessage}</font>
	    <c:forEach items="${posts}" var="element"> 
	    	<ul>"${element.content}" by ${element.user.userName }</ul>
		</c:forEach>
    	<a href="/home" class="back">Back to home</a>
    </body>

</html>