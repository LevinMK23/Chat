package base_OOP;

import stepik.tree.Treap;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Var {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8080)){
            Socket client = server.accept();
            System.out.print("Connection accepted.");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream  created");
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
            while(!client.isClosed()){
                System.out.println("Server reading from channel");
                String entry = in.readUTF();
                System.out.println("READ from client message - " + entry);
                System.out.println("Server try writing to channel");
                if(entry.equalsIgnoreCase("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to client.");
                out.flush();
            }
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");
            in.close();
            out.close();
            client.close();
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


