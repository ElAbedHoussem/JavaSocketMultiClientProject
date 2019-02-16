/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import Chat.StringMessage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author houssem
 */
public class Test {
    
    public static Socket s;
    public static PrintWriter pred ;
    public static BufferedReader plec;
    
    public Test() throws IOException {
        this.s = new Socket(InetAddress.getByName("127.0.0.1"), 8956);
        //InputStream
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //responseLine = is.readLine();
        //OutputStream
        OutputStream os = s.getOutputStream();
        PrintStream out = new PrintStream(os);
        //os.write((byte)c);   
    }
        
        
        
        
    public static void main(String[] args) throws IOException {   
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        pred.println(name);
        System.out.println("server responce : "+plec.readLine());   
        String command = sc.nextLine();
        System.out.println(command);
//      pred.println(command);
//      System.out.println(plec.readLine());
            
            
            
        
    }  
    
    
    //this method is used in the client class
       
//    public static void sendData(String[] tabCommand) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
//       String typeCmd= tabCommand[0];// what is th e type of the command : to , quit, create , to ...
//       //now we must test what is the first argument
//       if(typeCmd.equals("quit")){  
////           pred.close();
////           plec.close();
//           ps.close();
//           dis.close();
//       }else{
//           if(typeCmd.equals("create")){
//               // we are creating a new object here !!
//               String objName = tabCommand[1];
//               String objPathPackage = tabCommand[2];
//               //instanciate an obj 
//               // i must found a method to create an object from a consturctor
//               Class c = Class.forName(objPathPackage);
//               Object ojbToAdd  = c.newInstance();
//               newObj.put(objName, ojbToAdd);
//               // getConstructor method on c1 
//               // it returns an array of constructors of Boolean class 
//               
//               
//               //see this link: https://www.geeksforgeeks.org/java-lang-class-class-java-set-1/
//               //see in thid link : Constructor<?> getConstructor(Class<?>… parameterTypes) : 
//                Constructor C[] = c.getConstructors(); 
//                       
//           }else{
//               if(typeCmd.equals("delete")){
//                   //we are deleting an existing object !!!!
//                   String objName = tabCommand[1];
//                   newObj.remove(objName);
//               }else{
//                   if(typeCmd.equals("to")){
//                       // in this part we will send anyThink
//                       //that can be a : message , remotefile, localefile or an object
//                       String reciver = tabCommand[1];
//                       String functionnality= tabCommand[2];
//                       if(functionnality.equals("message")){
//                           //in this case we are sending a string message
//                           //that's why we should call to the StringMessage class
//                           //we will set the message an the recipient 
//                           String str ="";
//                           for (int i = 3; i < tabCommand.length; i++) {
//                               str = str+" "+tabCommand[i];
//                            }
//                            StringMessage sm = new StringMessage();
//                            //System.out.println("reciver="+reciver+" message="+str);
//                            sm.setStrMsg(str);
//                            sm.setRecipient(reciver);
//                            sm.format(ps);
//                       }else{                        
//                           if(functionnality.equals("remotefile")){
//                               ///in this case we are sending a remotefile 
//                               //that's why we should call to RemoteFileMessage class
//                             String file = tabCommand[4]; 
//                             RemoteFileMessage rfm = new RemoteFileMessage(file);
//                             rfm.setRecipient(reciver);
//                             rfm.openFile();
//                           }else{
//                               if(functionnality.equals("localefile")){
//                                   //send a localfile
//                                   String file = tabCommand[4]; 
//                                   LocalFileMessage lfm = new LocalFileMessage(file);
//                                   String fileName = lfm.getFileName(file);
//                                   lfm.setRecipient(reciver);
//                                   lfm.openFile(fileName);
//                                }else{
//                                    if(functionnality.equals("object")){
//                                        //sned an object that we found him in the hashmap
//                                        //opm.format method send the object it self
//                                        //that's mean she send an ObjectPropertiesMessage object
//                                        String objName = tabCommand[4];  
//                                        Object objToSend = newObj.get(objName);
//                                        ObjectPropertiesMessage opm = new ObjectPropertiesMessage(objToSend);
//                                        opm.format(ps);
//                                    }
//                                }
//                           }
//                       }
//                   }
//               }
//               
//            }
//       }
//    
//    }  
//  
     

}
