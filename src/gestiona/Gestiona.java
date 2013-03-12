package gestiona;
/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase es nuestro constructor, el cual se encarga de
 * iniciar los procesos requeridos del software
 **/
public class Gestiona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        
        // Enviamos un mensaje a la consola, para informar que hemos iniciadio
        System.out.println(gestiona.config.Settings.SOFTWARE_NAME+": Inicia la carga del software\n");
               
        // Iniciamos el sistema
        gestiona.system.core.Core.init();        
                
    }
}
