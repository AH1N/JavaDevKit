package chat.client;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket clientSocket;
    private final String name;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public Client(Socket clientSocket, String userName){
        this.clientSocket = clientSocket;
        name = userName;

        try{
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch (IOException e){
            closeEveryThing(clientSocket, bufferedReader, bufferedWriter);
        }
    }

    public void listenMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message;
                while(clientSocket.isConnected()){
                    try{
                        message = bufferedReader.readLine();
                        System.out.println(message);
                    }
                    catch (IOException e){
                       closeEveryThing(clientSocket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();

    }


    public void sendMessage(){
        try {
            bufferedWriter.write(name);// отправили своё имя(добавили)
            bufferedWriter.newLine();// новая строка
            bufferedWriter.flush();// отправляем на сервер все данные

            Scanner scanner = new Scanner(System.in);

            while(clientSocket.isConnected()){
                String message = scanner.nextLine();
                bufferedWriter.write(name+ ":  " + message );
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch (IOException e){
            closeEveryThing(clientSocket, bufferedReader, bufferedWriter);
        }


    }

    private void closeEveryThing(Socket clientSocket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (clientSocket != null){
                clientSocket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
