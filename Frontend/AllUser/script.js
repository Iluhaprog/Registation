$(document).ready(function(){

	$.ajax({
		url : 'http://localhost:8084/RegistV2/user/alluser',
		type : 'GET',
		dataType : 'json',
		success  : function(result){
			var name = '';
			for(var n in result){
				name += '<p class="name">Name : '+result[n].name+' </br><span>Surname : '+result[n].surname+'</span></br><span>Age : '+result[n].age+'</span></p>';
			}

			$('.users').html('<div>'+name+'</div>');
		}
	})	
});
