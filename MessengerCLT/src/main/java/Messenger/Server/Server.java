package Messenger.Server;

import Messenger.Client.Client;
import Messenger.Client.ClientGUI;
import Messenger.ClientWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static Messenger.ClientWindow.clientTextAreaAppend;

public class Server{
    static boolean serverStatus = false;
    ServerFront serverFront;
    Client client;
    ArrayList <Client> clientList;

    public Server() {
      this.serverFront = new ServerFront(this, client);
      this.clientList = new ArrayList<Client>();
    }

    public boolean getServerStatus() {
        return serverStatus;
    }

    public static void setServerStatus(boolean serverStatus) {
        Server.serverStatus = serverStatus;
    }

    public boolean serverOnline(){
        setServerStatus(true);

        printTextS("\nSERVER ONLINE");
        if (this.clientList.size()>0){
            for (Client client : clientList)
            {
                client.msgToClient("\nSERVER ONLINE");
            }
        }else{
            printTextS("\n0 CLIENTS");
        }
        return getServerStatus();
    }

    public boolean serverOffline(){
        setServerStatus(false);
        printTextS("\nSERVER OFFLINE");
        if (this.clientList.size()>0){
            for (Client client : clientList)
            {
                client.msgToClient("\nSERVER OFFLINE");
            }
        }else{
            printTextS("\n0 CLIENTS");
        }

        return getServerStatus();
    }

    public String isOnline(){
        String text;
        if (serverStatus){
            text = "SERVER ONLINE";
        }else{ text = "SERVER OFFLINE";}
        return text;
    }

    public void clientListAdd(Client client){
        this.clientList.add(client);
    }

    public void clientListRemove(Client client){
        this.clientList.remove(client);
    }

    public void changeServerStatus(){
        if (getServerStatus()){
            setServerStatus(false);
        }else{setServerStatus(true);}
    }

    public void msgToServer(String text){
        printTextS(text);
    }

    private void printTextS(String text){
        serverFront.showMessage(text);
    }

}