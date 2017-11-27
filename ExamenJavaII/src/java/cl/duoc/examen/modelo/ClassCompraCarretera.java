/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.modelo;

/**
 *
 * @author jose tolosa
 */
public class ClassCompraCarretera {
    
    private int carreteraId;
    private int compraId;
    private int cantidad;
    private int total; 

    public ClassCompraCarretera() {
    }

    public int getCarreteraId() {
        return carreteraId;
    }

    public void setCarreteraId(int carreteraId) {
        this.carreteraId = carreteraId;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
