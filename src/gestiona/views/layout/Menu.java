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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
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
    
    
    public static JMenuBar top(){
        
        JMenuBar bar = new JMenuBar();        

        JMenu menuArchivo = new javax.swing.JMenu();
        menuArchivo.setText("Archivo");
        menuArchivo.setMnemonic(KeyEvent.VK_A);
        bar.add(menuArchivo);
        
        JMenuItem abrirItem = new javax.swing.JMenuItem("Abrir", KeyEvent.VK_B);
        menuArchivo.add(abrirItem);
        
        JMenuItem salirItem = new javax.swing.JMenuItem("Salir", KeyEvent.VK_S);
        
        menuArchivo.add(new JSeparator(SwingConstants.HORIZONTAL));
        menuArchivo.add(salirItem);
        
        abrirItem.addActionListener( new ActionListener() {
            private Object ObjectvalorElegido;
              @Override
              public void actionPerformed(ActionEvent event) {  
                    JFileChooser fc= new JFileChooser();
                    fc.showOpenDialog(null);
                    File file = fc.getSelectedFile();
                    Object[] valores = { "Inventario", "Articulo", "Cotización" };
                    ObjectvalorElegido = JOptionPane.showInputDialog(null,"Elige tipo de archivo", "Abrir archivo",
                    JOptionPane.INFORMATION_MESSAGE, null,valores, valores[0]);     
                    JOptionPane.showMessageDialog(null, "Este archivo no parece ser del tipo correcto", "Cuidado",
                    JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Oops lo siento, no puedo continuar!", "Error",
                    JOptionPane.ERROR_MESSAGE);
              }
        });  
        
        salirItem.addActionListener( new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {  
                  if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Estas seguro que deseas salir?")){
                     System.exit(0);    
                  }                  
              }
        });        
        

        
        return bar;     
        
    }
}
