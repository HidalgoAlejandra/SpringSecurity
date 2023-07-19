$(document).ready(function() {

 $.validator.addMethod(
        "fecha",
        function(fecha, element) {
            return validarFecha(fecha), existeFecha(fecha), existeFecha2(fecha);
        },
        "Ingrese una fecha correcta"
    );

    let validator = $("#asesoriaform").validate({
        rules: {
			txtdetallesol: {
                required: true,
				minlength: 30,
                maxlength: 1000
            },

			 txtfechasolicitud: {
                required: true
        
            },
     	},
        messages: {
	
            txtdetallesol: {
				required: "Debes ingresar un detalle",
				minlength: "Mínimo 30 carácteres",
                maxlength: "Máximo 1000 carácteres"
            },

			 txtfechasolicitud: {
                required: "Ingrese una fecha válida",
            },
	}
    });
 $('#fecha').multiDatesPicker({
        minDate: -365,
        maxDate: 0,
		onSelect: function(){
			$(this).datepicker("hide");
		}
    });
 });

function validarFecha(campo) {
	var RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
	if ((campo.match(RegExPattern)) && (campo!='')) {
		return true;
	} else {
		return false;
	}
}

function existeFecha(fecha){
	var fechaf = fecha.split("/");
	var day = fechaf[0];
	var month = fechaf[1];
	var year = fechaf[2];
	var date = new Date(year,month,'0');
	if((day-0)>(date.getDate()-0)){
		return false;
	}
	return true;
}

function existeFecha2 (fecha) {
	  var fechaf = fecha.split("/");
	  var d = fechaf[0];
	  var m = fechaf[1];
	  var y = fechaf[2];
	  return m > 0 && m < 13 && y > 0 && y < 32768 && d > 0 && d <= (new Date(y, m, 0)).getDate();
}
