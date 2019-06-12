package chatboxclient; 

import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class clientRun
{
    private String address; private int port; private Scanner sc; 
    Thread clientIn, clientOut; 
    
    public clientRun(String a, int b, Scanner c) throws IOException
    {
        address = a; 
        port = b;
        sc = c; 
    }
    
    public void runClient()
    {
        try {
            System.out.println("\nSearching for connection to " +address +":" +port);
            Socket client = new Socket(address, port);
            System.out.println("Connection found! Connected to " +client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            
            clientIn = new clientIn(sc, in); 
            clientOut = new clientOut(sc, out); 
 
            clientIn.start(); 
            clientOut.start();
            
            do {
                if (clientIn.isInterrupted()) {
                    clientOut.interrupt(); 
                    System.out.println("Type anything to exit");
                }
            } while(!clientOut.isInterrupted());
            
        } catch (UnknownHostException u) {
            System.out.println("Could not find host, program exiting"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}