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
     

}
