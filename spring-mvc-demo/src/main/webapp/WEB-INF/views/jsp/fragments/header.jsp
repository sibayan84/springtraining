<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/manufacturers" var="urllistManufacturer" />
<spring:url value="/categories" var="urllistCategory" />
<spring:url value="/products" var="urllistProduct" />
<spring:url value="/dologout" var="urllogout" />
<spring:url value="/categoryAndManufacturer/create" var="urlCategoryAndManufacturer" />
<sec:authentication var="principal" property="principal" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">
			
				<c:if test="${principal != null}">
					<spring:message code="welcome.login" text="default text" />&nbsp;${principal.username}
				</c:if>
				<c:if test="${principal == null}">
					<spring:message code="welcome" text="default text" />
				</c:if> 
					
			</a>
		</div>
		<div id="navbar">
			<c:if test="${principal != null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${urllogout}">logout</a></li>
				</ul>
			</c:if>
			
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="?language=en">English</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="?language=de">German</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">User</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urllistManufacturer}"><spring:message code="manufaturer"/></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlCategoryAndManufacturer}"><spring:message code="categoryAndmanufaturer"/></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urllistProduct}"><spring:message code="product"/></a></li>
			</ul>
		</div>
	</div>
</nav>