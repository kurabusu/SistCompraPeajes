package cl.duoc.examen.modelo;

/**
 *
 * @author jose tolosa
 */
public class ClassCarretera {
    
    private int careId;
    private String careNombre;
    private int careCosto;

    public ClassCarretera() {
        this.careId = 0;
        this.careNombre = null;
        this.careCosto = 0;
    }

    public int getCareId() {
        return careId;
    }

    public void setCareId(int careId) {
        this.careId = careId;
    }

    public String getCareNombre() {
        return careNombre;
    }

    public void setCareNombre(String careNombre) {
        this.careNombre = careNombre;
    }

    public int getCareCosto() {
        return careCosto;
    }

    public void setCareCosto(int careCosto) {
        this.careCosto = careCosto;
    }
    
    
    
    
}
