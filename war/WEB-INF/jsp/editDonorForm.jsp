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
  $(".addDonorButton-" + '<c:out value="${formId}"/>').button({
    icons : {
      primary : 'ui-icon-circle-plus'
    }
  });
  $("#updateDonorBirthDate-" + '<c:out value="${formId}"/>').datepicker({
    changeMonth : true,
    changeYear : true,
    minDate : -36500,
    maxDate : 0,
    showOn : "button",
    buttonImage : "images/calendar.gif",
    buttonImageOnly : true,
    yearRange : "c-100:c0"
  });

  $("#editDonorFormGender-" + '<c:out value="${formId}"/>').multiselect({
    multiple : false,
    selectedList : 1,
    header : false
  });

  $("#editDonorFormBloodGroup-" + '<c:out value="${formId}"/>').multiselect({
    multiple : false,
    selectedList : 1,
    header : false
  });
  function updateDonor() {
    addNewDonor($("#editDonorForm-" + '<c:out value="${formId}"/>')[0]);
    //$("#editDonorForm-" + '<c:out value="${formId}"/>')[0].reset();
  }
</script>

<form:form method="POST" commandName="editDonorForm" modelAttribute="editDonorForm"
	id="editDonorForm-${formId}">
	<form:errors path="*" ></form:errors>
	<div class="editDialog">
		<c:if test="${model.isDialog != 'yes' }">
			<div>
				<b>Add a Donor</b>
			</div>
		</c:if>
		<div>
			<form:label path="donorNumber">Donor Number</form:label>
			<form:input path="donorNumber" />
			<form:errors path="donor.donorNumber" ></form:errors>
		</div>
		<div>
			<form:label path="firstName">${model.firstNameDisplayName}</form:label>
			<form:input path="firstName" />
			<form:errors path="donor.firstName"></form:errors>
		</div>
		<div>
			<form:label path="middleName">Middle Name</form:label>
			<form:input path="middleName" />
			<form:errors path="middleName"></form:errors>
		</div>
		<div>
			<form:label path="lastName">${model.lastNameDisplayName}</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName"></form:errors>
		</div>
		<div>
			<form:label path="birthDate">${model.dobDisplayName}</form:label>
			<form:input path="birthDate" id="updateDonorBirthDate-${formId}" />
			<form:errors path="birthDate"></form:errors>
		</div>
		<div>
			<form:label path="gender">${model.genderDisplayName}</form:label>
			<form:select path="gender" id="editDonorFormGender-${formId}">
				<form:option value="male" label="Male" />
				<form:option value="female" label="Female" />
			</form:select>
			<form:errors path="gender"></form:errors>
		</div>
		<div>
			<label for="bloodAbo">Blood Group</label> <select
				id="editDonorFormBloodGroup-${formId}" name="bloodAbo">
				<option value="A">A+</option>
				<option value="A-">A-</option>
				<option value="B+">B+</option>
				<option value="B-">B-</option>
				<option value="AB+">AB+</option>
				<option value="AB-">AB-</option>
				<option value="O+">O+</option>
				<option value="O-">O-</option>
			</select>
			<form:errors path="bloodAbo"></form:errors>
		</div>
		<div>
			<form:label path="address"
				style="vertical-align: top; padding-top: 40px; display: inline-block;">
				${model.addressDisplayName}
			</form:label>
			<form:textarea path="address" id="donorAddressInputBox"
				maxlength="255" />
			<form:errors path="address"></form:errors>
		</div>
		<div>
			<form:label path="city">City</form:label>
			<form:input path="city" />
			<form:errors path="city"></form:errors>
		</div>
		<div>			
			<form:label path="state">State</form:label>
			<form:input path="state" />
			<form:errors path="state"></form:errors>
		</div>
		<div>
			<form:label path="country">Country</form:label>
			<form:input path="country" />
			<form:errors path="country"></form:errors>
		</div>
		<div>
			<form:label path="phoneNumber">Contact Number</form:label>
			<form:input path="phoneNumber" />
			<form:errors path="phoneNumber"></form:errors>
		</div>
		<div>
			<form:label path="notes"
				style="vertical-align: top; padding-top: 40px; display: inline-block;">
				${model.commentsDisplayName}
			</form:label>
			<form:textarea path="notes" id="donorCommentsInputBox"
				maxlength="255" />
			<form:errors path="notes"></form:errors>
		</div>
		<c:if test="${model.isDialog != 'yes' }">
			<div>
				<button type="button" class="addDonorButton-${formId}"
					style="margin-left: 10px" onclick="updateDonor();">Add
					donor</button>
			</div>
		</c:if>
	</div>
</form:form>
