$(document).ready(function() {
 
    // Configura las opciones para validar el formulario
    $("#cobroform").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
            txtnfactura: {
                required: true,
                number: true,
				min: 1,
				max: 11111111111
            },
		
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
	
            txtnfactura: {
                required: "Ingrese número de factura",
 				number: "Debes ingresar un número",
				min: "Mínimo 1",
				max: "Máximo 1111111111"
            },

        }
    });

	let fecha = $('#fecha').val();
	let fecha2,fecha3;
	if(fecha){
	fecha2 = fecha.split("-");
	fecha3 = fecha2[1]+"/"+fecha2[2]+"/"+fecha2[0];
	}
	
	let fecha4 = $('#fecha1').val();
	let fecha5,fecha6;
	
	if(fecha4){
	fecha5 = fecha4.split("-");
	fecha6 = fecha5[1]+"/"+fecha5[2]+"/"+fecha5[0];
	}
	
	$('#fecha').val(fecha3);
	$('#fecha1').val(fecha6);
	console.log("funciona");

    $('#fecha').multiDatesPicker({
        minDate: -60,
        maxDate: 180,
		maxPicks:1,
		onSelect: function(){
			$(this).datepicker("hide");
		}
		
		//dateFormat: "d-m-y"
    });
 $('#fecha1').multiDatesPicker({
        minDate: -60,
        maxDate: 180,
		maxPicks:1,
		onSelect: function(){
			$(this).datepicker("hide");
		}
		//dateFormat: "d-m-y"
    });


$('#fecha').click(function (){
	$(this).multiDatesPicker("resetDates","picked");
	$(this).val("");
   });	
$('#fecha1').click(function (){
	$(this).multiDatesPicker("resetDates","picked");
	$(this).val("");
});

});
