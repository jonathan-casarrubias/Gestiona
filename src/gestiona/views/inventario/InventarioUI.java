package gestiona.views.inventario;

// Lets call the native libraries
import gestiona.system.interfaces.ViewInterface;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import gestiona.system.core.Load;
/**
 * @author Jonathan Casarrubias
 **/
public class InventarioUI implements ViewInterface {
    
   public JPanel inventarioPanel;
   public JPanel inventarioSubPanel;
   
   // Creamos el contenedor con los titulos
   // de nuestro menu y las clases que manda a llamar
   private String[][] menuItems = {
            {"Articulos", "Almacenes","Control de Entradas","Control de Salidas"},
            {"inventario.ArticulosUI", "inventario.AlmacenesUI","inventario.ControlEntradasUI","inventario.ControlSalidasUI"}
   };    
   /**
    * @method inventario
    * @return JPanel
    * 
    * Este metodo crea el modulo de inventario
    * Crea el menu a la izquierda y manda llamar 
    **/
    @Override
    public JPanel init() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        
        // Lets first create our JPanel
        inventarioPanel = new JPanel(new BorderLayout());
        inventarioPanel.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
      
        inventarioPanel.add(gestiona.views.layout.Menu.left(inventarioPanel, menuItems),BorderLayout.WEST);   
        inventarioPanel.add(gestiona.system.core.Load.view(menuItems[1][0]),BorderLayout.CENTER);
        
        return inventarioPanel;
        
    }    
     
}
