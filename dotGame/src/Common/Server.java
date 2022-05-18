package Common;
import java.io.*;
import java.net.*;

public class Server implements Runnable{
    ServerSocket server;
    Socket client;
    ObjectInputStream input;
    Dot target;
    
    public Server(Dot t){
        target = t;
        try {
            server = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public void run(){
        try {
            while(true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                target.target = (Target)input.readObject();
                input.close();
                client.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    
    }
}
