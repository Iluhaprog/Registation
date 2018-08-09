$(document).ready(function(){
	$(".button").click(function(){
		var login   = document.getElementById("login").value;
		var pass 	= document.getElementById("pass").value;

		var url     = "http://localhost:8084/RegistV2/user/login?login="+login+"&pass="+pass;
		var fullurl = url;
		alert(url);
		$.ajax({
			url     : fullurl,
			type    : 'GET',
			dataType: 'json',
			success : function(result){
				console.log(result);
				console.log("ok!");	
				
			}
		});
		document.getElementById("login").value = "";
		document.getElementById("pass").value = "";
		location.href = "file:///home/mr/%D0%94%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B/HTML/TestWebPrj/login/indexuser.html";
		
	});

});

