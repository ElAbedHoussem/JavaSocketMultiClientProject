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
import static java.lang.System.in;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssem
 */
public class Server {

    public static void main(String[] args) {
        //TCP!!
        try {
            ExecutorService pool = Executors.newFixedThreadPool(2);
            ServerSocket ss = new ServerSocket(8956);

            while (true) {    //wait untill a client coànnects
                Socket s = ss.accept();
                final BufferedReader bufferR = new BufferedReader(
                        new InputStreamReader(s.getInputStream())
                );

                final PrintWriter bufferW = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(s.getOutputStream())),
                        true);

                pool.submit(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            //lire du client
//                            BufferedReader d = new BufferedReader(new InputStreamReader(in));
//                            DataInputStream in = new DataInputStream(s.getInputStream());
//                            //ecrire au client
//                            DataOutputStream out = new DataOutputStream(s.getOutputStream());

                            System.out.println("i am in the server");
                            String clientName = bufferR.readLine();
                            bufferW.println("You are welcome " + clientName);

                            String command = bufferR.readLine();
                            System.out.println("command=" + command);
                            //bufferW.println("command = " + command);
     
     
                            
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        } catch (Exception ex) {

        }
    }
}
