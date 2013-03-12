/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.system.core;
/**
 * Llamemos a las librerias nativas de java necesarias
 */
import gestiona.Gestiona;
import java.util.HashMap;

/**
 *  Llamemos a las librerias de nuestra aplicacion * 
 */
import gestiona.config.Settings;
import gestiona.system.interfaces.*;
import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase es el administrador de cargas, el cual nos permite
 * cargar los diferentes controladores
 */
public class Load {    
    
    public static HashMap CONTROLLERS_CONTAINER = new HashMap();
    public static HashMap VIEWS_CONTAINER       = new HashMap();
    public static JPanel  CURRENT_VIEW;
    
    public static void controller(String controllerName){
        
        ClassLoader classLoader = Load.class.getClassLoader();
        
        ControllerInterface instancia;
      
        if(CONTROLLERS_CONTAINER.containsKey(controllerName)){
            System.out.print(gestiona.config.Settings.SOFTWARE_NAME+": Cargando controlador '"+controllerName+"' desde cache\n");
            instancia = (ControllerInterface) CONTROLLERS_CONTAINER.get(controllerName);                  
        }else{
            System.out.print(gestiona.config.Settings.SOFTWARE_NAME+": Cargando controlador '"+controllerName+"' por primera vez\n");
            Class aClass;
            try {
                aClass = classLoader.loadClass("gestiona.controllers."+controllerName);
                
                try {
                    instancia = (ControllerInterface) aClass.newInstance();
                    instancia.init();
                    CONTROLLERS_CONTAINER.put(controllerName,instancia);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }  
    
    public static void layout(HashMap sections){
        
        Iterator it = sections.entrySet().iterator();
        
        while (it.hasNext()) {
            
            Map.Entry pairs = (Map.Entry)it.next();
          
            Core.MAIN_WINDOW.add(Load.view("layout."+pairs.getKey()),pairs.getValue());           
            
            it.remove(); 
        }
        
    };
    
    public static JPanel view(String viewName, boolean bringUp) {
        
        ClassLoader classLoader = Load.class.getClassLoader();
        
        ViewInterface instancia;
       
        if(VIEWS_CONTAINER.containsKey(viewName)){
            System.out.print(gestiona.config.Settings.SOFTWARE_NAME+": Cargando vista '"+viewName+"' desde cache\n");
            instancia = (ViewInterface) VIEWS_CONTAINER.get(viewName);                  
        }else{
            System.out.print(gestiona.config.Settings.SOFTWARE_NAME+": Cargando vista '"+viewName+"' por primera vez\n");
            Class aClass;
            try {
                aClass = classLoader.loadClass("gestiona.views."+viewName);
                
                try {
                    instancia = (ViewInterface) aClass.newInstance();
                    VIEWS_CONTAINER.put(viewName,instancia);
                    CURRENT_VIEW = (JPanel) instancia.init();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(bringUp){
            gestiona.system.core.Core.MAIN_WINDOW.add(CURRENT_VIEW,BorderLayout.CENTER);
            gestiona.system.core.Core.MAIN_WINDOW.setVisible(true);    
        }   
                 
        return CURRENT_VIEW;
    }
    
    public static JPanel view(String viewName){
        return Load.view(viewName, true);
    }
}
