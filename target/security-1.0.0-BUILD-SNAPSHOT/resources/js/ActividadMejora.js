$(document).ready(function() {
    var validator = $("#form-act").validate({
        rules: {
            txtdetalleactividad: {
                required: true,
                minlength: 10,
                maxlenght: 1000
            }
        },
        messages: {
            txtdetalleactividad: {
                required: "Ingrese detalle.",
                minlength: "Ingrese detalle (min 10 caracteres).",
                maxlenght: "Sobrepasa cantidad de caracteres permitido."
            }
        }
    })
});