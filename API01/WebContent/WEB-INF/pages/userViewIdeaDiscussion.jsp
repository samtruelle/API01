<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View an idea</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div id="siteContent">
		<div id="warning">
			${message}<br/>	
		</div>
		<div class="container">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="well well-sm col-md-3">
		                <div class="row">				                   
		                    <div class="col-sm-6 col-md-12">
		                        <h4 class="ideaTitle">${idea.title}</h4>				                    
		                        <h5>${idea.description}</h5>
		                        <h5>${idea.application}</h5>				                        
		                        <h5>${idea.targeted_market}</h5>
		                        <h5 class="state">state : ${idea.state}</h5>			                        
		                        <!-- Split button -->
		                        <div id="managementButtons">
		                            <a href="userEditIdea?ideaId=${idea.idea_id}" class="btn btn-warning">Edit</a>				                            
		                            <a href="userDeleteIdea?ideaId=${idea.idea_id}" data-confirm="Do you really want to delete your idea ?" class="btn btn-danger">Delete</a>
		                        </div>
		                    </div>
		                </div>			                		                
	                	<div id="upDownScore">
		                	<a href="userLikeIdea?ideaId=${idea.idea_id}&value=1"
						        class="btn btn-success glyphicon glyphicon-thumbs-up"> ${likes} Like</a>						    
							<a href="userLikeIdea?ideaId=${idea.idea_id }&value=-1"
								class="btn btn-success glyphicon glyphicon-thumbs-down"> ${dislikes} Dislike</a>						    
	                	</div>				                				              
		       		</div>
			        <div id="comment" class="col-md-9 well well-sm">
						<c:if test="${comments == '' || comments == null}">
							There is no message to display for the moment.
						</c:if>
						<c:if test="${comments != null}">
							<c:forEach items="${comments}" var="comment">
								<div class="card text-xs-center">
								  <div class="card-header">
								    Featured
								  </div>
								  <div class="card-block">
								    <h4 class="card-title">Special title treatment</h4>
								    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
								    <a href="#" class="btn btn-primary">Go somewhere</a>
								  </div>
								  <div class="card-footer text-muted">
								    2 days ago
								  </div>
								</div>
								<c:if test="${comment.comments != null}">
									<c:forEach items="${comment.comments}" var="subComment">
										<div class="card text-xs-center">
										  <div class="card-header">
										    Featured
										  </div>
										  <div class="card-block">
										    <h4 class="card-title">Special title treatment</h4>
										    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
										    <a href="#" class="btn btn-primary">Go somewhere</a>
										  </div>
										  <div class="card-footer text-muted">
										    2 days ago
										  </div>
										</div>
									</c:forEach>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
		    	</div>
			</div>						
       </div>
    </div>
</body>
</html>