/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.system.interfaces;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Casarrubias
 */
public interface ViewInterface {
    
    public JPanel init() throws InstantiationException, IllegalAccessException, ClassNotFoundException;
    
}
