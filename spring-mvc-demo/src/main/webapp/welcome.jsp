<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>


<body>

	<spring:url value="/dologin" var="loginUrl" />

	<nav class="navbar navbar">
		<div class="container">
			<c:if test="${param.logoutSuccessFlag==1}">
				<strong>Successfully logged out</strong>
			</c:if>
			<div class="alert alert-${css} alert-dismissible" role="alert">
				Welcome To Spring MVC Demo</div>
			<div class="alert alert-${css} alert-dismissible" role="alert">
				We will learn the following
				<ul>
					<li>Spring MVC</li>
					<li>Form Binding</li>
					<li>Spring Security</li>
					<li>Spring Localization</li>
					<li>Spring Interceptors</li>
				</ul>
			</div>
			<div class="alert alert-${css} alert-dismissible" role="alert">
				Please Login to learn more
				<button class="btn btn-info" onclick="location.href='${loginUrl}'">Login</button>
			</div>
		</div>
	</nav>
</body>
</html>