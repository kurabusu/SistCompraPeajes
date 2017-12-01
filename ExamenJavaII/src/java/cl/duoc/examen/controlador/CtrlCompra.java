/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jose tolosa
 */
public class CtrlCompra {
    
    
    public int ingresar(ClassCompra cc){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            String sql = "INSERT INTO tbl_compra(empId, comprador, com_total, com_opcion_pago, com_opcion_retiro) " 
                    +" VALUES(?, ?, ?, ?, ?);";
            
            cnx = Conexion.obtener();
            
            ps = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cc.getEmpId());
            ps.setString(2, cc.getCompradorPor());
            ps.setInt(3, cc.getTotal());
            ps.setInt(4, cc.getOpcionPago());
            ps.setInt(5, cc.getOpcionRetiro());
            
            int b = ps.executeUpdate();
            
            if(b > 0) {
                rs = ps.getGeneratedKeys();
                rs.next(); 
                id = rs.getInt(1);
            }
            
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
}
