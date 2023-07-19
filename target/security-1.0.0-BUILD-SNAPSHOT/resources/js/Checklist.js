$(document).ready(function() {
 
    
   var validator =  $("#checklistform").validate({
      
        rules:  {
            txtidcliente: {
                required: true
            },
            txtfechacreacion: {
                required: true
            },
			txtfechacambio: {
                required: true
            }
		},
		 messages: {

            txtidcliente: {
                required: "Debe seleccionar un cliente.",
            },
            txtfechacreacion: {
                required: "Debe ingresar una fecha.",
            },
            txtfechacambio: {
                required: "Debe ingresar una fecha.",
            }
           
        }
    })
 	$('#fecha').multiDatesPicker({
        minDate: -365,
        maxDate: 0
    });
})
        
	
	
	
	
	
   