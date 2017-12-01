package cl.duoc.examen.modelo;

/**
 *
 * @author jose tolosa
 */
public class ClassEmpresa {
    
    private int empId;
    private String empRut;
    private String empNombre;
    private String empDireccion;

    public ClassEmpresa(int empId, String empRut, String empNombre, String empDireccion) {
        this.empId = empId;
        this.empRut = empRut;
        this.empNombre = empNombre;
        this.empDireccion = empDireccion;
    }

    public ClassEmpresa() {
        this.empId = 0;
        this.empRut = null;
        this.empNombre = null;
        this.empDireccion = null;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpRut() {
        return empRut;
    }

    public void setEmpRut(String empRut) {
        this.empRut = empRut;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    @Override
    public String toString() { 
        return "{ \"empId\":\"" + empId + "\", \"empRut\":\"" + empRut + "\", \"empNombre\":\"" + empNombre + "\", \"empDireccion\":\"" + empDireccion + "\"} ";
    }
    
}
