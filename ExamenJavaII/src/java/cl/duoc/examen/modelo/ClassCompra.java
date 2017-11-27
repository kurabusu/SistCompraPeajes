package cl.duoc.examen.modelo;

/**
 *
 * @author jose tolosa
 */
public class ClassCompra {
    
    private int comId;
    private String rut;
    private String nombre;
    private String direccion;
    private String CompradorPor;
    private int total;
    private int opcionPago;
    private int opcionRetiro;

    public ClassCompra() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCompradorPor() {
        return CompradorPor;
    }

    public void setCompradorPor(String CompradorPor) {
        this.CompradorPor = CompradorPor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOpcionPago() {
        return opcionPago;
    }

    public void setOpcionPago(int opcionPago) {
        this.opcionPago = opcionPago;
    }

    public int getOpcionRetiro() {
        return opcionRetiro;
    }

    public void setOpcionRetiro(int opcionRetiro) {
        this.opcionRetiro = opcionRetiro;
    }
    
    
    
}
