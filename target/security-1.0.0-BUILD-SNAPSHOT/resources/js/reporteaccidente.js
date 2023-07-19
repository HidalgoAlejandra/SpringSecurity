$(document).ready(function() {

	// Configura las opciones para validar el formulario
	let validator = $(".accidente-form").validate({
		// Define las reglas que se aplican a cada campo del formulario
		// required -> El campo es obligatorio
		// minlength -> El número mínimo de caracteres
		// maxlength -> El número máximo de caracteres
		// number -> El valor ingresado debe ser numérico
		// min y max -> Valores mínimo y máximo (numéricos)
		// rut -> Método personalizado, definido más arriba
		rules: {
			fecha_accidente: {
				required: true
			},

			involucrado: {
				required: true,
				maxlength: 30,
				minlength: 3
			},

			lugar: {
				required: true,
				maxlength: 30,
				minlength: 3
			},

			actividad: {
				required: true,
				maxlength: 20,
				minlength: 3
			},

			descripcion: {
				required: true,
				maxlength: 1000,
				minlength: 10
			}

		},
		// Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
		// Estos mensajes son por cada campo y cada regla
		messages: {

			fecha_accidente: {
				required: "Debes ingresar una fecha"
			},

			involucrado: {
				required: "Debes ingresar un nombre",
				maxlength: "Máximo 30 caracteres",
				minlength: "Mínimo 3 caracteres"
			},
			lugar: {
				required: "Debes ingresar un lugar",
				maxlength: "Máximo 30 caracteres",
				minlength: "Mínimo 3 caracteres"
			},
			actividad: {
				required: "Debes ingresar una actividad",
				maxlength: "Máximo 20 caracteres",
				minlength: "Mínimo 3 caracteres"
			},
			descripcion: {
				required: "Debes ingresar una descripción",
				maxlength: "Máximo 1000 caracteres",
				minlength: "Mínimo 10 caracteres"
			}
		}
	});
	
	let fecha = $('#fecha').val();
	let fecha2;
	fecha2 = fecha.split("-");
	let fecha3 = fecha2[1]+"/"+fecha2[2]+"/"+fecha2[0];
	
	$('#fecha').val(fecha3);
	
    $('#fecha').multiDatesPicker({
        minDate: -2,
        maxDate: 0,
		maxPicks: 1,
		onSelect: function(){
			$(this).datepicker("hide");
		}
		//dateFormat: "d-m-y"
    });

$('#fecha').click(function (){
	$(this).multiDatesPicker("resetDates","picked");
	$(this).val("");
});

});