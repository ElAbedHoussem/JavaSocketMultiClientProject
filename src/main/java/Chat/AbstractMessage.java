/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.PrintStream;

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
    
}
