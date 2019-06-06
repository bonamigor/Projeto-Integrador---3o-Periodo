/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author rafael
 */
public class FabricaTipo {
    
    public static TipoCliente criaTipo(int tipo){
        TipoCliente tp = null;
        if(tipo == 1){
            tp = new Gold();
        }else if(tipo == 2){
            tp = new Silver();
        }else if(tipo == 3){
            tp = new Bronze();
        }
        return tp;
    }
    
}
