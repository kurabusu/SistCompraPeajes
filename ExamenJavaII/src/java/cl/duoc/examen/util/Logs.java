package cl.duoc.examen.util;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose tolosa
 */
public class Logs { 
    
    private static final Logger logger = Logger.getLogger("LogProyecto");
    
    public static void log(Exception ex, String level, String msg){
        FileHandler fh = null;
        try {
            fh = new FileHandler("C:/logs/sistema.xml", true);
            logger.addHandler(fh);
            switch (level) {
                case "severe":
                    logger.log(Level.SEVERE, msg, ex);
                    break;
                case "warning":
                    logger.log(Level.WARNING, msg, ex);
                    break;
                case "info":
                    logger.log(Level.INFO, msg, ex);
                    break;
                case "config":
                    logger.log(Level.CONFIG, msg, ex);
                    break;
                case "fine":
                    logger.log(Level.FINE, msg, ex);
                    break;
                case "finer":
                    logger.log(Level.FINER, msg, ex);
                    break;
                case "finest":
                    logger.log(Level.FINEST, msg, ex);
                    break;
                default:
                    logger.log(Level.CONFIG, msg, ex);
                    break;
                }
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        } finally{
            if(fh!=null)fh.close();
        }
        
    }
}
