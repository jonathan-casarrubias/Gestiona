/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.views.layout;

import gestiona.system.interfaces.ViewInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase crea los diferentes menus dentro de nuestra aplicación
 **/
public class Menu implements ViewInterface{
    
    @Override
    public JPanel init(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
   /**
    * @method left      
    * @param module
    * @param items
    * @return 
    * 
    * Este metodo crea dinamicamente el menu a la izquierda de cada modulo
    **/
    public static JPanel left(final JPanel view, String[][] items){
        // Iniciamos creando una instancia del panel para nuestro menu
        JPanel
                
        left = new JPanel(new GridLayout(0,1));
        left.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        
        // Ahora creamos los elementos de nuestro menu dinamicamente
        for(int i = 0; i < items[0].length; i++){
            
            final String current = items[0][i];
            final String linkto  = items[1][i];
            
            JButton 
                    
            btn = new JButton(current);
            // Lets set the event listener
            btn.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){                    
                    BorderLayout layout = (BorderLayout) view.getLayout();
                    view.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                                      
                    JPanel 
                            
                    subpanel;
                    subpanel = gestiona.system.core.Load.view(linkto,false);
               
                    view.add(subpanel,BorderLayout.CENTER);
                    view.revalidate(); 
                    view.repaint();                        
                                                        
                }
            });
            
            left.add(btn);            
        }
        
        return left;
    }
}
