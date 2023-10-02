package Messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class ClientWindow extends JFrame {

    private String clientName = "mr.Anderson";
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_POSX = 200;
    private static final int WINDOW_POSY = 200;
    static boolean clientStatus = false;
    JButton btnSendMsg = new JButton("Send msg");
    JButton btnExitClient = new JButton("SutDown Client");
    JRadioButton onLine;
    JRadioButton offLine;
    ButtonGroup buttonGroup;
    static JTextArea clientTxtArea;
    JTextArea textField;
    JScrollPane txt;
    JPanel inLinePanel;


    ClientWindow(){
        Date date = new Date(1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(clientName);
        setResizable(false);
        onLine = new JRadioButton("ONLINE");
        offLine = new JRadioButton("OFLINE");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(onLine);
        buttonGroup.add(offLine);
        inLinePanel = new JPanel(new GridLayout(1,1));
        clientTxtArea = new JTextArea(20, 1);
        textField = new JTextArea(1, 1);
//=============================================================
        btnSendMsg.addActionListener(new AbstractAction() { //Назначение кнопок ОТКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getText();
                clientTxtArea.append("\n" + date +"  " + textField.getText());
                textField.setText("");
                if(ServerWindow.serverStatus == true && clientStatus == true){
                    ServerWindow.serverTextAreaAppend("\n" + clientName +"  wrote:  " + textField.getText());
                }else{clientTxtArea.append("\n SERVER OFFLINE OR CLIENT OFFLINE");}

            }
        });
//=============================================================
        btnExitClient.addActionListener(new AbstractAction() { //Назначение кнопок ВКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//=============================================================

        onLine.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientTxtArea.append("\n Client ONLINE");
                clientStatus = true;
                if(ServerWindow.serverStatus == true){
                    ServerWindow.serverTextAreaAppend("\n Client --> "+ clientName +"  ONLINE");
                }else{clientTxtArea.append("\n Server OFFLINE");}

            }
        });
        offLine.addActionListener(new AbstractAction() { //Назначение кнопок ВЫХОД
            @Override
            public void actionPerformed(ActionEvent e) {
                clientTxtArea.append("\n Client OFFLINE");
                clientStatus = false;
                if(ServerWindow.serverStatus == true){
                    ServerWindow.serverTextAreaAppend("\n Client --> "+ clientName +"  OFFLINE");
                }else{clientTxtArea.append("\n Server OFFLINE");}
            }
        });
//=============================================================
        clientTxtArea.setEditable(false);
        txt = new JScrollPane(clientTxtArea);
        add(txt, BorderLayout.CENTER);
        JPanel panBottom = new JPanel(new GridLayout(2,3));
        panBottom.add(textField);
        panBottom.add(btnSendMsg);
        panBottom.add(btnExitClient);
        panBottom.add(offLine);
        offLine.setSelected(true);
        panBottom.add(onLine);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void clientTextAreaAppend(String string){
        clientTxtArea.append(string);
    }
}
