<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="noticelist.css" type="text/css">
<title>create or insert</title>
</head>
<body>
<div class="notice_con">
	<div class="not_nav">
		<img alt="logo" />
		<a class="bck_btn" href="<%=request.getContextPath()%>/listNotice"><button>Back to Notices</button></a>
	</div>

		
	<c:if test='${existnotice != null}'>
		<h1 class="not_type">EDIT NOTICE</h1>
	</c:if>

	<c:if test='${existnotice == null}'>
		<h1 class="not_type">CREATE NOTICE</h1>
	</c:if>
	
	<div class="create_not_con">
	<div class="not_show">
		<span><input id="show_head"></span>
		<span><input id="show_dat"></span>
		<span><input id="show_det"></span>
	</div>
	
	<div class="not_form">
	<c:if test='${existnotice != null}'>
		<form method="get" action="updateNotice">
	</c:if>

	<c:if test='${existnotice == null}'>
		<form method="post" action="insert">
	</c:if>

	<c:if test='${existnotice !=null }'>
		<input type="hidden" name="id" value='${existnotice.id}'/>
	</c:if>

					<h2>Enter Title</h2>
					<input type="text" name="title" value ='${existnotice.getTitle()}' id="head">
					<h2>Enter Date</h2>
					<input type="date" name="date" value = '${existnotice.getDate()}' id="dat">
					<h2>Enter Details</h2>
					<input type="text" name="details" value = '${existnotice.getDescription()}' id="det">
					<button type="submit">save</button>
	</form>
	</div>
	</div>
	</div>
	<script src="notice.js"></script>
</body>
</html>