package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassCarretera;
import cl.duoc.examen.util.Logs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class CtrlCarretera {
 
    /**
     * Metodo para ingresar una nueva carretera.
     * @param cc recibe un objeto de tipo ClassCarretera con la informacion a ingresar.
     * @return devuelve un true en caso de haber guardado, en caso contrario un false.
     */
    public boolean ingresar(ClassCarretera cc){
        Connection cnx = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO tbl_carreteras(care_nombre,care_costo) VALUES(?, ?);";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, cc.getCareNombre());
            ps.setInt(2, cc.getCareCosto());
            
            int b =  ps.executeUpdate();
            
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlCarretera ingresar");
            return false;
        }
        
    }
    
    /**
     * Metodo para modificar una carretera.
     * @param cc recibe un objeto de tipo ClassCarretera con la informacion a modificar.
     * @return devuelve un true en caso de haber modificado, en caso contrario un false.
     */
    public boolean modificar(ClassCarretera cc){
        Connection cnx = null;
        PreparedStatement ps = null;
        try {
            String sql = "update tbl_carreteras set care_nombre=?,care_costo=? where care_id=?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, cc.getCareNombre());
            ps.setInt(2, cc.getCareCosto());
            ps.setInt(3, cc.getCareId());
            
            int b =  ps.executeUpdate();
            
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlCarretera modificar");
            return false;
        }
    }
    
    /**
     * metodo para obtener una carretera.
     * @param id recibe un int que es el id de la carretera a buscar
     * @return devuelve un objeto de tipo ClassCarretera con la informacion obtenida,
     */
    public ClassCarretera obtener(int id){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClassCarretera cc = new ClassCarretera();
        try {
            String sql = "select care_id, care_nombre, care_costo from tbl_carreteras where care_id = ?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                cc.setCareId(rs.getInt("care_id"));
                cc.setCareNombre(rs.getString("care_nombre"));
                cc.setCareCosto(rs.getInt("care_costo"));
            }
            
            return cc;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlCarretera obtener");
            return new ClassCarretera();
        }
        
    }
    
    /**
     * Metodo que obtiene la lista de Carreteras que se ocupa con filtro de busqueda.
     * @param cc recibe un objeto de tipo ClassCarretera que tendra los datos para filtrar la busqueda
     * @return devuelve un objeto de tipo List<ClassCarretera> que tendra la informacion.
     */
    public List<ClassCarretera> obtenerLista(ClassCarretera cc){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClassCarretera> lcc = new ArrayList<ClassCarretera>();
        int i = 1;
        try {
            String sql = "select care_id, care_nombre, care_costo from tbl_carreteras where 1=1 ";
            if(cc.getCareId() > 0) sql += " and care_id = ?";
            if(cc.getCareNombre() != null) sql += " and  care_nombre like concat(? ,'%') ";
            if(cc.getCareCosto() > 0) sql += " and care_costo = ? ";
            
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            if(cc.getCareId() > 0) ps.setInt(i++, cc.getCareId());
            if(cc.getCareNombre() != null) ps.setString(i++, cc.getCareNombre());
            if(cc.getCareCosto() > 0) ps.setInt(i++, cc.getCareCosto());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                ClassCarretera c = new ClassCarretera();
                c.setCareId(rs.getInt("care_id"));
                c.setCareNombre(rs.getString("care_nombre"));
                c.setCareCosto(rs.getInt("care_costo"));
                lcc.add(c);
            }
            return lcc;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlCarretera obtenerLista");
            return new ArrayList<ClassCarretera>();
        }
    }
    
    
}
