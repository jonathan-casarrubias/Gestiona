/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.inventario;

import gestiona.system.interfaces.ViewInterface;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Casarrubias
 */
public class ControlSalidasUI implements ViewInterface {
    
    @Override
    public JPanel init(){
        
        JPanel
                
        articulos = new JPanel();
        
        JLabel test = new JLabel("Salidas");
        
        articulos.add(test);
        
        return articulos;
        
    }
    
}
