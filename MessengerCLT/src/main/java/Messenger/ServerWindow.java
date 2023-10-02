package Messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Messenger.ClientWindow.clientTextAreaAppend;

public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_POSX = 900;
    private static final int WINDOW_POSY = 200;
    static boolean serverStatus = false;
    JButton btnStartServer = new JButton("Start Server");
    JButton btnShutDownServer = new JButton("SutDown Server");
    JButton btnExitServer = new JButton("SutDown Server");
    static JTextArea serverTxtArea;
    JScrollPane txt;

    ServerWindow(){
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
                if(serverStatus == true){
                    serverTxtArea.append("\nServer Down");
                    if(ClientWindow.clientStatus == true){
                        clientTextAreaAppend("\nServer Down");
                    }else{serverTxtArea.append("\nClient Down");}
                    System.out.println("Server Down");
                    serverStatus = false;
                }else{
                    serverTxtArea.append("\nServer Already Down");
                    System.out.println("Server Already Down");
                }
            }
        });
//=============================================================
        btnStartServer.addActionListener(new AbstractAction() { //Назначение кнопок ВКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverStatus == false){
                    serverTxtArea.append("\nServer Start");
                    if(ClientWindow.clientStatus == true){
                        clientTextAreaAppend("\nServer UP");
                    }else{serverTxtArea.append("\nClient Down");}
                    System.out.println("Server Start");
                    serverStatus = true;
//                    settings.setVisible(true);
                }else{
                    serverTxtArea.append("\nServer Already Started");
                    System.out.println("Server Already Started");
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

    public static void serverTextAreaAppend(String string){
        serverTxtArea.append(string);
    }

}

