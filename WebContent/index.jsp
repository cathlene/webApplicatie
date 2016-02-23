<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/sample.css">
    
    <script type="text/javascript" src="js/addFriend.js"></script>
<title>Insert title here</title>
</head>
  <body onload="loadFriends()">

<header role="banner">
		<img width=100% height=200px alt="Toscane" src="images/right.jpg">
	
	</header>
	<main>
	<article>
	 <h1>Welcome</h1>
      
      <table id="tableFriends">

</table> 
<button onclick="showForm()">Show form</button>
<button onclick="hideForm()">Hide form</button>

<form id="friendForm">
        <p><label for="nickName">nickName</label><input type="text" id="nickName" name="nickName"> </p>
        <p><label for="status">status</label><input type="text" id="status" name="status"> </p>
      <p><input class="button"type="button" id="friendbutton" value="add friend" onclick="addNewFriend();"></p>
      
</form> 
                 
	</article>
	</main>

</body>
</html>