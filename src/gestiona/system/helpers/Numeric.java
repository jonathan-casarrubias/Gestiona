/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiona.system.helpers;

/**
 *
 * @author Jonathan Casarrubias
 */
public class Numeric {
    
    public static boolean isInteger(String s, int radix) {
    if(s.isEmpty()) return false;
    for(int i = 0; i < s.length(); i++) {
        if(i == 0 && s.charAt(i) == '-') {
            if(s.length() == 1) return false;
            else continue;
        }
        if(Character.digit(s.charAt(i),radix) < 0) return false;
    }
    return true;
}
}
