package cl.duoc.examen.modelo;

/**
 *
 * @author jose tolosa
 */
public class ClassCompra {
    
    private int comId;
    private int empId;
    private String CompradorPor;
    private int total;
    private int opcionPago;
    private String opcionPagoDescr;
    private int opcionRetiro;
    private String opcionRetiroDescr;
    private String listaCarretera;

    public ClassCompra() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public String getOpcionPagoDescr() {
        return opcionPagoDescr;
    }

    public void setOpcionPagoDescr(String opcionPagoDescr) {
        this.opcionPagoDescr = opcionPagoDescr;
    }

    public String getOpcionRetiroDescr() {
        return opcionRetiroDescr;
    }

    public void setOpcionRetiroDescr(String opcionRetiroDescr) {
        this.opcionRetiroDescr = opcionRetiroDescr;
    }

    public String getListaCarretera() {
        return listaCarretera;
    }

    public void setListaCarretera(String listaCarretera) {
        this.listaCarretera = listaCarretera;
    }
    
    @Override
    public String toString() {
        return "{\"comId\" : \"" + comId + "\" "
                + ", \"empId\" : \"" + empId + "\" "
                + ", \"CompradorPor\" : \"" + CompradorPor + "\" "
                + ", \"total\" : \"" + total + "\" "
                + ", \"opcionPago\" : \" " + opcionPago + "\" "
                + ", \"opcionPagoDescr\" : \"" + opcionPagoDescr + "\" "
                + ", \"opcionRetiro\" : \"" + opcionRetiro + "\" "
                + ", \"opcionRetiroDescr\" : \"" + opcionRetiroDescr +"\" " 
                + " }";
    } 
    
    public String toStringListaCorta(){
        return "{\"comId\" : \"" + comId + "\" "
                + ", \"total\" : \"" + total + "\" "
                + ", \"listaCarretera\" : \"" + listaCarretera + "\" " 
                + "}";
    }
}
