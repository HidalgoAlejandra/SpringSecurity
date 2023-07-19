$(document).ready(function() {
    // Agrega un método (criterio) de validacion a los ya existentes en jQuery Validate
	//Agrega el dígito verificador al traer el rut desde la base de datos
	completarRut();
    // En este caso, el método cAlpha acepta solo letras y espacios
    $.validator.addMethod(
        "rut",
        function(rut, element) {
            return validarRut(rut);
        },
        "Ingresa rut correcto"
    );

    // Configura las opciones para validar el formulario
        let validator = $("#profesional-form").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
	
           txtnombre_profesional: {
                required: true,
                maxlength: 30
            },

            txtrut_profesional: {
                required: true,
                rut: true
            },

			txttelefono_corp: {
                required: true,
                maxlength: 20,
				number: true
            },

			txtemail_corp: {
                required: true,
				email: true,
                maxlength: 20
            }
        },

        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla

        messages: {
	
           txtnombre_profesional: {
                required: "Ingrese el Nombre Profesional",
                maxlength: "Máximo 30 carácteres"
            },

            txtrut_profesional: {
                required: "Ingrese rut del Profesional",
                
            },

			txttelefono_corp: {
                required: "Ingresa teléfono Corporativo",
                maxlength: "Máximo 20 carácteres",
				number: "Ingresa solo números"
            },

			txtemail_corp: {
                required: "Ingresa email Corporativo",
				email: "Ingresa email",
                maxlength: "Máximo 20 carácteres"
            }
        },

    });


   //Elimina el dígito verificador antes de enviar la info al servidor
	$('#profesional-form').submit(function() {
		let rut = $('#rut').val();
		if (rut !== '0' && validarRut(rut) && validator.form()) {
			validator.destroy();
			rut = rut.replace(/\./g, "");
	        rut = rut.replace("-", "");
			if (rut.length > 1) {
				$('#rut').val(rut.substring(0, rut.length - 1));
			}
			return true;
		}
	});

});

//Verifica si el RUT ingresado es un RUT chileno válido
function validarRut(rut) {

    let validacion = false;

    try {

        rut = rut.toUpperCase();
        rut = rut.replace(/\./g, "");
        rut = rut.replace("-", "");
		let rutAux = 0;
		if (rut.length > 1) {
        	rutAux = parseInt(rut.substring(0, rut.length - 1));
		}
        let dv = rut.charAt(rut.length - 1);

        let m = 0,
            s = 1;

        for (; rutAux != 0; rutAux = Math.floor(rutAux / 10)) {

            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;

        }

        let dvu = s != 0 ? s + 47 : 75;

        if (dv == String.fromCharCode(dvu)) {

            validacion = true;

        }

    } catch (Exception) {

    }

    return validacion;
}

//Agrega el dígito verificador al traer el rut desde la base de datos
function completarRut() {
	
	let rutIni = $('#rut').val();
	let rutAux = $('#rut').val();
	
	let m = 0,
	s = 1;

    for (; rutAux != 0; rutAux = Math.floor(rutAux / 10)) {

        s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;

    }

    let dvu = s != 0 ? s + 47 : 75;
	let rut = "" + rutIni + String.fromCharCode(dvu);
	$('#rut').val(rut);
	
}
