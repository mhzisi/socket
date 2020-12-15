package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    static final int port = 1200; 
    public static boolean est_premier(int n) 
    { 
    	boolean pre=true; 
    	for(int i=2;i<=n/2;i++) 
    	{
    		if(n%i==0)
    			pre=false;  
    		
    	} 
    	return pre;
    }
    
    

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        String str= inServer.readLine();  
        int n=Integer.parseInt(str);  
        
        for(int i=2;i<=n;i++)
        {
        	if(est_premier(i))
        	{
        	System.out.println(i);	
        	}
        }
        
        
        
       

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}