package Messenger.Server;

import Messenger.Client.Client;
import Messenger.Client.ClientGUI;
import Messenger.Client.ClientView;
import Messenger.ClientWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Messenger.ClientWindow.clientTextAreaAppend;

public class ServerFront extends JFrame implements ServerInterf{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_POSX = 900;
    private static final int WINDOW_POSY = 200;
    JButton btnStartServer = new JButton("Start Server");
    JButton btnShutDownServer = new JButton("SutDown Server");
    JButton btnExitServer = new JButton("SutDown Server");
    static JTextArea serverTxtArea;
    JScrollPane txt;
    Server server;


    ServerFront(Server server, Client client){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        serverTxtArea = new JTextArea(20, 1);
//=============================================================
        btnShutDownServer.addActionListener(new AbstractAction() { //Назначение кнопок ОТКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!server.getServerStatus()){
                    showMessage("\nServer Already Down");
                }else{
                    server.serverOffline();
                }
            }
        });
//=============================================================
        btnStartServer.addActionListener(new AbstractAction() { //Назначение кнопок ВКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                if(server.getServerStatus()) {
                    showMessage("\nServer Already Started");
                }else{
                    server.serverOnline();
                }
            }
        });
//=============================================================
        btnExitServer.addActionListener(new AbstractAction() { //Назначение кнопок ВЫХОД
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit Server");
                System.exit(0);
            }
        });
        txt = new JScrollPane(serverTxtArea);
        add(txt, BorderLayout.CENTER);
        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStartServer);
        panBottom.add(btnShutDownServer);
        panBottom.add(btnExitServer);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void showMessage(String text) {
        serverTxtArea.append(text);
    }
}


