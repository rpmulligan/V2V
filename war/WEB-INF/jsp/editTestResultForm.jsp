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
  $(".addTestResultButton").button({
    icons : {
      primary : 'ui-icon-circle-plus'
    }
  });
  function updateTestResult() {
    addNewTestResult($("#editTestResultForm-" + '<c:out value="${formId}"/>')[0]);
    $("#editTestResultForm-" + '<c:out value="${formId}"/>')[0].reset();
  }

  $("#dateTested-" + '<c:out value="${formId}"/>').datepicker({
    changeMonth : true,
    changeYear : true,
    minDate : -36500,
    maxDate : 0,
    dateFormat : "mm/dd/yy",
    yearRange : "c-100:c0",
  });
  function updateTestResult() {
    addNewTestResult($("#editTestResultForm-" + '<c:out value="${formId}"/>')[0]);
    $("#editTestResultForm-" + '<c:out value="${formId}"/>')[0].reset();
  }
</script>


<form:form method="POST" commandName="editTestResultForm"
	id="editTestResultForm-${formId}">
	<table>
		<thead>
			<c:if test="${model.isDialog != 'yes' }">
				<tr>
					<td><b>Add a New Test Result</b></td>
				</tr>
			</c:if>
			<c:if test="${!(empty model.alternateHeader)}">
				<tr>
					<td><b>${model.alternateHeader}</b></td>
				</tr>
			</c:if>
		</thead>
		<tbody>
			<tr>
				<td><form:label path="collectionNumber">${model.collectionNoDisplayName}</form:label></td>
				<td><form:input path="collectionNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="dateTested">${model.dateTestedDisplayName}</form:label></td>
				<td><form:input path="dateTested" id="dateTested-${formId}" /></td>
			</tr>
			<tr>
				<td><form:label path="hiv">${model.hivDisplayName}</form:label></td>
				<td><form:radiobutton path="hiv" value="reactive"
						label="reactive" class="radioWithToggle" /> <form:radiobutton
						path="hiv" value="negative" label="negative"
						class="radioWithToggle" /></td>
			</tr>
			<tr>
				<td><form:label path="hbv">${model.hbvDisplayName}</form:label></td>
				<td><form:radiobutton path="hbv" value="reactive"
						label="reactive" class="radioWithToggle" /> <form:radiobutton
						path="hbv" value="negative" label="negative"
						class="radioWithToggle" /></td>
			</tr>
			<tr>
				<td><form:label path="hcv">${model.hcvDisplayName}</form:label></td>
				<td><form:radiobutton path="hcv" value="reactive"
						label="reactive" class="radioWithToggle" /> <form:radiobutton
						path="hcv" value="negative" label="negative"
						class="radioWithToggle" /></td>
			</tr>
			<tr>
				<td><form:label path="syphilis">${model.syphilisDisplayName}</form:label></td>
				<td><form:radiobutton path="syphilis" value="reactive"
						label="reactive" class="radioWithToggle" /> <form:radiobutton
						path="syphilis" value="negative" label="negative"
						class="radioWithToggle" /></td>
			</tr>
			<c:if test="${model.isDialog != 'yes' }">
				<tr>
					<td />
					<td><button type="button" class="addTestResultButton" style="margin-left: 10px"
							onclick="updateTestResult();">Add test result</button></td>
				</tr>
			</c:if>
		</tbody>
	</table>
</form:form>
