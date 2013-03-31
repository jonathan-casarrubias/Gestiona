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
                   proveedoresLabel   = new JLabel("Proveedor: ",JLabel.TRAILING),
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
    // Creamos el modelo para nuestra la tabla para nuestros resultados
    DefaultTableModel model;
    // Creamos el campo de texto para nuestras observaciones
    private JTextArea observacionesField = new JTextArea();
    // Ahora creamos un text area para la ayuda
    private JTextArea helpText = new JTextArea("\nPara crear un nuevo articulo. \n\n Llena el formulario y posteriormente\n presione el botón de guardar. \n\n Recuerda que el campo de \n observaciones es opcional, el resto\n de los campos del formulario son\n obligatorios. \n\n Cuando guardes un nuevo articulo,\n automaticamente aparecerá en\n la tabla inferior.");
    // Por ultimo creamos un spinner para nuestros proveedores
    private JSpinner proveedoresField = new JSpinner();  
   /**
    * @method init
    * Es hora de iniciar con la carga de la vista
    **/
    @Override
    public JPanel init(){        
        // Creamos el panel que va a contener nuestra vista
        // y le asignamos un BorderLayout
        JPanel
                
        articulos = new JPanel();
        articulos.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        articulos.setLayout(new BorderLayout());        
        // Ahora creamos un escucha para nuestro botón de guardar
        guardarBtn.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){   
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
                     proveedoresField.getValue(),
                     observacionesField.getText()
                 });                                 
            }
        });
        // Por ultimo agregamos el contenido a nuestro panel
        articulos.add(this.createForm(),BorderLayout.CENTER);
        articulos.add(this.createHelpBar(),BorderLayout.LINE_END);
        articulos.add(this.createTable(),BorderLayout.SOUTH);  
        
        return articulos;
        
    }
   /**
    * @method createForm
    * El metodo createForm, se encarga de ingresar todas las etiquetas y campos 
    * a nuestro panel de formulario.
    **/
    public JPanel createForm(){
        // Creamos un GridBagConstraints para posicionar nuestro formulario
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weighty = 1;
        c.gridwidth = 1;
        // Creamos el panel que servira para nuestro formulario
        JPanel
                
        form = new JPanel();
        form.setBackground(Color.decode(gestiona.config.Settings.BACKGROUND_COLOR));
        form.setLayout(new GridBagLayout());
        
        // Agregamos la etiqueta y campo para articulo
        c.gridx = 0;
        c.gridy = 0;
        form.add(articuloLabel,c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(articuloField,c);
        
        // Agregamos la etiqueta y campo para almacen
        c.gridx = 2;
        c.gridy = 0;
        form.add(almacenLabel,c);
        c.gridx = 3;
        c.gridy = 0;
        form.add(almacenField,c);
        
        // Agregamos la etiqueta y campo para cantidad
        c.gridx = 0;
        c.gridy = 1;
        form.add(cantidadLabel,c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(cantidadField,c);
        
        // Agregamos la etiqueta y campo para precio
        c.gridx = 2;
        c.gridy = 1;
        form.add(precioLabel,c);
        c.gridx = 3;
        c.gridy = 1;
        form.add(precioField,c);
        
        // Agregamos la etiqueta y campo para moneda
        c.gridx = 0;
        c.gridy = 2;
        form.add(monedaLabel,c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(monedaField,c);
        
        // Agregamos la etiqueta y campo para proveedores
        c.gridx = 2;
        c.gridy = 2;
        form.add(proveedoresLabel,c);
        c.gridx = 3;
        c.gridy = 2;
        proveedoresField.setModel(new javax.swing.SpinnerListModel(new String[] {
            "Bombas Hidraulicas de Occidente S.A. de C.V.",
            "Plast Ma - Materiales Plásticos S.A. de C.V.",
            "Vivero Aguilera", 
            "Textiles Sinteticos S. de R.L. de C.V", 
            "Madera Sintetica Prodecks"
        }));
        form.add(proveedoresField,c);
        
        // Agregamos la etiqueta y campo para observaciones
        c.gridx = 0;
        c.gridy = 3;
        form.add(observacionesLabel,c);
        c.gridx = 1;
        c.gridy = 3;
        c.ipady     = 50;
        c.ipadx     = 350;       
        observacionesField.setColumns(30);
        observacionesField.setRows(10);
        form.add(new JScrollPane(observacionesField),c);
        
        // Agregamos la etiqueta y campo para guardar        
        c.gridx = 3;
        c.gridy = 3;
        form.add(guardarBtn,c);
                
        return form;
        
    }
    /**
    * @method createHelpBar
    * Este metodo simplemente nos ayuda a crear el area de texto
    * en donde mostraremos un texto de ayuda al usuario 
    * para poder interactuar en la seccion actual
    **/
    public JTextArea createHelpBar(){
        helpText.setMargin(new Insets(10,10,10,10)); 
        helpText.setBackground(Color.decode("#eeeeee"));
        
        return helpText;
    }
    /**
    * @method createTable
    * Este metodo crea la tabla en donde mostraremos
    * los datos que el usuario haya ingresado
    **/
    public JScrollPane createTable(){
    
        // Primero definimos el arreglo con los titulos de nuestra tabla
        String[] col = {
            "Articulo",
            "Almacen",
            "Cantidad",
            "Precio",
            "Moneda",
            "Proveedor",
            "Observaciones"
        };
        // Ahora definimos el objeto que contendra los datos de usuario
        Object[][] data = {};
        // Debemos crear una instancia de modelo de tabla
        model = new DefaultTableModel(data,col);
        // Ahora creamos nuestra tabla
        JTable table = new JTable(model);               
        JScrollPane pane = new JScrollPane(table);
                    pane.setPreferredSize(new Dimension(5000,350));
        
        return pane;
    
    
    }
}
