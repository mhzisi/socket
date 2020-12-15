package client;
import java.io.*;
import java.net.Socket;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

       
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        String n="13";
        outClient.println(n); 

        inClient.close();
        outClient.close();

        socket.close();
    }
}