package chatboxclient;

import java.util.Scanner;
import java.io.*; 

public class clientIn extends Thread
{
    Scanner sc; DataInputStream in;
    
    public clientIn(Scanner a, DataInputStream b)
    {
        sc = a;
        in = b; 
    }
    
    public void run()
    {
        do {
            try {
                System.out.println(in.readUTF());
            } catch (EOFException eo) {
                System.out.println("Server closed, program exiting");
                interrupt(); 
                break; 
            } catch (IOException e) {
                e.printStackTrace();
            } 
        } while(!Thread.interrupted()); 
    }
}