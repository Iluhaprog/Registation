$(document).ready(function(){

	var url     = "http://localhost:8084/RegistV2/user/userpage";
	var fullurl = url;
	$.ajax({
			url     : fullurl,
			type    : 'GET',
			dataType: 'json',
			success : function(result){

				// alert(result.age+" "+result.name+" "+result.surname);
				$(".log").html(result.login);
				$(".nm").html(result.name);
				$(".snm").html(result.surname);
				$(".ag").html(result.age);

				
			}
		});

	$("#upd").click(function(){
		var login      = document.getElementById("log").value;
		var newname    = document.getElementById("namenew").value;
		var newsurname = document.getElementById("surnamenew").value;
		var newage     = document.getElementById("agenew").value;
		var newpass    = document.getElementById("newpassword").value;
		var oldpass    = document.getElementById("oldpassword").value;
		var url        = "http://localhost:8084/RegistV2/user/udateuser?login="+login+"&name="+newname+"&oldpass="+oldpass+"&newpass="+newpass+"&surname="+newsurname+"&age="+newage
		var fullurl    = url;
					alert(url);
		
		$.ajax({
			url 	: fullurl,
			type 	: 'PUT',
			dataType: 'text',
			success : function(result){
				alert(result);
			}
		});	
	});

	$("#del").click(function(){
		var dellogin   = document.getElementById("dellog").value;
		var delpass    = document.getElementById("delpass").value;

		var url        = "http://localhost:8084/RegistV2/user/deleteuser?login="+dellogin+"&pass="+delpass;
		var fullurl    = url;

		$.ajax({
			url 	: fullurl,
			type 	: 'DELETE',
			dataType: 'text',
			success : function(result){
				alert(result);
			}
		});	

	});
	
});