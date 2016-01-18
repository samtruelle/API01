<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your ideas</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
		<div id="siteContent">
			<div id="warning">
				${message}<br/>	
			</div>
			<c:forEach items="${ideas}" var="idea">
				<div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-6 col-md-3">
				            <div class="well well-sm">
				                <div class="row">				                   
				                    <div class="col-sm-6 col-md-12">
				                        <h4 class="ideaTitle">${idea.title}</h4>				                    
				                        <h5>${idea.description}</h5>
				                        <h5>${idea.application}</h5>				                        
				                        <h5>${idea.targeted_market}</h5>
				                        <h5 class="state">state : ${idea.state}</h5>
				                        <!-- Split button -->
				                        <div>
				                            <a href="userEditIdea?ideaId=${idea.idea_id}" class="btn btn-warning">Edit</a>
				                            <a href="userViewIdea?ideaId=${idea.idea_id}" class="btn btn-primary">View</a>
				                            <a href="userDeleteIdea?ideaId=${idea.idea_id}" data-confirm="Do you really want to delete your idea ?" class="btn btn-danger">Delete</a>
				                        </div>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
				</div>						
			</c:forEach>
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