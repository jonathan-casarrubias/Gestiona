/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.controllers;

import gestiona.system.core.*;
import gestiona.system.interfaces.ControllerInterface;
import gestiona.system.interfaces.LibraryInterface;
import gestiona.system.libraries.DB;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jonathan Casarrubias
 */
public class InventarioController implements ControllerInterface {

    public static DB DB;
    
    @Override
    public void init(){
        
        HashMap data = new HashMap();
        
        // Lo primero que debemos hacer, es llamar nuestra libreria de base de datos
       
                
        DB = new gestiona.system.libraries.DB();
        DB.init();
        DB.select("*");
        DB.from("articulos");
            
        data.put("articulos", DB.result());
        
        HashMap 
                
        layoutRequest = new HashMap();
        layoutRequest.put("Header",BorderLayout.PAGE_START);
        layoutRequest.put("Footer",BorderLayout.PAGE_END);
        
        gestiona.system.core.Load.layout(layoutRequest);
        gestiona.system.core.Load.view("inventario.InventarioUI",data);       
    }    
}
