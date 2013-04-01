/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.layout;

import gestiona.system.interfaces.ViewInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Jonathan Casarrubias
 */
public class Footer implements ViewInterface {
    
    @Override
    public JPanel init(HashMap data){
        
        // Lets create our panel for our footer
        JPanel
                
        footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        
        // Now lets add the logo
        JLabel logo = new JLabel(gestiona.config.Settings.SOFTWARE_COPYRIGHT);
               logo.setForeground(Color.black);
               
        footer.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.PAGE_START);
        footer.add(logo,BorderLayout.PAGE_END);  
        
        return footer;        
    }
}
