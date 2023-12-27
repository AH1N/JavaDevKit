package chat.client;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientProgram {
    public static void main(String[] args) {

//        System.out.println("Hello ClientProgram!");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ennth U name: ");
            String clientName = scanner.nextLine();
            Socket clientSocket = new Socket("localhost", 1500);

            Client client = new Client(clientSocket, clientName);

            InetAddress inetClientAddress = clientSocket.getInetAddress();
            System.out.println("inetClientAddress: " + inetClientAddress);

            String remoteIp = inetClientAddress.getHostAddress();
            System.out.println("remote Ip: " + remoteIp);
            System.out.println("LocalPort: " + clientSocket.getLocalPort());


            client.listenMessage();
            client.sendMessage();
        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}