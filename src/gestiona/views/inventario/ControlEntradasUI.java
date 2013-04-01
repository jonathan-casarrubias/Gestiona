/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.inventario;

import gestiona.system.interfaces.ViewInterface;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Casarrubias
 */
public class ControlEntradasUI implements ViewInterface{
    
    @Override
    public JPanel init(HashMap data){
        
        JPanel
                
        articulos = new JPanel();
        
        JLabel test = new JLabel("Entradas");
        
        articulos.add(test);
        
        return articulos;
        
    }
    
}
