$(document).ready(function() {
    var validator = $("form[name='form_capacitacion']").validate({
        rules: {
            txtidactividad: {
                required: true

            },
            txtparticipantes: {
                required: true,
                max: 500,
                min: 1
            },
            txtfechacap: {
                required: true
            },
            txttema: {
                required: true,
                minlength: 5,
                maxlength: 1000
            }
        },
        messages: {

            txtidactividad: {
                required: "Debe seleccionar una actividad.",
            },
            txtparticipantes: {
                required: "Debe ingresar participantes",
                max: "Maximo 500",
                min: "Minimo 1"
            },
            txtfechacap: {
                required: "Debe ingresar una fecha.",
            },
            txttema: {
                required: "Ingrese Tema.",
                minlength: "Ingrese Tema(min 5 caracteres).",
                maxlength: "Sobrepasa cantidad de caracteres permitido."
            }
        }
    })

	let fecha = $('#fecha').val();
	let fecha2;
	fecha2 = fecha.split("-");
	let fecha3 = fecha2[1]+"/"+fecha2[2]+"/"+fecha2[0];
	
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

})