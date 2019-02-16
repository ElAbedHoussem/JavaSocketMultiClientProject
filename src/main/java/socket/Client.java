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
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssem
 */
public class Client {
    
    //public static Socket s;
//    public static PrintWriter pred ;
    public static BufferedReader plec;
    public  static  PrintStream ps;
    public  static  DataInputStream dis;
    public static HashMap<String ,Object> newObj = new HashMap<String,Object>();
        
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
        final Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 8956);
        
        //InputStream
        InputStream is = s.getInputStream();
        dis = new DataInputStream(is);
         plec = new BufferedReader(
              new InputStreamReader(s.getInputStream())
       );
       
        Scanner sc = new Scanner(System.in);
        Thread SendThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    OutputStream os = s.getOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    ps = new PrintStream(os);
                    Scanner sc = new Scanner(System.in);
                    String userName = sc.nextLine();
                    ps.print(userName);
                    String command = sc.nextLine();
                    sendData(splitCommand(command));
       
                } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        SendThread.start();
        
   
         Thread reciveThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String serverResult = plec.readLine();
                    System.out.println(serverResult);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
}
        });
        reciveThread.start();
        
  
    }  
      
    public static String[] splitCommand(String command){
            String[] tabArgs = command.trim().split(" ");
           // System.out.println(tabArgs[0]);
        return command.split(" ");
    }
    
  
    public static void sendData(String[] tabCommand) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       String typeCmd= tabCommand[0];// what is th e type of the command : to , quit, create , to ...
       //now we must test what is the first argument
       switch(typeCmd){
           case "quit" : 
               ps.close();
               dis.close();
               break;
           case "create" :
               // we are creating a new object here !!
               String objName = tabCommand[1];
               String objPathPackage = tabCommand[2];
               //instanciate an obj 
               // i must found a method to create an object from a consturctor
               Class c = Class.forName(objPathPackage);
               Object ojbToAdd  = c.newInstance();
               newObj.put(objName, ojbToAdd);
               // getConstructor method on c1 
               // it returns an array of constructors of Boolean class 
               
               
               //see this link: https://www.geeksforgeeks.org/java-lang-class-class-java-set-1/
               //see in thid link : Constructor<?> getConstructor(Class<?>… parameterTypes) : 
                Constructor C[] = c.getConstructors();
               break;
            case "delete" : 
                //we are deleting an existing object !!!!
                String objDelName = tabCommand[1];
                newObj.remove(objDelName);
               break;
            case "to" : 
                 // in this part we will send anyThink
                       //that can be a : message , remotefile, localefile or an object
                       String reciver = tabCommand[1];
                       String functionnality= tabCommand[2];
                       switch(functionnality){
                           case "message":
                               //in this case we are sending a string message
                           //that's why we should call to the StringMessage class
                           //we will set the message an the recipient 
                           String str ="";
                           for (int i = 3; i < tabCommand.length; i++) {
                               str = str+" "+tabCommand[i];
                            }
                            StringMessage sm = new StringMessage();
                            //System.out.println("reciver="+reciver+" message="+str);
                            sm.setStrMsg(str);
                            sm.setRecipient(reciver);
                            sm.format(ps);
                               break;
                           case "remotefile":
                                ///in this case we are sending a remotefile 
                               //that's why we should call to RemoteFileMessage class
                             String file = tabCommand[4]; 
                             RemoteFileMessage rfm = new RemoteFileMessage(file);
                             rfm.setRecipient(reciver);
                             rfm.openFile();
                               break;
                           case "localefile":
                                 //send a localfile
                                   String filee = tabCommand[4]; 
                                   LocalFileMessage lfm = new LocalFileMessage(filee);
                                   String fileName = lfm.getFileName(filee);
                                   lfm.setRecipient(reciver);
                                   lfm.openFile(fileName);
                               break;
                           case "object":
                               //sned an object that we found him in the hashmap
                                        //opm.format method send the object it self
                                        //that's mean she send an ObjectPropertiesMessage object
                                        String objNamee = tabCommand[4];  
                                        Object objToSend = newObj.get(objNamee);
                                        ObjectPropertiesMessage opm = new ObjectPropertiesMessage(objToSend);
                                        opm.format(ps);
                               break;
                            default: System.out.println("false argument after 'to' word");
                           
                       }
                
               break;
               
                default: System.out.println("this option is not evalebal now");
        
       }
    }
    
}
