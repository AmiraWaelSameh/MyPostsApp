<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<title>My Posts</title>
<link rel="stylesheet" href="/css/loginStyling.css"/>
</head>

<body>
    <h1>${user.userName}, here is the list of your Posts:</h1>
    <c:forEach items="${posts}" var="element"> 
    	<ul>${element.content}</ul>
	</c:forEach>
    <form method="post">
        New status : <input type="text" name="postContent" />
        <select name="selectedStatus">
			<c:forEach items="${availableStatuses}" var="status">
			    <option value="${status}">${status}</option>
			</c:forEach>
		</select>
        <button type="submit">Add</button>
        <font color="red">${errorMessage}</font>
    </form>	
    <a href="/home" class="back">Back to home</a>    
</body>

</html>