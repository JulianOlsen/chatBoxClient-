package chatboxclient;

import java.io.IOException;
import java.util.Scanner;

public class clientMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        
        String address; 
        int port; 
        
        System.out.print("Input an Ip Address: ");
        address = sc.nextLine(); 
        
        System.out.print("Input a port: ");
        try {
            port = sc.nextInt(); 
        } catch (NumberFormatException n) {
            System.out.println("This is not a valid port, program exiting");
            return;  
        } 
        
        try {
            clientRun cr = new clientRun(address, port, sc); 
            cr.runClient(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}