<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

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
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${manufacturer.id}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${manufacturer.code}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${manufacturer.name}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${manufacturer.address}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${manufacturer.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Phone</label>
		<div class="col-sm-10">${manufacturer.phone}</div>
	</div>


</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>