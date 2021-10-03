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
	
	<h1>Add Category And Manufacturer Together</h1>
	
	<br />

	<spring:url value="/categoryAndManufacturer/" var="cmfActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="cmform" action="${cmfActionUrl}">

		<!--<spring:bind path="category.name">-->
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Category Code</label>
				<div class="col-sm-10">
					<form:input path="category.code" type="text" class="form-control " id="category_code" placeholder="Code" />
					<form:errors path="category.code" class="control-label" />
				</div>
			</div>
		<!--</spring:bind>-->
			
		<spring:bind path="manufacturer.code">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Category Name</label>
				<div class="col-sm-10">
					<form:input path="category.name" type="text" class="form-control " id="category_name" placeholder="Name" />
					<form:errors path="category.name" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="category.desc">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Category Description</label>
				<div class="col-sm-10">
					<form:textarea path="category.desc" type="text" class="form-control " id="category_desc" placeholder="Description" />
					<form:errors path="category.desc" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="manufacturer.code">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Manufacturer Code</label>
				<div class="col-sm-10">
					<form:input path="manufacturer.code" type="text" class="form-control " id="manufacturer_code" placeholder="Code" />
					<form:errors path="manufacturer.code" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="manufacturer.name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Manufacturer Name</label>
				<div class="col-sm-10">
					<form:input path="manufacturer.name" type="text" class="form-control " id="manufacturer_name" placeholder="Code" />
					<form:errors path="manufacturer.name" class="control-label" />
				</div>
			</div>
		</spring:bind>

		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
			</div>
		</div>

	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>