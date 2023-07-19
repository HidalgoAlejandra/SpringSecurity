$(document).ready(function() {
    
	//Agrega el dígito verificador al traer el rut desde la base de datos
	completarRut();

	// Agrega un método (criterio) de validacion a los ya existentes en jQuery Validate
    // En este caso, el método cAlpha acepta solo letras y espacios
    $.validator.addMethod(
        "rut",
        function(rut, element) {
            return validarRut(rut);
        },
        "Ingresa rut correcto"
    );

    // Configura las opciones para validar el formulario
    let validator = $("#clientelog").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
            txtrazon_social: {
                required: true,
                maxlength: 100
            },

            txtrut_empresa: {
                required: true,
                rut: true
            },

			txtgiro: {
                required: true,
                maxlength: 40
            },

			txtdireccion: {
                required: true,
                maxlength: 50
            },

			txtfono_contacto: {
                required: true,
                maxlength: 20,
				number: true
            },

			txtrepresentante: {
                required: true,
                maxlength: 30
            },

			txtcontacto: {
                required: true,
                maxlength: 30
            },

			txtemail_contacto: {
                required: true,
				email: true,
                maxlength: 50
            }
			
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
	
            txtrazon_social: {
                required: "Ingrese razón social",
                maxlength: "Máximo 100 carácteres"
            },

            txtrut_empresa: {
                required: "Ingrese rut de empresa",
            },

			txtgiro: {
                required: "Ingresa giro",
                maxlength: "Máximo 40 carácteres"
            },

			txtdireccion: {
                required: "Ingresa dirección",
                maxlength: "Máximo 50 carácteres"
            },

			txtfono_contacto: {
                required: "Ingresa teléfono de contacto",
                maxlength: "Máximo 20 carácteres",
				number: "Ingresa solo números"
            },

			txtrepresentante: {
                required: "Ingresa representante",
                maxlength: "Máximo 30 carácteres"
            },

			txtcontacto: {
                required: "Ingresa contacto",
                maxlength: "Máximo 30 carácteres"
            },

			txtemail_contacto: {
                required: "Ingresa email de contacto",
				email: "Ingresa email",
                maxlength: "Máximo 50 carácteres"
            }
        }
    });

	//Elimina el dígito verificador antes de enviar la info al servidor
	$('#clientelog').submit(function() {
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
		return false;
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