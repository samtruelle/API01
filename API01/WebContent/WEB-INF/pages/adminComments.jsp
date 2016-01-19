<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/pages/navbar.jsp"%>

	<input type="text" name="idea" id="autocomplete" class="form-control"
		placeholder="enter idea title" />
	<div id="id">fzfe</div>

	<script type="text/javascript">
		$('#autocomplete').keypress(function() {
			$.ajax({
				url : 'ajaxresult?query=' + $('#autocomplete').val(),
				sucess : function(data) {
					alert(data);
					console.log(data);
				}
			})
		})
	</script>

</body>
</html>