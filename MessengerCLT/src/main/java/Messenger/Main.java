package Messenger;

import Messenger.Client.Client;
import Messenger.Server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        new Client(server, "Mr. Anderson");

    }
}
