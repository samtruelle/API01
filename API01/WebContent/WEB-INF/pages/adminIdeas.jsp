<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ideas (admin)</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div id="siteContent">
		<div id="warning">
			${message}
		</div>
		<a href="adminCreateIdea" class="btn btn-success"><span cass="glyphicon glyphicon-plus"></span>Create an idea</a>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<td>
						Description
					</td>
					<td>
						Application
					</td>
					<td>
						Targeted market
					</td>
					<td>
						Fund
					</td>
					<td>
						State
					</td>
					<td>	
						Long summary
					</td>
					<td>
						User
					</td>								
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ideas}" var="idea">								
					<tr class="ideaCard">					
						<td class="description">
							${idea.description}
						</td>	
						<td class="application">
							${idea.application}
						</td>
						<td class="targeted_market">
							${idea.targeted_market}
						</td>
						<td class="fund">
							${idea.fund}
						</td>		
						<td class="state">
							${idea.state}
						</td>
						<td class="long_summary">
							${idea.long_summary}
						</td>
						<td class="user">
							${idea.user.email}
						</td>
						<td>
							<a href="adminDeleteIdea?ideaId=${idea.idea_id}" data-confirm="Do you realy want to delete the idea ?" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove"></span>								
								delete
							</a>							
						</td>
						<td>
							<a href="adminEditIdea?ideaId=${idea.idea_id}" class="btn btn-warning">
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