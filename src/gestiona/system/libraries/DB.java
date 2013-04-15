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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan Casarrubias
 */
public class DB {
    
    private String user,pass,server,database,
                   select = "*",
                   from   = "",
                   where  = "",
                   order  = "",
                   query  = "";
    
    private Connection conexion;
    private ResultSet CURRENT_RESULT;
    
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
    
    public void insert(String table, HashMap mp){
        
        String fields,values;
        
        Iterator it = mp.entrySet().iterator();
            
            fields = "(";
            values = "(";
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                fields += pairs.getKey();
                String field = (String) pairs.getValue();
                boolean isInt = gestiona.system.helpers.Numeric.isInteger(field,20 ); 
                values += (isInt) ? field : "'"+field+"'";
                
                if(it.hasNext()){
                fields += ",";
                values += ",";
                }
              
                it.remove();
            }
            fields += ")";
            values += ")";
            
        String insert = "INSERT INTO "+table+" "+fields+" VALUES "+values+";";
        System.out.print(insert);
        
         try {
            Statement st = conexion.createStatement();
                      st.executeUpdate(insert);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public String query(){
        
        if(this.query.equals("")){
            this.query = "SELECT "+select+" FROM "+from+" "+where+" "+order;
          
        }
        
        return this.query;
    }
    
    public ResultSet result(){
      
        try {
            Statement st = conexion.createStatement();
            CURRENT_RESULT = st.executeQuery( this.query() );
            this.query = "";
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return CURRENT_RESULT;

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
