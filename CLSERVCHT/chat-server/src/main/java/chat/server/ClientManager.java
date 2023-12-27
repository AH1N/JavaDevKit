package chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String name;

    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try{
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + "ПОДКЛЮЧИЛСЯ");
            sendMessageToAll("Server: " + name +" Подключился к чату");
        }
        catch (IOException e){
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientManager();
        try{
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private void removeClientManager(){
        clients.remove(this);
        System.out.println(name + "ПОКИНУЛ ЧАД");
        sendMessageToAll("Server: " + name +" ПОКИНУЛ ЧАД");
    }

    private void sendMessageToAllClients(String message){
        for (ClientManager client: clients) {
            try{
                if(!client.name.equals(name)){
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            }
            catch (IOException e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void sendMessageToAll(String message) {
        int startIdx = message.indexOf("#");
        int endIdx = message.indexOf("#", startIdx + 1);
        if (startIdx != -1 && endIdx != -1) {
            String clientName = message.substring(startIdx + 1, endIdx);
            String newMessage = message.substring(endIdx + 1);
            sendPersonslMessage(clientName, newMessage);
        } else {
            sendMessageToAllClients(message);
        }
    }

    private void sendPersonslMessage(String clientName, String message) {
        for (ClientManager client : clients) {
            if (client.name.equals(clientName)) {
                try {
                    client.bufferedWriter.write(name + " (Persons): " + message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEveryThing(socket, bufferedReader, bufferedWriter);
                    break;
                }
                return;
            }
        }
    }


    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()){

            try {
                messageFromClient = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sendMessageToAll(messageFromClient);

        }
    }
}
