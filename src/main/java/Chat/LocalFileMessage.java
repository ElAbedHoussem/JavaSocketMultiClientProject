
package Chat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssem
 */
public class LocalFileMessage extends  AbstractMessage implements Serializable{

    private String fileName;
    private byte[] fileContent;
    private String path;

    public LocalFileMessage(String path) throws IOException {
        
        this.path = path;
        this.fileName = this.getFileName(path);
        this.fileContent = this.fromFileToBytes(path);
    }
    
    
    @Override
    public void format(PrintStream out) {//to define later but I don't now what we must put here !!!!??
     }
    
    //we use this method on the reciver to convert the bytes to an file
    public void covertBytesToFile() {
//         File file = new File(this.path);
         File file = new File(System.getProperty("user.home"),"/"+this.fileName);
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
    
    //we use this method on the reciver to display the file 
    public void openFile(String fileName) throws IOException{
        Runtime.getRuntime().exec("xdg-open '"+System.getProperty("user.home")+"/"+fileName+"'");
    }
    
    //we use this method on the sender client to get bytes from a file 
    public byte[] fromFileToBytes(String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytesArray = new byte[(int) file.length()];
        fis.read(bytesArray); //read file into bytes[]
        return bytesArray;
    }

    //we use this method on the sender client to get the file name from the path
    public String getFileName(String path){
        String[] pathTab = path.split("/");
        return pathTab[pathTab.length];
    } 
    
    
    
}
