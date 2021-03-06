<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>V2V</title>
    <jsp:include page="commonHeadIncludes.jsp" flush="true"/>

    <link type="text/css" rel="stylesheet" href="css/usersTable.css"/>


</head>
<body>
<div class="mainBody">
    <div class="mainContent">
        <jsp:include page="adminTopPanel.jsp" flush="true"/>
        <div class="leftPanel">
            <ul id="userTabs" class="leftPanelTabs">
                <li id="addUserTab"><a href="admin-addUser.html">Add</a></li>
                <li id="viewUserTab" class="selectedTab"><a href="admin-userTable.html">View</a></li>
            </ul>
        </div>

        <div class="centerPanel">
            <div class="centralContent">
                <table id="usersTable">

                    <c:forEach var="aUser" items="${model.allUsers}">
                        <tr>
                            <td>${aUser.username}</td>
                            <td>
                                <a href="admin-findUser.html?username=${aUser.username}">edit/delete</a>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
        <jsp:include page="bottomPanel.jsp" flush="true"/>

    </div>
</div>
</body>
</html>