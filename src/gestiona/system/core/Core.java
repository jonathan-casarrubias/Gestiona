package gestiona.system.core;
// Carguemos las librerias necesarias
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JFrame;
/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase inicia la ventana principal y carga nuestro primer controlador
 * El cual esta definido en gestiona.config.Settings 
 **/
public class Core {
    // Aqui vamos a contener la ventana principal.
    public static JFrame MAIN_WINDOW;
   /**
    * @method init
    * @throws InstantiationException
    * @throws IllegalAccessException 
    * 
    * Metodo el cual nos sirve como constructor 
    **/
    public static void init() throws InstantiationException, IllegalAccessException {                       
        // Ahora creamos la ventana principal de nuestra aplicación   
        Core.MAIN_WINDOW = new JFrame(gestiona.config.Settings.SOFTWARE_NAME+" - "+gestiona.config.Settings.SOFTWARE_DESCRIPTION);
        Core.MAIN_WINDOW.setSize(800,400);        
        Core.MAIN_WINDOW.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });   
        // Carguemos nuestro controlador inicial
        gestiona.system.core.Load.controller(gestiona.config.Settings.MAIN_CONTROLLER);        
    }    
}
