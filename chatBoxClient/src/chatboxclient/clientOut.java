package chatboxclient;

import java.util.Scanner;
import java.io.*; 

public class clientOut extends Thread
{
    Scanner sc; DataOutputStream out; 
    
    public clientOut(Scanner a, DataOutputStream b)
    {
        sc = a;
        out = b; 
    }
    
    public void run()
    {
        do { 
            try {
                String output = sc.nextLine();
                out.writeUTF(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!Thread.interrupted());
    }
}