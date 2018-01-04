<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<div class="container">
	<div class="row col-md-6 col-md-offset-2 custyle">
		<table class="table table-striped custab">
			<thead>
				<tr>
					<th>Task ID</th>
					<th>Task Description</th>
					<th>Status</th>
					<th>Assign To</th>

				</tr>
			</thead>
			<c:forEach var="task" items="${taskList}">
			<tr>
			<td><a href="${contextPath}/viewTask/${task.taskId}/${username}">${task.taskId}</a></td>
			<td>${task.description}</td>
			<td>${task.status}</td>
			<td>${task.assignedTo}</td>
			</tr>
			</c:forEach>
          </table>
    </div>
</div>