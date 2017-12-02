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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose tolosa
 */
public class CtrlCompra {
    
    /**
     * 
     * @param cc
     * @return 
     */
    public int ingresar(ClassCompra cc){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            String sql = "INSERT INTO tbl_compra(emp_Id, comprador, com_total, com_opcion_pago, com_opcion_retiro) " 
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
            
            ps.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public ClassCompra obtener(int id){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClassCompra cc = new ClassCompra();
        try {
            String sql = "SELECT tc.com_id, tc.emp_Id, tc.comprador, tc.com_total "
                    + ", tc.com_opcion_pago, tpo.opc_pago_descripcion " 
                    + ", tc.com_opcion_retiro, tpr.opc_retiro_descripcion "
                    + " FROM tbl_compra tc " 
                    + " LEFT JOIN tbl_opc_pago tpo on tpo.opc_pago_id = tc.com_opcion_pago"
                    + " LEFT JOIN tbl_opc_retiro tpr on tpr.opc_retiro_id = tc.com_opcion_retiro"
                    + " where com_id = ?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql); 
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                cc.setComId(rs.getInt("com_id"));
                cc.setEmpId(rs.getInt("emp_Id"));
                cc.setCompradorPor(rs.getString("comprador"));
                cc.setTotal(rs.getInt("com_total"));
                cc.setOpcionPago(rs.getInt("com_opcion_pago"));
                cc.setOpcionPagoDescr(rs.getString("opc_pago_descripcion"));
                cc.setOpcionRetiro(rs.getInt("com_opcion_pago"));
                cc.setOpcionRetiroDescr(rs.getString("opc_retiro_descripcion"));
            } 
            
            return  cc;
        } catch (Exception e) {
            e.printStackTrace();
            return new ClassCompra();
        }
    }
    
    
    public List<ClassCompra> obtenerLista(ClassCompra c){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        List<ClassCompra> lcc = new ArrayList<ClassCompra>(); 
        int i = 1;
        try {
            String sql = "SELECT tc.com_id, tc.emp_Id, tc.comprador, tc.com_total "
                    + ", tc.com_opcion_pago, tpo.opc_pago_descripcion " 
                    + ", tc.com_opcion_retiro, tpr.opc_retiro_descripcion "
                    + ", (select GROUP_CONCAT(c.care_nombre SEPARATOR ' - ' ) AS con_care " 
                    + "    from tbl_carreteras c " 
                    + "    left join tbl_compra_carretera ca on ca.cc_care_id = c.care_id " 
                    + "     where ca.cc_com_id = tc.com_id) as lista_carreteras "
                    + " FROM tbl_compra tc " 
                    + " LEFT JOIN tbl_opc_pago tpo on tpo.opc_pago_id = tc.com_opcion_pago"
                    + " LEFT JOIN tbl_opc_retiro tpr on tpr.opc_retiro_id = tc.com_opcion_retiro"
                    + " where 1=1 ";
            
            if(c.getComId() > 0) sql += " and tc.com_id = ?";
            if(c.getEmpId() > 0) sql += " and tc.emp_id = ?";
            if(c.getCompradorPor() != null) sql += " and tc.comprador like concat(?, %)";
            if(c.getOpcionPago() > 0) sql += " and tc.com_opcion_pago = ?";
            if(c.getOpcionRetiro() > 0) sql += " and tc.com_opcion_retiro = ?";
            
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql); 
            
            if(c.getComId() > 0) ps.setInt(i++, c.getComId());
            if(c.getEmpId() > 0) ps.setInt(i++, c.getEmpId());
            if(c.getCompradorPor() != null) ps.setString(i++, c.getCompradorPor());
            if(c.getOpcionPago() > 0) ps.setInt(i++, c.getOpcionPago());
            if(c.getOpcionRetiro() > 0) ps.setInt(i++, c.getOpcionRetiro()); 
            
            rs = ps.executeQuery();
            
            while (rs.next()){ 
                ClassCompra cc = new ClassCompra();
                cc.setComId(rs.getInt("com_id"));
                cc.setEmpId(rs.getInt("emp_Id"));
                cc.setCompradorPor(rs.getString("comprador"));
                cc.setTotal(rs.getInt("com_total"));
                cc.setOpcionPago(rs.getInt("com_opcion_pago"));
                cc.setOpcionPagoDescr(rs.getString("opc_pago_descripcion"));
                cc.setOpcionRetiro(rs.getInt("com_opcion_pago"));
                cc.setOpcionRetiroDescr(rs.getString("opc_retiro_descripcion"));
                cc.setListaCarretera(rs.getString("lista_carreteras")); 
                
                lcc.add(cc);
            } 
            
            rs.close();
            ps.close(); 
            
            return lcc;
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<ClassCompra>(); 
        }
    }
    
}
