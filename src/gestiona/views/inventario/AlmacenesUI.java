/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.inventario;

import gestiona.system.interfaces.ViewInterface;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Casarrubias
 */
public class AlmacenesUI implements ViewInterface{
    
    @Override
    public JPanel init(HashMap data){
        
        JPanel
                
        articulos = new JPanel();
        
        JLabel test = new JLabel("Almacenes");
        
        articulos.add(test);
        
        return articulos;
        
    }
    
}
