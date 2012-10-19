<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!public long getCurrentTime() {
		return System.nanoTime();
	}%>

<c:set var="formId"><%=getCurrentTime()%></c:set>


<script>
  $(".addCollectionButton").button({
    icons : {
      primary : 'ui-icon-circle-plus'
    }
  });
  $("#editCollectionFormCenters-" + '<c:out value="${formId}"/>').multiselect({
    multiple : false,
    selectedList : 1,
    header : false
  });
  $("#editCollectionFormSites-" + '<c:out value="${formId}"/>').multiselect({
    multiple : false,
    selectedList : 1,
    header : false
  });
  $("#editCollectionFormDonorType-" + '<c:out value="${formId}"/>')
      .multiselect({
        multiple : false,
        selectedList : 1,
        header : false
      });
  function updateCollection() {
    addNewCollection($("#editCollectionForm-" + '<c:out value="${formId}"/>')[0]);
    $("#editCollectionForm-" + '<c:out value="${formId}"/>')[0].reset();
  }
</script>


<form:form method="POST" commandName="editCollectionForm"
	id="editCollectionForm-${formId}">
	<div class="editDialog">
		<c:if test="${model.isDialog != 'yes' }">
			<div>
				<b>Add a new collection</b>
			</div>
		</c:if>
		<div>
			<form:label path="collectionNumber">${model.collectionNoDisplayName}</form:label>
			<form:input path="collectionNumber" />
		</div>
		<div>
			<form:label path="donor">${model.donorNoDisplayName}</form:label>
			<form:input path="donor" />
		</div>
		<div>
			<form:label path="shippingNumber">${model.shippingNoDisplayName}</form:label>
			<form:input path="shippingNumber" />
		</div>
		<div>
			<form:label path="sampleNumber">${model.sampleNoDisplayName}</form:label>
			<form:input path="sampleNumber" />
		</div>
		<div>
			<form:label path="centers">${model.centerDisplayName}</form:label>
			<form:select path="centers"
					id="editCollectionFormCenters-${formId}"
					class="editCollectionFormCenters">
					<c:forEach var="center" items="${model.centers}">
						<form:option value="${center}" label="${center}"
							selected="${center == model.selectedCenter ? 'selected' : ''}" />
					</c:forEach>
				</form:select>
		</div>
		<div>
			<form:label path="sites">${model.siteDisplayName}</form:label>
			<form:select path="sites"
					id="editCollectionFormSites-${formId}"
					class="editCollectionFormSites">
					<c:forEach var="site" items="${model.sites}">
						<form:option value="${site}" label="${site}"
							selected="${site == model.selectedSite ? 'selected' : ''}" />
					</c:forEach>
				</form:select>
		</div>
		<div>
			<form:label path="donorType">${model.donorTypeDisplayName}</form:label>
			<form:select path="donorType"
					id="editCollectionFormDonorType-${formId}"
					class="editCollectionFormDonorType">
					<form:option value="voluntary" label="Voluntary" />
					<form:option value="family" label="Family" />
					<form:option value="other" label="Other" />
				</form:select>
		</div>
		<c:if test="${model.isDialog != 'yes' }">
			<div>
				<button type="button" class="addCollectionButton"
						style="margin-left: 10px" onclick="updateCollection();">Add
						collection</button>
			</div>
		</c:if>
	</div>
</form:form>
