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
public class StringMessage extends AbstractMessage{
    
    private String strMsg;

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    public void StringMessage(String str){
        this.strMsg = str;
    }
    
    @Override
    public void format(PrintStream out) {
       out.println(strMsg);
    }
   
    
    
    
    
}
