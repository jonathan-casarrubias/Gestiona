package gestiona.views.inventario;
// importemos nuestras librerias
import gestiona.system.interfaces.ViewInterface;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase administra la vista de Articulos
 */
public class ArticulosUI implements ViewInterface{

    // Creamos las etiquetas requeridas para esta vista.
    private JLabel articuloTitle      = new JLabel("Articulo: ",JLabel.TRAILING),
                   almacenTitle       = new JLabel("Almacen: ",JLabel.TRAILING),
                   monedaTitle        = new JLabel("Moneda: ",JLabel.TRAILING),
                   precioTitle        = new JLabel("Precio: ",JLabel.TRAILING),
                   cantidadTitle      = new JLabel("Cantidad: ",JLabel.TRAILING),
                   observacionesTitle = new JLabel("Observaciones: ",JLabel.TRAILING);
    
    // Ahora debemos crear los campos de texto y listas necesarias.
    private JTextField articuloField = new JTextField(40),
                       cantidadField = new JTextField(5),
                       precioField   = new JTextField(5);
    private JComboBox  almacenField  = new JComboBox(new String[]{
        "Guadalajara",
        "Zapopan",
        "México DF"
    }),
                       monedaField  = new JComboBox(new String[]{
        "MX",
        "USD"
    });
    private JTextArea observacionesField = new JTextArea();
   /**
    * @method init
    * Es hora de iniciar con la carga de la vista
    **/
    @Override
    public JPanel init(){
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weighty = 1;
        
        JPanel
                
        articulos = new JPanel();
        articulos.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        articulos.setLayout(new GridBagLayout());
        
        int col_a_gridwith = 1;
        int col_b_gridwith = 4;
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = col_a_gridwith;
        articulos.add(articuloTitle,c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = col_b_gridwith;
        articulos.add(articuloField,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = col_a_gridwith;
        articulos.add(almacenTitle,c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = col_b_gridwith;
        articulos.add(almacenField,c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = col_a_gridwith;
        articulos.add(cantidadTitle,c);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = col_b_gridwith;
        articulos.add(cantidadField,c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = col_a_gridwith;
        articulos.add(precioTitle,c);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = col_b_gridwith;
        articulos.add(precioField,c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = col_a_gridwith;
        articulos.add(monedaTitle,c);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = col_b_gridwith;
        articulos.add(monedaField,c);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = col_a_gridwith;
        articulos.add(observacionesTitle,c);
        c.gridx = 1;
        c.gridy = 5;
        c.ipady     = 100;
        c.ipadx     = 500;
        c.gridwidth = col_b_gridwith;        
        observacionesField.setColumns(40);
        observacionesField.setRows(10);

        articulos.add(observacionesField,c);
                
        return articulos;
        
    }
    
 
    
}
