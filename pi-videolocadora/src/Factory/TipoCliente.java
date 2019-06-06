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
public interface TipoCliente {
    String getTipoCliente();
}

class Gold implements TipoCliente{

    @Override
    public String getTipoCliente() {
        return "GOLD";
    }
    
}

class Silver implements TipoCliente{

    @Override
    public String getTipoCliente() {
        return "SILVER";
    }
    
}

class Bronze implements TipoCliente{

    @Override
    public String getTipoCliente() {
        return "BRONZE";
    }
    
}
