/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

/**
 *
 * @author houssem
 */
public abstract class AbstractMessage implements  Message{
    
    
    private String recipient;
    @Override
    public String getRecipient() {
        return recipient;
    }
    //I add this method because I will send just an Message object , and he must contains the recipient name 
    public  void setRecipient(String recipient){
        this.recipient = recipient;
    }
    
    
}
