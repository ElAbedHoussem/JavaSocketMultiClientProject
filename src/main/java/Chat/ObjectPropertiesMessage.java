    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.PrintStream;
import java.io.Serializable;

/**
 *
 * @author houssem
 */
public class ObjectPropertiesMessage extends AbstractMessage implements Serializable{
    
    private Object obj;

    public ObjectPropertiesMessage(Object objToSend) {
        this.obj =obj;    
    }
    
    @Override
    public void format(PrintStream out) {
        //to complete , we must send an object
        out.println(this);
    
    }
    
}
