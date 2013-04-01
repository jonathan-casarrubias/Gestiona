/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.system.interfaces;

import java.sql.ResultSet;

/**
 *
 * @author Jonathan Casarrubias
 */
public interface LibraryInterface {
    
    public void init();
    public void select(String select);
    public void from(String from);
    public void where(String where);
    public void order(String order);
    public ResultSet result();
    
}
