package com.example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        try {
            System.out.print("creo la socket\n");
            Socket s = new Socket("10.22.9.14", 3000);

            BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            //String string = inTastiera.readLine();
            System.out.print("preso da tastiera la stringa\n");

            out.writeBytes(inTastiera.readLine() + "\n");
            // System.out.print("inviato al server\n");

            System.out.print(inServer.readLine() + "\n");

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
