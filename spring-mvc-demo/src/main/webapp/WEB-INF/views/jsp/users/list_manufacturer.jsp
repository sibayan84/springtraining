<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>
    
	<spring:url value="/manufacturers/showform" var="createmfUrl" />

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1><spring:message code="title_listmanufacturer"/></h1>
        <button class="btn btn-info" onclick="location.href='${createmfUrl}'"><spring:message code="create"/></button>
        
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Code</th>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone</th>
				</tr>
			</thead>

			<c:forEach var="mf" items="${manufacturers}">
				<tr>
					<td>${mf.id}</td>
					<td>${mf.code}</td>
					<td>${mf.address}</td>
					<td>${mf.email}</td>
					<td>${mf.phone}</td>
					<td>
						<spring:url value="/manufacturers/${mf.id}/list" var="querymfUrl" />
						<spring:url value="/manufacturers/${mf.id}/delete" var="deletemfUrl" /> 
						<spring:url value="/manufacturers/${mf.id}/showform" var="updatemfUrl" />
						<button class="btn btn-info" onclick="location.href='${querymfUrl}'"><spring:message code="query"/></button>
						<button class="btn btn-primary" onclick="location.href='${updatemfUrl}'"><spring:message code="update"/></button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deletemfUrl}')"><spring:message code="delete"/></button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>