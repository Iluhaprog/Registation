$(document).ready(function(){
	$(".button").click(function(){
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		var pass = document.getElementById("pass").value;
		var surname = document.getElementById("surname").value;
		var login = document.getElementById("login").value;

		var url = "http://localhost:8084/RegistV2/user/newuser?login="+login+"&age="+age+"&name="+name+"&surname="+surname+"&pass="+pass;
		var fullurl = url;
		alert(url);
		$.ajax({
			url     : fullurl,
			type    : 'POST',
			dataType: 'text',
			success : function(result){
				if (result != "you did not enter all the data or you are less than 10!" && result != "FUCK YOU! login exists!"){
					document.getElementById("name").value = "";
					document.getElementById("surname").value = "";
					document.getElementById("age").value = "";
					document.getElementById("pass").value = "";
					alert(result);
					
				}
				else{
					alert(result);
				}
				
			}
		});
		
	});
});