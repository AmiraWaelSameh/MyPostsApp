<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<title>My Posts</title>
</head>

<body>
    ${user.userName}, here are the list of your Posts:
    <BR/> 
    <c:forEach items="${posts}" var="element"> 
  		<tr>
    	<ul>${element.content}</ul>
	</c:forEach>
    <BR/>
    <BR/> 
    <form method="post">
        New status : <input type="text" name="postContent" />
        <select name="selectedStatus">
		<c:forEach items="${availableStatuses}" var="status">
		    <option value="${status}">${status}</option>
		</c:forEach>
		</select>
        <input type="submit" />
    </form>	
	<BR/>
	<BR/> 
    <a href="/home">Back to home</a>    
</body>

</html>