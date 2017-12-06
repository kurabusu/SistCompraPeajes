/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassUsuario;
import cl.duoc.examen.util.Logs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author jose tolosa
 */
public class CtrlUsuario {
    
    /**
     * Metodo para realizar el login de la aplicacion.
     * @param usuario recibe un string que es el nombre de usuario.
     * @param clave recibe un string que es la clave del usuario
     * @return devuelve un objeto de tipo ClassUsuario con la informacion del usuario
     */
    public ClassUsuario Login(String usuario, String clave){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select usu_id, usu_nombre, usu_usuario from tbl_usuarios where usu_usuario=? and  usu_clave=? ";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql); 
            String cl = DigestUtils.sha1Hex(clave);
            ps.setString(1, usuario);
            ps.setString(2, cl);

            rs = ps.executeQuery();
            ClassUsuario us = new ClassUsuario();
            if (rs.next()) {
                us.setUsuId(rs.getInt("usu_id"));
                us.setUsuNombre(rs.getString("usu_nombre"));
                us.setUsuUsuario(rs.getString("usu_usuario"));
            }

            rs.close();
            ps.close();
            
            return us;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlUsuario login");
            return new ClassUsuario();
        }
    }
    
    /**
     * Metodo para ingresar un nuevo usuario al sistema
     * @param u recibe un objeto de tipo ClassUsuario con la informacion a guardar.
     * @return devuelve un true en caso de guardarlo, en caso contrario un false.
     */
    public boolean ingresar(ClassUsuario u){
        Connection cnx = null;
        PreparedStatement ps = null;

        boolean r = false;
        try {
            String sql = "insert into tbl_usuarios(usu_nombre, usu_usuario, usu_clave) values(?, ?, ?) ";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, u.getUsuNombre());
            ps.setString(2, u.getUsuUsuario());
            ps.setString(3, DigestUtils.sha1Hex(u.getUsuClave())); 
            
            int b = ps.executeUpdate();
            
            ps.close();
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlUsuario ingresar");
            return r; 
        }
    }
    
    /**
     * Metodo para moficar la informacion de un usuario a excepcion de su usuario y clave
     * @param u recibe un objeto de tipo ClassUsuario que contiene la informacion del usuario a modificar
     * @return devuele un true en caso de poder modificar, en caso contrario un false
     */
    public boolean modificar(ClassUsuario u){
        Connection cnx = null;
        PreparedStatement ps = null;

        boolean r = false;
        try {
            String sql = "update tbl_usuarios set usu_nombre=?, usu_clave=? where usu_id=?";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setString(1, u.getUsuNombre());  
            ps.setString(2, DigestUtils.sha1Hex(u.getUsuClave())); 
            ps.setInt(3, u.getUsuId());
            
            int b = ps.executeUpdate();
            
            ps.close();
            return b > 0;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlUsuario modificar");
            return r; 
        }
    }
    
    /**
     * Metodo para obtener un usuario 
     * @param id recibe un int que es el id de usuario a buscar
     * @return devuelve un objeto de tipo ClassUsuario con la informacion del usuario encontrado
     */
    public ClassUsuario obtener( int id){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClassUsuario us = new ClassUsuario();
        
        try {
            String sql = "select usu_id, usu_nombre, usu_usuario from tbl_usuarios where usu_id=?  ";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                us.setUsuId(rs.getInt("usu_id"));
                us.setUsuNombre(rs.getString("usu_nombre"));
                us.setUsuUsuario(rs.getString("usu_usuario"));
            }
            
            return us;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlUsuario obtener");
            return new ClassUsuario();
        }
    }
    
    /**
     * Metodo para obtener los usuario del sistema con filtro
     * @param cu recibe un objeto de tipo ClassUsuario que tiene la informacion del filtro a realizar
     * @return devuelve un objeto de tipo List<ClassUsuario> con la informacion de los usuarios encontrados
     */
    public List<ClassUsuario> obtenerLista(ClassUsuario cu){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClassUsuario> lus = new ArrayList<ClassUsuario>();
        int i = 1;
        try {
            String sql = "select usu_id, usu_nombre, usu_usuario from tbl_usuarios where 1=1 ";
            
            if(cu.getUsuId() > 0) sql += " and usu_id = ? ";
            if(cu.getUsuNombre() != null) sql += " and usu_nombre like concat(?, '%') ";
            if(cu.getUsuUsuario() != null) sql += " and usu_usuario like concat(?, '%') ";
            
              
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql); 
            
            if(cu.getUsuId() > 0) ps.setInt(i++, cu.getUsuId());
            if(cu.getUsuNombre() != null) ps.setString(i++, cu.getUsuNombre());
            if(cu.getUsuUsuario() != null) ps.setString(i++, cu.getUsuUsuario());
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ClassUsuario u = new ClassUsuario();
                u.setUsuId(rs.getInt("usu_id"));
                u.setUsuNombre(rs.getString("usu_nombre"));
                u.setUsuUsuario(rs.getString("usu_usuario"));
                
                lus.add(u);
            }
            
            return lus;
        } catch (Exception e) {
            Logs.log(e, "SEVERE", "error en CtrlUsuario obtenerLista");
            return new  ArrayList<ClassUsuario>();
        }
    }
    
    
    
}
