$( function() {
    //buscar empresa;
    $("#bRutPButton").on("click", function(event){
        var rut = $("#rut").val();
        if(rut == ""){
            return;
        }
        var opc = { "method": "POST", "url": "./ServletAjaxBuscarEmpresa", "data": { "rut": rut } };
        
        $.ajax(opc).done(function(html){
            console.log("html: "+html);
            var d = JSON.parse(html); 
            
            if(d.empId == undefined){
                alert("La empresa no fue encontrada.");
                return;
            }
            
            $("#nombre").val(d.empNombre) 
            $("#direccion").val(d.empDireccion)
            $("#idE").val(d.empId) 
        });
    })
    

    $("#aCarPButton").on("click",function(event){
        var selCarreteras = $("#selCarreteras"); 
        var idCarretera = selCarreteras.val();
        var opc = {"method":"POST", "url":"./ServletAjaxBuscarCarretera", "data": {"id": idCarretera}};
        
        $.ajax(opc).done(function(html){
            console.log("html: "+html);
            var d = JSON.parse(html); 
            var nombre = d.careNombre;
            var costo = d.careCosto;
            var id = d.careId;
            
            $("#PedidoCarreteras").append(
                    "<tr>"
                    +"<td><input name='carreteras' type='hidden' value='"+id+"'> "+nombre+"</td>" 
                    +"<td><div class='form-group'><input name='cantidades' type='number' value='1' class='form-control' attr-valor='"+costo+"' ></div></td>"
                    +"<td><button type='button' class='bRutPButton btn btn-danger'> "
                            +"<i class='fa fa-remove' aria-hidden='true'></i>" 
                        +"</button>"
                    +"</td>"
                    +"</tr>");
            optCambioCantidad();
            sacarTotal();
        }) 
    });
    
    var optCambioCantidad  = function(){
        $('input[name^="cantidades"]').keyup(function(event){
            sacarTotal(); 
        })
    }
    var sacarTotal = function(){
        var total = 0;
        $('input[name^="cantidades"]').each(function(){
            var dt = $(this);
            var cantidad = dt.val();
            var costo = dt.attr("attr-valor");
            
            total += (costo * cantidad);        
        }) 
        $("span.total").html(total);
        $("#precioTotal").val(total);
    }

});