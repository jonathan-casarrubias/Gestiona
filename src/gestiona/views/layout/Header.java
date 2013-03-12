/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.layout;

import gestiona.config.Settings;
import gestiona.system.interfaces.ViewInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Jonathan Casarrubias
 */
public class Header implements ViewInterface{
    
    @Override
    public JPanel init(){
        
        // Lets create our panel for our footer
        JPanel
                
        header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        
        // Now lets add the logo
        JLabel logo = new JLabel(gestiona.config.Settings.SOFTWARE_NAME+" - "+gestiona.config.Settings.SOFTWARE_DESCRIPTION);
               logo.setForeground(Color.black);
               
        header.add(logo, BorderLayout.PAGE_START);         
        header.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.PAGE_END);
        
        return header;        
    }

}
