/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

/**
 *
 * @author houssem
 */
public class RemoteFileMessage extends AbstractMessage implements Serializable{
     private String urlFile;

    public RemoteFileMessage(String urlFile) {
        this.urlFile = urlFile;
    }
    
    @Override
    public void format(PrintStream out) {
        //A verifier
    }
    
    public void openFile() throws IOException{
        Runtime.getRuntime().exec("xdg-open '"+urlFile+"'");
    }
}
