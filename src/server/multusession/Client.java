package server.multusession;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket clientSocket;
    private Scanner in;
    private BufferedWriter out;
    private static int cnt = 0;
    private int number;
    private Server server;

    public int getName() {
        return number;
    }

    public Client() {
        cnt++;
        number = cnt;
        try {
            clientSocket = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client was created, " + cnt);
    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
    }

    public void putMessage(String message){
        try {
            out.write(message + '\n');
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDialog(){
        System.out.println(in.nextLine());
    }
}
