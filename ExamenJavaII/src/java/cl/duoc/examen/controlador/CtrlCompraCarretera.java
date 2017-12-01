package cl.duoc.examen.controlador;

import cl.duoc.examen.db.Conexion;
import cl.duoc.examen.modelo.ClassCompraCarretera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose tolosa
 */
public class CtrlCompraCarretera {

    
    public boolean ingresar(ClassCompraCarretera ccc){
        Connection cnx = null;
        PreparedStatement ps = null;
        
        try {
            String sql = "INSERT INTO tbl_compra_carretera(cc_care_id, cc_com_id, cc_cantidad, cc_total) " 
                    +" VALUES(?, ?, ?, ?);";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setInt(1, ccc.getCarreteraId());
            ps.setInt(2, ccc.getCompraId());
            ps.setInt(3, ccc.getCantidad());
            ps.setInt(4, ccc.getTotal());
            
            int b = ps.executeUpdate();
            return b > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ClassCompraCarretera> obtenerLista(int idCompra){
        Connection  cnx = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<ClassCompraCarretera> lista = new ArrayList<ClassCompraCarretera>();
        try {
            String sql = "select cc.cc_care_id, cc.cc_com_id, cc.cc_cantidad, cc.cc_total, c.care_nombre "
                    + " from tbl_compra_carretera cc "
                    + " left join tbl_carretera c on c.care_id = cc.cc_care_id"
                    + " where cc_com_id = ? ";
            cnx = Conexion.obtener();
            ps = cnx.prepareCall(sql);
            ps.setInt(1, idCompra);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ClassCompraCarretera ccc =  new ClassCompraCarretera();
                ccc.setCarreteraId(rs.getInt("cc_care_id"));
                ccc.setCarreteraNombre(rs.getString("care_nombre"));
                ccc.setCompraId(rs.getInt("cc_com_id"));
                ccc.setCantidad(rs.getInt("cc_cantidad"));
                ccc.setTotal(rs.getInt("cc_total"));
                
                lista.add(ccc);
            }
            
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<ClassCompraCarretera>();
        }
    }
    
}
