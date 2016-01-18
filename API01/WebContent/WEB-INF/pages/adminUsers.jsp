<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users (admin)</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div id="siteContent">
		<div id="warning">
			${message}
		</div>
		<a href="adminCreateUser" class="btn btn-success"><span cass="glyphicon glyphicon-plus"></span>Create an user</a>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<td>
						Email (login)
					</td>
					<td>
						First name
					</td>
					<td>
						Last name
					</td>
					<td>
						Adress
					</td>
					<td>
						Telephone
					</td>
					<td>
						Account blocked
					</td>
					<td>
						Admin
					</td>
					<td>
						Delete
					</td>
					<td>
						Edit
					</td>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">								
					<tr class="userCard">					
						<td class="eamil">
							${user.email}
						</td>	
						<td class="firstName">
							${user.firstName}
						</td>
						<td class="lastName">
							${user.lastName}
						</td>
						<td class="adress">
							${user.adress}
						</td>		
						<td class="telephone">
							${user.telephone}
						</td>
						<td class="accountBlocked">
							${user.account_blocked}
						</td>
						<td class="admin">
							${user.admin}
						</td>
						<td>
							<a href="adminDeleteUser?userId=${user.user_id}" data-confirm="Do you realy want to delete the user ?" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove"></span>								
								delete
							</a>							
						</td>
						<td>
							<a href="adminEditUser?userId=${user.user_id}" class="btn btn-warning">
								<span class="glyphicon glyphicon-edit"></span>
								edit
							</a>
						</td>					
					</tr>							
				</c:forEach>
			</tbody>
		</table>		
	</div>
</body>
<script>
$(function() {
	$('a[data-confirm]').click(function(ev) {
		var href = $(this).attr('href');
		
		if (!$('#dataConfirmModal').length) {
			$('body').append('<div id="dataConfirmModal" class="modal" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="dataConfirmLabel">Please confirm the action</h3></div><div class="modal-body"></div><div class="modal-footer"><button class="btn" data-dismiss="modal" aria-hidden="true">Non</button><a class="btn btn-danger" id="dataConfirmOK">Oui</a></div></div></div></div>');
		}
		$('#dataConfirmModal').find('.modal-body').text($(this).attr('data-confirm'));
		$('#dataConfirmOK').attr('href', href);
		$('#dataConfirmModal').modal({show:true});
		
		return false;
	});
});
</script>
</html>