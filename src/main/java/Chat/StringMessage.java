/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssem
 */
public class StringMessage extends AbstractMessage implements  Serializable{

    private String strMsg;
    private String transmitter;

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    
    public String getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(String trasmitter) {
        this.transmitter = transmitter;
    }
    
    public void StringMessage(String str) {
        this.strMsg = str;
    }

    @Override
    public void format(PrintStream out) {
        ObjectOutputStream outt = null;
        try {
            //System.out.println("je susi dans StringMessageFormat , le msg=" + getStrMsg() + " le reciver=" + getRecipient());
            outt = new ObjectOutputStream(out);
            outt.writeObject(this);
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(StringMessage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outt.close();
            } catch (IOException ex) {
                Logger.getLogger(StringMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
