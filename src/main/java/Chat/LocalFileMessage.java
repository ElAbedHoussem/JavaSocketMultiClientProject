
package Chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssem
 */
public class LocalFileMessage extends  AbstractMessage{

    private String fileName;
    private byte[] fileContent;
    private String path;

    public LocalFileMessage(String fileName, byte[] fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.path = System.getProperty("user.home")+"/"+fileName+".txt";
    }
    
    
    @Override
    public void format(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void covertBytesToFile() {
         File file = new File(this.path);
         FileOutputStream fileOutStream;
        try {
            fileOutStream = new FileOutputStream(file);
            fileOutStream.write(fileContent);
            fileOutStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found search again"+ex.toString());
        }
        catch (IOException ex) {
            Logger.getLogger(LocalFileMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void openFile(String url) throws IOException{
        Runtime.getRuntime().exec("xdg-open '"+System.getProperty("user.home")+"/"+fileName+".txt'");
    }
    
    
    
}
