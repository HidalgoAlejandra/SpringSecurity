$(document).ready(function() {
    var validator = $("form[name='form_asesoria']").validate({
        rules: {
            txtfechasolicitud: {
                required: true
            },
            txtdetallesol: {
                required: true,
                minlength: 30,
                maxlenght: 1000
            }
        },
        messages: {

            txtfechasolicitud: {
                required: "Debe ingresar una fecha.",
            },
            txtdetallesol: {
                required: "Ingrese detalle.",
                minlength: "Ingrese detalle(min 30 caracteres).",
                maxlenght: "Sobrepasa cantidad de caracteres permitido."
            }
        }
    })
	
	let fecha = $('#fecha').val();
	let fecha2, fecha3;
	
	if (fecha2) {
		fecha2 = fecha.split("-");
		fecha3 = fecha2[1]+"/"+fecha2[2]+"/"+fecha2[0];
	}
	
	$('#fecha').val(fecha3);
	
    $('#fecha').multiDatesPicker({
        minDate: -1,
        maxDate: 99,
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