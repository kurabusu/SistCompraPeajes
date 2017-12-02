
$( document ).ready( function () {
    $("#form-carretera").validate({
        rules:{
            "nombre": {
                required : true,
                minlength : 3 
            },
            "costo" :{
                required : true,                
                number : true
            }
        },
        messages: {
            "nombre": {
                required : "El campo es requerido.",
                minlengt : "Debe tener minimo 3 caracteres."
            },
            "costo" :{
                required : "El campo es requerido",
                number : "El valor debe ser numerico"
            }
        }, 
        errorElement: "div",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "invalid-feedback" ); 

            if ( element.prop( "type" ) === "checkbox" ) {
                    error.insertAfter( element.parent( "label" ) );
            } else {
                    error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            //$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
        },
        unhighlight: function (element, errorClass, validClass) {
            //$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
        }
    });                
    
    $("#form-empresa").validate({
        rules :{
            "rut": {
                required: true,
                maxlength: 15,
                minlength: 1
            },
            "nombre": {
                required: true,
                minlength: 3
            },
            "direccion": {
                required: true,
                maxlength: 100
            }
        },
        messages: {
            "rut": {
                required: "El campo es requerido",
                maxlength: "Se ha supero la cantidad maxima de 15 caracteres.",
                minlength: "Debe tener un minimo de 2 caraceres"
            },
            "nombre": {
                required: "El campo es requerido",
                minlength: "Debe tener un minimo de 3 caraceres"
            },
            "direccion": {
                required: "El campo es requerido",
                maxlength: "Se ha supero la cantidad máxima de 100 caracteres." 
            }
        },
        errorElement: "div",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "invalid-feedback" ); 

            if ( element.prop( "type" ) === "checkbox" ) {
                    error.insertAfter( element.parent( "label" ) );
            } else {
                    error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            //$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
        },
        unhighlight: function (element, errorClass, validClass) {
            //$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
        }
    }); 
    
    $("#form-usuario").validate({
        rules: {
            nombre: {
                required: true,
                minlength: 3
            },
            usuario: {
                required: true,
                minlength: 5
            },
            clave : {
                required: true,
                minlength: 5
                
            },
            rClave: {
                required: true,
                equalTo: "#clave"
            }
            
        },
        messages: {
            nombre: {
                required: "El campo es requerido.",
                minlength: "Debe tener un minimo de 3 caraceres."
            },
            usuario: {
                required: "El campo es requerido.",
                minlength: "Debe tener un minimo de 5 caraceres."
            },
            clave : {
                required: "El campo es requerido.",
                minlength: "Debe tener un minimo de 5 caraceres."
                
            },
            rClave: {
                required: "El campo es requerido.",
                equalTo: "La clave no es igual."
            }
        },
        errorElement: "div",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "invalid-feedback" ); 

            if ( element.prop( "type" ) === "checkbox" ) {
                    error.insertAfter( element.parent( "label" ) );
            } else {
                    error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            //$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
        },
        unhighlight: function (element, errorClass, validClass) {
            //$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
        }
    })
    
    $("#form-pedido").validate({
        rules: {
            rut: {
                required: true,
                maxlength: 15
            },
            comprador:{
                required: true
            },
            optPago:{
                required: true
            },
            optRetiro:{
                required: true
            }
            
        },
        messages: {
            nombre: {
                required: "El campo es requerido.",
                minlength: "Debe tener un minimo de 3 caraceres."
            },
            
        },
        errorElement: "div",
        errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "invalid-feedback" ); 

            if ( element.prop( "type" ) === "checkbox" ) {
                    error.insertAfter( element.parent( "label" ) );
            } else {
                    error.insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            //$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
        },
        unhighlight: function (element, errorClass, validClass) {
            //$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
        }
    })
    


});
	

