<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="noticelist.css" type="text/css">
<title>Notice List</title>
</head>
<body>
	<div class="container">
	
	<div class="not_nav">
		<img alt="logo" />
		<a class = "cre_but" href="notice.jsp"><button>Create Notice</button></a>
		</div>
	<div class="head">
		<h1>NOTICES</h1>
	</div>

	<div class="list_con">
		<c:forEach var="notice" items="${listnotices}">
		<div class="not_list">
			<li>
			<div class="dets">
				<h1>${notice.getTitle()}</h1>
				<p class="dat">${notice.getDate()}</p>
				<p class="descri">${notice.getDescription()}</p>
				</div>
				<div class="options">
					<a href="deleteNotice?id=${notice.getId()}"><button>Delete Notice</button></a>
					<a href="EditNotice?id=${notice.getId()}"><button>Edit Notice</button></a>
				</div>
			</li>
		</div>
		</c:forEach>
	</div>
	</div>
</body>
</html>