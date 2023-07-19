$(document).ready(function() {


    // Configura las opciones para validar el formulario
    let validator = $("#visitaforma").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
	
            txtidasesoria: {
                required: true,
				number: true,
                maxlength: 10
            },
			txtfechavisita: {
                required: true
            }
			
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
	
            txtidasesoria: {
                required: "Ingresa id de asesoría",
                maxlength: "Máximo 10 carácteres"
            },

			txtfechavisita: {
                required: "Ingresar fecha de visita"
            }

        }

    });

	let fecha = $('#fecha').val();
	let fecha2, fecha3;
	
	if (fecha) {
		fecha2 = fecha.split("-");
		fecha3 = fecha2[1]+"/"+fecha2[2]+"/"+fecha2[0];
	}
	
	$('#fecha').val(fecha3);
	
    $('#fecha').multiDatesPicker({
        minDate: -7,
        maxDate: 90,
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

