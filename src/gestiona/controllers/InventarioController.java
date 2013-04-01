/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.controllers;

import gestiona.system.core.*;
import gestiona.system.interfaces.ControllerInterface;
import gestiona.system.interfaces.LibraryInterface;
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

    @Override
    public void init(){
        
        HashMap data = null;
        
        // Lo primero que debemos hacer, es llamar nuestra libreria de base de datos
        LibraryInterface 
                
               db = gestiona.system.core.Load.library("DB");
        
               db.select("*");
               db.from("articulos");
               
        data.put("articulos", db.result());
        
        HashMap 
                
        layoutRequest = new HashMap();
        layoutRequest.put("Header",BorderLayout.PAGE_START);
        layoutRequest.put("Footer",BorderLayout.PAGE_END);
        
        gestiona.system.core.Load.layout(layoutRequest);
        gestiona.system.core.Load.view("inventario.InventarioUI",data);       
    }    
}
