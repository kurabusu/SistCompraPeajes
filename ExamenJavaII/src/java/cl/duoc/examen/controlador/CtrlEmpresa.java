package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassEmpresa;
import cl.duoc.examen.util.Logs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose tolosa
 */
public class CtrlEmpresa {
    
    /**
     * Metodo para ingresar un nueva empresa.
     * @param ce recibe un objeto de tipo ClassEmpresa con la informacion nueva.
     * @return devuelve true en caso de guardarlo, en caso contrario un false.
     */
    public boolean ingresar(ClassEmpresa ce){
        Connection cnx = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO tbl_empresas(emp_rut, emp_nombre, emp_direccion) VALUES( ?, ?, ?);";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, ce.getEmpRut());
            ps.setString(2, ce.getEmpNombre());
            ps.setString(3, ce.getEmpDireccion());
            
            int b = ps.executeUpdate();
            
            ps.close();
            
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlEmpresa ingresar");
            return false;
        }
    }
    
    /**
     * Metodo para modificar una empresa
     * @param ce recibe un objeto de tipo ClassEmpresa con la informacion a modificar.
     * @return devuelve true en caso de modificarlo, en caso contrario un false.
     */
    public boolean modificar(ClassEmpresa ce){
        Connection cnx = null;
        PreparedStatement ps = null;
        try {
            String sql = "update tbl_empresas set emp_rut=?, emp_nombre=?, emp_direccion=? where emp_id=?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, ce.getEmpRut());
            ps.setString(2, ce.getEmpNombre());
            ps.setString(3, ce.getEmpDireccion());
            ps.setInt(4, ce.getEmpId());
            
            int b = ps.executeUpdate();
            
            ps.close(); 
            
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlEmpresa modificar");
            return false;
        }
    }
    
    /**
     * Metodo para obtener una empresa en base al id de la empresa
     * @param empId revibe un int que es el id de la empresa
     * @return devuelve un objeto de tipo ClassEmpresa con la informacion de la empresa
     */
    public ClassEmpresa obtener(int empId){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ClassEmpresa ce = new ClassEmpresa();
        try {
            String sql = "SELECT emp_id, emp_rut, emp_nombre, emp_direccion FROM tbl_empresas where emp_id=?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setInt(1, empId);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                ce.setEmpId(rs.getInt("emp_id"));
                ce.setEmpRut(rs.getString("emp_rut"));
                ce.setEmpNombre(rs.getString("emp_nombre")); 
                ce.setEmpDireccion(rs.getString("emp_direccion"));
            }
            
            rs.close();
            ps.close();
            
            return ce;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlEmpresa obtener");
            return new ClassEmpresa();
        }
    }
    
    public List<ClassEmpresa> obtenerLista(ClassEmpresa ce){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<ClassEmpresa> lce = new ArrayList<ClassEmpresa>();
        int i = 1;
        try {
            String sql = "SELECT emp_id, emp_rut, emp_nombre, emp_direccion FROM tbl_empresas where 1=1 ";
            if(ce.getEmpId() > 0) sql += " and emp_id=? ";
            if(ce.getEmpRut() != null) sql += " and emp_rut like concat(?,'%') ";
            if(ce.getEmpNombre() != null) sql += " and emp_nombre like concat(?, '%')";
            System.out.println(sql);
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            
            if(ce.getEmpId() > 0) ps.setInt(i++, ce.getEmpId());
            if(ce.getEmpRut() != null) ps.setString(i++, ce.getEmpRut());
            if(ce.getEmpNombre()!= null) ps.setString(i++, ce.getEmpNombre());
        
            rs = ps.executeQuery();
            
            while(rs.next()){
                ClassEmpresa c =  new ClassEmpresa();
                c.setEmpId(rs.getInt("emp_id"));
                c.setEmpRut(rs.getString("emp_rut"));
                c.setEmpNombre(rs.getString("emp_nombre")); 
                c.setEmpDireccion(rs.getString("emp_direccion"));
                
                lce.add(c);
            }
            
            rs.close();
            ps.close();
            
            return lce;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlEmpresa obtenerLista");
            return new ArrayList<ClassEmpresa>();
        }
    }
    
    
    
}
