<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
	<title>My Posts</title>
	</head>
	
	<body>
	    <font color="red">${errorMessage}</font>
	    <form method="post">
	        Search : <input type="text" name="searchContent" />
	        <input type="submit" />
	    </form>
	    <BR/> 
	    <font color="blue">${emptySearchMessage}</font>
	    <c:forEach items="${posts}" var="element"> 
	  		<tr>
	    	<ul>"${element.content}" by ${element.user.userName }</ul>
		</c:forEach>
	    <BR/>
	    <BR/> 
    	<a href="/home">Back to home</a>
    </body>

</html>