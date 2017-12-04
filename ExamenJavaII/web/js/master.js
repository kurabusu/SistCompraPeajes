 var map;
   
$( function() {
    //buscarPedidos 
    $("#bBuscarPedidos").on("click", function(){
        var rut = $("#rutBusqueda").val();
        if(rut == ""){
            return;
        }
        var opc = { "method": "POST", "url": "./ServletAjaxBuscarPedidos", "data": {"rut": rut}};
        $.ajax(opc).done(function(html){ 
            var d = JSON.parse(html); 
            console.log("bBuscarPedidos: ", d); 
            if(d.error == undefined){   
                $("#tablaPedidosLista tbody").html("");
                for (var i = 0; i < d.length; i++) {
                    $("#tablaPedidosLista tbody").append(
                        " <tr> "
                        +" <td>"+d[i].listaCarretera+"</td> "
                        +" <td>"+d[i].total+"</td> "
                        +" <td>"
                        +" <a href='pedidosAgregarNuevo.jsp?id="+d[i].comId+"' class='btn btn-link'><i class=\"fa fa-plus\" aria-hidden=\"true\"></i></a>"
                        +" <a href=\"pedidosBoleta.jsp?id="+d[i].comId+"\" class=\"btn btn-link\"><i class=\"fa fa-ticket\" aria-hidden=\"true\"></i></a>"
                        +" </td> " 
                        +" </tr>"); 
                }
            }else{
                alert(d.error) 
            }
            
        })
    });
    
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
        
        if($(".carretera"+idCarretera).val() == undefined){ 
            $.ajax(opc).done(function(html){
                console.log("html: "+html);
                var d = JSON.parse(html); 
                var nombre = d.careNombre;
                var costo = d.careCosto;
                var id = d.careId;

                $("#PedidoCarreteras").append(
                        "<tr>"
                        +"<td><input name='carreteras' type='hidden' value='"+id+"' class='carretera"+id+"'> "+nombre+"</td>" 
                        +"<td><div class='form-group'><input name='cantidades' type='number' value='1' class='form-control' attr-valor='"+costo+"' ></div></td>"
                        +"<td><button type='button' class='borrarCarretera btn btn-danger'> "
                                +"<i class='fa fa-remove' aria-hidden='true'></i>" 
                            +"</button>"
                        +"</td>"
                        +"</tr>");
                optCambioCantidad();
                sacarTotal();
            }) 
        }
    });
    
    var optCambioCantidad  = function(){ 
        $('input[name^="cantidades"]').click(function(event){
            sacarTotal(); 
        }).keyup(function(event){
            sacarTotal(); 
        })
        
        $(".borrarCarretera").on("click", function(event){
            console.log("pase por aqui");
            $(this).parents("tr").remove();
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
    
    
    
    
    optCambioCantidad();
});


function mostrarMapa(direccion){ 
    var geocoder = null;
    map = null;
    $('.bd-example-modal-lg').modal("show"); 
    
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -32.5587606, lng:-73.4689263},   
        componentRestrictions: {'country': 'cl'},
        zoom: 8
    });
    
    geocoder = new google.maps.Geocoder(); 
    infowindow = new google.maps.InfoWindow;
    geocoder.geocode({'address': direccion+", chile" }, function(results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            var marker = null; 
            //console.log(results)
            if (results[0]) {
                marker = new google.maps.Marker({
                    map: map, 
                    position: results[0].geometry.location,
                    title: direccion
                });
                var infowindow = new google.maps.InfoWindow({ 
                    content: results[0].formatted_address
                });

                
                marker.addListener('click', function() {
                    infowindow.open(map, marker);
                });

                //console.log("infowindow",infowindow);
                //infowindow.setContent(results[0].formatted_address || direccion);  
                //infowindow.open(map, marker);
            }else{

            }
        } else { 
            console.log("geocoder else")
            alert('No se puede encontrar el nombre de la carretera dentro del mapa.');
        } 
    });
    
    setTimeout(function() {
        console.log("setTimeout");
        google.maps.event.trigger(map, 'resize');    
    }, 1000);  
} 
   
function initMap() {
    /*map = new google.maps.Map(document.getElementById('map'), {
       //center: {lat: -33.4581345, lng:-20.20 },  
        zoom: 8
    });
    google.maps.event.trigger(map, 'resize'); */
}
    
function print(nombreDiv) {
     var contenido= document.getElementById(nombreDiv).innerHTML;
     var contenidoOriginal= document.body.innerHTML;
     document.body.innerHTML = contenido;
     window.print();
     document.body.innerHTML = contenidoOriginal;
}

