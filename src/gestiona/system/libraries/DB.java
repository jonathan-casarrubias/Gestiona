/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.system.libraries;
import gestiona.system.interfaces.LibraryInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan Casarrubias
 */
public class DB implements LibraryInterface{
    
    private String user,pass,server,database,
                   select = "*",
                   from   = "",
                   where  = "",
                   order  = "",
                   query  = "";
    
    private Connection conexion;
    
    public void init(){
        
        if(this.isClosed()){
            server   = JOptionPane.showInputDialog(null,"Por favor ingresa la dirección del servidor","localhost"); 
            database = JOptionPane.showInputDialog(null,"Por favor ingresa la base de datos a seleccionar","gestiona");
            user     = JOptionPane.showInputDialog(null,"Por favor ingresa el usuario","root");
            pass     = JOptionPane.showInputDialog(null,"Por favor ingresa la contraseña","");
          
            try{
                Class.forName("org.gjt.mm.mysql.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://"+server+"/"+database+"", user, pass);
                }
                catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error de conexión", "Error",
                JOptionPane.ERROR_MESSAGE);
                }
            System.out.print(gestiona.config.Settings.SOFTWARE_NAME+" Conexión con base de datos realizada satisfactoriamente\n");
            JOptionPane.showMessageDialog(null, "Conexión con base de datos realizada satisfactoriamente", "Conexión satisfactoria", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void select(String select){
        this.select = select;
    }
    
    public void from(String from){
        this.from = from;
    }
    
    public void where(String where){
        this.where = where;
    }
    
    public void order(String order){
        this.order = order;
    }
    
    public void query(String query){
        
        if(this.query.equals("")){
            this.query = select+" "+from+" "+where+" "+order;
        }
    }
    
    public ResultSet result(){
        
        ResultSet result = null;
        
        try {
            Statement st = conexion.createStatement();
            result = st.executeQuery( this.query );
            this.query = "";
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;

    }
    
    public void close(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isClosed(){
        boolean result = true;
        try {
            result = (conexion != null && !conexion.isClosed()) ? false : true ;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
