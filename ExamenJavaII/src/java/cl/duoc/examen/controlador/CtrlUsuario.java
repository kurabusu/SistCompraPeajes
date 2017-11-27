/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author jose tolosa
 */
public class CtrlUsuario {
    
    /**
     * 
     * @param usuario recive un string que es el nombre de usuario.
     * @param clave recive un string que es la clave del usuario
     * @return devuelve un objeto de tipo ClassUsuario con la informacion del usuario
     */
    public ClassUsuario Login(String usuario, String clave){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select usu_id, usu_nombre, usu_usuario from usuario where usu_usuario=? and  usu_clave=? ";
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
            e.printStackTrace();
            return new ClassUsuario();
        }
    }
    
    /**
     * 
     * @param u
     * @return 
     */
    public boolean crear(ClassUsuario u){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean r = false;
        try {
         
            
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return r; 
        }
    }
    
    /**
     * 
     * @param u
     * @return 
     */
    public boolean modificar(ClassUsuario u){
        Connection cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean r = false;
        try {
         
            
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return r; 
        }
    }
    
    
    
    
    
    
}
