$(document).ready(function() {
 
    // Configura las opciones para validar el formulario
    let validator = $(".tarea-form").validate({
        // Define las reglas que se aplican a cada campo del formulario
        // required -> El campo es obligatorio
        // minlength -> El número mínimo de caracteres
        // maxlength -> El número máximo de caracteres
        // number -> El valor ingresado debe ser numérico
        // min y max -> Valores mínimo y máximo (numéricos)
        // rut -> Método personalizado, definido más arriba
        rules: {
            txtnombre: {
                required: true,
                maxlength: 50,
				minlength: 3
            },

            txtdetalletarea: {
                required: true,
                maxlength: 500,
				minlength: 10
            }

		
        },
        // Define los mensajes que se muestran al usuario cuando no se cumplen las reglas al momento de la validación
        // Estos mensajes son por cada campo y cada regla
        messages: {
	
            txtnombre: {
                required: "Debe ingresar un nombre",
                maxlength: "Maximo 50 caracteres",
				minlength: "Minimo de 3 caracteres"
            },

            txtdetalletarea: {
                required: "Debe ingresar un detalle de tarea",
                maxlength: "Maximo 500 caracteres",
				minlength: "Minimo de 10 caracteres"
            }
        }
    });

	
});

