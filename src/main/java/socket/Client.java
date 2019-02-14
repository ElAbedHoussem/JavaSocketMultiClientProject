/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    
        public Client() throws IOException {
        this.s = new Socket(InetAddress.getByName("127.0.0.1"), 8956);
         plec = new BufferedReader(
                new InputStreamReader(s.getInputStream())
        );

         pred = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(s.getOutputStream())),
                true);
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
           }else{
               if(typeCmd.equals("delete")){
               }else{
                   if(typeCmd.equals("to")){
                       String reciver = tabCommand[2];
                       String functionnality= tabCommand[3];
                       if(functionnality.equals("message")){
                           String str ="";
                           for (int i = 4; i < tabCommand.length; i++) {
                               str = str+" "+tabCommand[i];
                           }
                       }else{                        
                           if(functionnality.equals("remotefile")){
                             String file = tabCommand[4];  
                           }else{
                               if(functionnality.equals("localefile")){
                                   String file = tabCommand[4];  
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
