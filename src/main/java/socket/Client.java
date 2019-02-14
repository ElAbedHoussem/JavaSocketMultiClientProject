/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import Chat.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author houssem
 */
public class Client {
    
    public static Socket s;
    public static PrintWriter pred ;
    public static BufferedReader plec;
    public  static  PrintStream ps;
    public  static  DataInputStream dis;
    
    public Client() throws IOException {
        this.s = new Socket(InetAddress.getByName("127.0.0.1"), 8956);
        //InputStream
        InputStream is = s.getInputStream();
        dis = new DataInputStream(is);
        //responseLine = is.readLine();
        //OutputStream
        OutputStream os = s.getOutputStream();
        ps = new PrintStream(os);
        //os.write((byte)c);   
        
        
        
//         plec = new BufferedReader(
//                new InputStreamReader(s.getInputStream())
//        );
//         
//         
//         pred = new PrintWriter(
//                new BufferedWriter(
//                        new OutputStreamWriter(s.getOutputStream())),
//                true);
    }
        
    public static void main(String[] args) throws IOException {
   
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        pred.println(name);
        System.out.println("server responce : "+plec.readLine());   
        String command = sc.nextLine();
        System.out.println(command);
        sendData(splitCommand(command));
//      pred.println(command);
//      System.out.println(plec.readLine());
            
            
            
        
    }  
      
    public static void sendData(String[] tabCommand) throws IOException{
       String typeCmd= tabCommand[1];// what is th e type of the command : to , quit, create , to ...
       //now we must test what is the first argument
       if(typeCmd.equals("quit")){  
           pred.close();
           plec.close();
       }else{
           if(typeCmd.equals("create")){
               // we are creating a new object here !!
           }else{
               if(typeCmd.equals("delete")){
                   //we are deleting an existing object !!!!
               }else{
                   if(typeCmd.equals("to")){
                       // in this part we will send anyThink
                       //that can be a : message , remotefile, localefile or an object
                       String reciver = tabCommand[2];
                       String functionnality= tabCommand[3];
                       if(functionnality.equals("message")){
                           //in this case we are sending a string message
                           //that's why we should call to the StringMessage class
                           //we will set the message an the recipient 
                           String str ="";
                           for (int i = 4; i < tabCommand.length; i++) {
                               str = str+" "+tabCommand[i];
                            }
                            StringMessage sm = new StringMessage();
                            sm.setStrMsg(str);
                            sm.setRecipient(reciver);
                            sm.format(ps);
                       }else{                        
                           if(functionnality.equals("remotefile")){
                               ///in this case we are sending a remotefile 
                               //that's why we should call to RemoteFileMessage class
                             String file = tabCommand[4]; 
                             RemoteFileMessage rfm = new RemoteFileMessage(file);
                             rfm.openFile();
                           }else{
                               if(functionnality.equals("localefile")){
                                   String file = tabCommand[4]; 
                                   LocalFileMessage lfm = new LocalFileMessage(file);
                                   String fileName = lfm.getFileName(file);
                                   lfm.openFile(fileName);
                                }else{
                                    if(functionnality.equals("object")){
                                        String objName = tabCommand[4];  
                                     }
                                }
                           }
                       }
                   }
               }
               
            }
       }
    
    }  
    public static String[] splitCommand(String command){
        return command.split(" ");
    }


}
