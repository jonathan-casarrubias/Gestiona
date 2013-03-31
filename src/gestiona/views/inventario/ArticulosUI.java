package gestiona.views.inventario;
// importemos nuestras librerias
import gestiona.system.interfaces.ViewInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;

/**
 * @author Jonathan Casarrubias
 * 
 * Esta clase administra la vista de Articulos
 */
public class ArticulosUI implements ViewInterface{

    // Creamos las etiquetas requeridas para esta vista.
    private JLabel articuloLabel      = new JLabel("Articulo: ",JLabel.TRAILING),
                   almacenLabel       = new JLabel("Almacen: ",JLabel.TRAILING),
                   monedaLabel        = new JLabel("Moneda: ",JLabel.TRAILING),
                   precioLabel        = new JLabel("Precio: ",JLabel.TRAILING),
                   cantidadLabel      = new JLabel("Cantidad: ",JLabel.TRAILING),
                   spinnerLabel       = new JLabel("Proveedor: ",JLabel.TRAILING),
                   observacionesLabel = new JLabel("Observaciones: ",JLabel.TRAILING);
    
    // Ahora debemos crear los campos de texto y listas necesarias.
    private JTextField articuloField = new JTextField(20),
                       cantidadField = new JTextField(20),
                       precioField   = new JTextField(20);
    private JComboBox  almacenField  = new JComboBox(new String[]{
        "Guadalajara",
        "Zapopan",
        "México DF"
    }),
                       monedaField  = new JComboBox(new String[]{
        "MX",
        "USD"
    });
    // Ahora creamos el boton de guardar
    private JButton guardarBtn = new JButton("Guardar");
    
    // Creamos el objeto que va a contener nuestros articulos
    Object[][] articulos;
    
    // Creamos el modelo para nuestra tabla
    DefaultTableModel model;
    
    // Creamos el campo de texto para nuestras observaciones
    private JTextArea observacionesField = new JTextArea();
    
    // Ahora creamos un text area para la ayuda
    private JTextArea helpText = new JTextArea("\nPara crear un nuevo articulo. \n\n Llena el formulario y posteriormente\n presione el botón de guardar. \n\n Recuerda que el campo de \n observaciones es opcional, el resto\n de los campos del formulario son\n obligatorios. \n\n Cuando guardes un nuevo articulo,\n automaticamente aparecerá en\n la tabla inferior.");
    
    // Por ultimo creamos un spinner para nuestros proveedores
    private JSpinner spinnerField = new JSpinner();
    

   /**
    * @method init
    * Es hora de iniciar con la carga de la vista
    **/
    @Override
    public JPanel init(){
        
        
        JPanel
                
        articulos = new JPanel();
        articulos.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        articulos.setLayout(new BorderLayout());
        
        articulos.add(this.createForm(),BorderLayout.CENTER);
        
        helpText.setMargin(new Insets(10,10,10,10)); 
        helpText.setBackground(Color.decode("#eeeeee"));
        articulos.add(helpText,BorderLayout.LINE_END);
        articulos.add(this.createTable(),BorderLayout.SOUTH);      
        
        // Creamos un escucha para nuestro botón de guardar
        guardarBtn.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){        
                
               save();
                                                        
            }
            
        });
                
        return articulos;
        
        
    }
    
    public void save(){
         // Primero verifiquemos que se haya escrito algún articulo    
                if(articuloField.getText() == null || articuloField.getText().trim().equals( "" )){
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un articulo", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Ahora verifiquemos que se haya escrito alguna cantidad    
                if(cantidadField.getText() == null || cantidadField.getText().trim().equals( "" ) || !gestiona.system.helpers.Numeric.isInteger(cantidadField.getText(),10)){
                    JOptionPane.showMessageDialog(null, "Por favor ingresa una cantidad", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Ahora verifiquemos que se haya escrito algun precio
                if(precioField.getText() == null || precioField.getText().trim().equals( "" ) || !gestiona.system.helpers.Numeric.isInteger(precioField.getText(),10)){
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un precio", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                                                
                 model.insertRow(0,new Object[]{
                     articuloField.getText(),
                     almacenField.getSelectedItem(),
                     cantidadField.getText(),
                     precioField.getText(),
                     monedaField.getSelectedItem(),
                     spinnerField.getValue(),
                     observacionesField.getText()
                 });
    }
    
 /**
    * @method form
    * Es hora de iniciar con la carga de la vista
    **/
    public JScrollPane createTable(){
    
        String[] col = {
            "Articulo",
            "Almacen",
            "Cantidad",
            "Precio",
            "Moneda",
            "Proveedor",
            "Observaciones"
        };
        
        Object[][] data = {};
        
        model = new DefaultTableModel(data,col);
        
        JTable table = new JTable(model);               
        JScrollPane pane = new JScrollPane(table);
                    pane.setPreferredSize(new Dimension(5000,350));
        
        return pane;
    
    
    }
 /**
    * @method form
    * Es hora de iniciar con la carga de la vista
    **/
    public JPanel createForm(){
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weighty = 1;
        
        JPanel
                
        form = new JPanel();
        form.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        form.setLayout(new GridBagLayout());
        
        int col_a_gridwith = 1;
        int col_b_gridwith = 1;
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = col_a_gridwith;
        form.add(articuloLabel,c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = col_b_gridwith;
        form.add(articuloField,c);
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = col_a_gridwith;
        form.add(almacenLabel,c);
        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = col_b_gridwith;
        form.add(almacenField,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = col_a_gridwith;
        form.add(cantidadLabel,c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = col_b_gridwith;
        form.add(cantidadField,c);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = col_a_gridwith;
        form.add(precioLabel,c);
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = col_b_gridwith;
        form.add(precioField,c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = col_a_gridwith;
        form.add(monedaLabel,c);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = col_b_gridwith;
        form.add(monedaField,c);
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = col_a_gridwith;
        form.add(spinnerLabel,c);
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = col_b_gridwith;
        spinnerField.setModel(new javax.swing.SpinnerListModel(new String[] {
            "Bombas Hidraulicas de Occidente S.A. de C.V.",
            "Plast Ma - Materiales Plásticos S.A. de C.V.",
            "Vivero Aguilera", 
            "Textiles Sinteticos S. de R.L. de C.V", 
            "Madera Sintetica Prodecks"
        }));
        form.add(spinnerField,c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = col_a_gridwith;
        form.add(observacionesLabel,c);
        c.gridx = 1;
        c.gridy = 3;
        c.ipady     = 50;
        c.ipadx     = 350;
        c.gridwidth = col_b_gridwith;        
        observacionesField.setColumns(30);
        observacionesField.setRows(10);

        form.add(new JScrollPane(observacionesField),c);
        
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = col_b_gridwith;
        form.add(guardarBtn,c);
                
        return form;
        
    }
    
}
