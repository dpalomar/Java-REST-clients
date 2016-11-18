$(document).ready(function() {
    
	$("#btn-single").click(function(){
		$.ajax({
	        url: "http://localhost:8080/usuario"
	    }).then(function(data) {
	       $('#elusuarioDocument').append(JSON.stringify(data));
	       $('#elusuario').append(data.nombre);
	    });
	});
	
	$("#btn-list").click(function(){
		$.ajax({
			url: "http://localhost:8080/usuarios"
		}).then(function(data){
			$("#tbl-usuarios").append(
					
			    $.map(data, function(usuario,index){
			       return '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+'</td>'+'<td>'+usuario.edad+'</td></tr>';  	
			    }).join());
			
		});
	});
	
	$(document).submit(function(e){
		var form = $(e.target);
		if (form.is("#my-form")) {
			e.preventDefault();

		var usuario = {};
		$.each(form.serializeArray(), function(_,kv){
			usuario[kv.name] = kv.value;
		});

		console.log(JSON.stringify(usuario));
			
			
			$.ajax({
				url: "http://localhost:8080/usuario",
				data: JSON.stringify(usuario),
				method: "POST",
				contentType: "application/json"
			}).done(function(data){
				$("#mensaje").append("Usuario creado correctamente: "+ JSON.stringify(data));
			}).fail(function(data,error){
				$("#mensaje").append(data);
			});
		}
	});
});