$(document).ready(function() {
    // Agrega un método (criterio) de validacion a los ya existentes en jQuery Validate
    // En este caso, el método cAlpha acepta solo letras y espacios
    $.validator.addMethod(
        "rut",
        function(rut, element) {
            return validarRut(rut);
        },
        "Debes ingresar solo letras y espacios"
    );

    // Configura las opciones para validar el formulario
    let validator = $("#login-form").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
            username: {
                required: true,
                rut: true

            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            }
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
            username: {
                required: "Debes ingresar un RUT",
                rut: "El RUT ingresado no es válido"
            },
            password: {
                required: "Debes ingresar una contraseña",
                minlength: "Mínimo 6 caracteres",
                maxlength: "Máximo 20 caracteres"
            }
        }
    });

	//Elimina el dígito verificador antes de enviar la info al servidor
	$('#login-submit').click(function() {
		validator.destroy();
		let rut = $('#rut').val();
		rut = rut.replace(/\./g, "");
        rut = rut.replace("-", "");
		$('#rut').val(rut.substring(0, rut.length - 1));
		return true;	
	});

});

//Verifica si el RUT ingresado es un RUT chileno válido
function validarRut(rut) {

    let validacion = false;

    try {

        rut = rut.toUpperCase();
        rut = rut.replace(/\./g, "");
        rut = rut.replace("-", "");
        let rutAux = parseInt(rut.substring(0, rut.length - 1));

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