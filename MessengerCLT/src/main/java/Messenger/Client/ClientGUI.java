package Messenger.Client;

import Messenger.Server.Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_POSX = 200;
    private static final int WINDOW_POSY = 200;



    JButton btnSendMsg = new JButton("Send msg");
    JButton btnExitClient = new JButton("SutDown Client");
    JRadioButton onLineConnect;
    JRadioButton offLineDisconnect;
    ButtonGroup buttonGroup;
    static JTextArea clientTxtArea;
    JTextArea textField;
    JScrollPane txt;
    JPanel inLinePanel;
    Client client;


    public ClientGUI(Server server, Client client){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(client.getName());
        setResizable(false);
        onLineConnect = new JRadioButton("CON");
        offLineDisconnect = new JRadioButton("DISC");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(onLineConnect);
        buttonGroup.add(offLineDisconnect);
        inLinePanel = new JPanel(new GridLayout(1,1));
        clientTxtArea = new JTextArea(20, 1);
        textField = new JTextArea(1, 1);


        onLineConnect.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.connectToServer();

            }
        });
        offLineDisconnect.addActionListener(new AbstractAction() { //Назначение кнопок ВЫХОД
            @Override
            public void actionPerformed(ActionEvent e) {
                client.disconnect();
                showMessage("\n U AR OFFLINE");
                offLineDisconnect.setSelected(true);
            }
        });

        btnExitClient.addActionListener(new AbstractAction() { //Назначение кнопок ВКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnSendMsg.addActionListener(new AbstractAction() { //Назначение кнопок ОТКЛ
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.getText();
                showMessage("\n" + textField.getText());
                textField.setText("");

            }
        });

        clientTxtArea.setEditable(false);
        txt = new JScrollPane(clientTxtArea);
        add(txt, BorderLayout.CENTER);
        JPanel panBottom = new JPanel(new GridLayout(2,3));
        panBottom.add(textField);
        panBottom.add(btnSendMsg);
        panBottom.add(btnExitClient);
        panBottom.add(offLineDisconnect);
        offLineDisconnect.setSelected(true);
        panBottom.add(onLineConnect);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void showMessage(String text) {
        clientTxtArea.append(text);
    }

    @Override
    public void disconnectFromServer() {}


}
