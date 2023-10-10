package Messenger.Client;

import Messenger.Server.Server;

public class Client {
    private String name;
    private ClientGUI clientGui;
    private Server server;
    private boolean status;

    public Client(Server server,String name) {
        this.name = name;
        this.clientGui = new ClientGUI(server, this);
        this.server = server;
    }

    public boolean connectToServer(){
        if(server.getServerStatus()){
            this.status = true;
            server.msgToServer("\n" + this.name +" ONLINE");
            printText("\nU AR ONLINE & CONNECTED TO SERVER");
            server.clientListAdd(this);
            return true;
        }else {
            printText("\nCONNECTION FILED, SERVER OFFLINE");
            return false;
        }
    }

    public void disconnect(){
        if (this.status){
            server.msgToServer("\n" + this.name +" OFFLINE");
            server.clientListRemove(this);
            this.status = false;
        }
    }



    public String getName() {
        return name;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void msgToClient(String text){
        printText(text);
    }

    private void printText(String text){
        clientGui.showMessage(text);
    }

}