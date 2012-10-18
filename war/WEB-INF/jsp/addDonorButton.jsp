<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!public long getCurrentTime() {
		return System.nanoTime();
	}
	Long button_id = getCurrentTime();%>

<c:set var="button_id"><%=getCurrentTime()%></c:set>

<script>
	$(".addDonorButton").button({icons: {primary:'ui-icon-plusthick'}});

	function bootup() {
		generateEditForm("editDonorFormGenerator.html", {isDialog : "yes"},
		    						 addNewDonor,
		    						 "Add New Donor",
		    						 "addDonorButtonEdit-" + "<%=button_id%>",
		    						 function(){}, 610, 1100);
	}
</script>



<button id="addDonorButton-${button_id}"
	onclick="bootup(${button_id});" class="addDonorButton">Click
	here to add a new donor</button>
