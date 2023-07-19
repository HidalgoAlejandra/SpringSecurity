$(document).ready(function() {
	
	//Agrega el dígito verificador al traer el rut desde la base de datos
	completarRut();

	// Inicializa el plugin DataTables en todas las tablas de la página
	$('.tablas').DataTable();
	
    // Agrega un método (criterio) de validacion a los ya existentes en jQuery Validate
    // En este caso, el método rut comprueba que se haya ingresado un rut chileno válido
    $.validator.addMethod(
        "rut",
        function(rut, element) {
            return validarRut(rut);
        },
        "El RUT ingresado no es válido"
    );

    // Configura las opciones para validar el formulario
    let validator = $("#buscar-cliente-rut").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
            rut_cliente: {
                required: true,
                rut: true
            }
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
            rut_cliente: {
                required: "Ingresa RUT de cliente",
				rut: "El RUT ingresado no es válido"
            }
        }
    });

	//Elimina el dígito verificador antes de enviar la info al servidor
	$('#buscar-cliente-rut').submit(function() {
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
