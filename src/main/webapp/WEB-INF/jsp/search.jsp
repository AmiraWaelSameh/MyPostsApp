<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
	<title>My Posts</title>
	<link rel="stylesheet" href="/css/loginStyling.css"/>
	<script src="/js/search.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	
	<body>
	    <form action="javascript:search()">
	        Search : <input type="text" id="searchContent" />
	        <button>Search</button>
	    </form>
	    <h3></h3>
	    <font id="emptyMessage"></font>
	    <div id="searchResults">
	    </div>
    	<a href="/home" class="back">Back to home</a>
    </body>

</html>