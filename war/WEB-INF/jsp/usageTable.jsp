<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:set var="table_id">${model.tableName}</c:set>

<script>
  var table_id = "${table_id}";
  var usageTable = $("#" + table_id).dataTable({
    "bJQueryUI" : true
  });

  $("#" + table_id + " tbody").dblclick(
      function(event) {

        // remove row_selected class everywhere
        $(usageTable.fnSettings().aoData).each(function() {
          $(this.nTr).removeClass('row_selected');
        });

        // add row_selected class to the current row
        $(event.target.parentNode).addClass('row_selected');

        var elements = $(event.target.parentNode).children();
        if (elements[0].getAttribute("class") === "dataTables_empty") {
          return;
        }

        var productId = elements[0].innerHTML;

        generateEditForm("editUsageFormGenerator.html", {
          productNumber : productId,
          isDialog : "yes"
        }, updateExistingProduct, "Edit Product: " + elements[1].innerHTML
            + " " + elements[2].innerHTML, 'productsTable',
            decorateEditProductDialog, 550, 575);
      });
</script>

<jsp:include page="addUsageButton.jsp" flush="true" />
<br />
<br />

<table id="${table_id}" class="dataTable collectionsTable">
	<thead>
		<tr>
			<th>${model.productNoDisplayName}</th>
			<c:if test="${model.showdateUsed==true}">
				<th>${model.dateUsedDisplayName}</th>
			</c:if>
			<c:if test="${model.showhospital==true}">
				<th>${model.hospitalDisplayName}</th>
			</c:if>
			<c:if test="${model.showward==true}">
				<th>${model.wardDisplayName}</th>
			</c:if>
			<c:if test="${model.showuseIndication==true}">
				<th>${model.useIndicationDisplayName}</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="usage" items="${model.allUsage}">
			<tr>
				<td>${usage.productNumber}</td>
				<c:if test="${model.showdateUsed==true}">
					<td>${usage.dateUsed}</td>
				</c:if>
				<c:if test="${model.showhospital==true}">
					<td>${usage.hospital}</td>
				</c:if>
				<c:if test="${model.showward == true}">
					<td>${usage.ward}</td>
				</c:if>
				<c:if test="${model.showuseIndication == true}">
					<td>${usage.useIndication}</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>