package Elders;


import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI ELDERS!!!");

        ForkList forkList = new ForkList();
        Elder[] eldersList = new Elder[5];

        forkList.addFork(1,new Fork("1"));
        forkList.addFork(2,new Fork("2"));
        forkList.addFork(3,new Fork("3"));
        forkList.addFork(4,new Fork("4"));
        forkList.addFork(5,new Fork("5"));

        eldersList[0] = new Elder("Ньютон - 1",forkList.getFork(5),forkList.getFork(1));
        eldersList[1] = new Elder("Геродот - 2",forkList.getFork(1),forkList.getFork(2));
        eldersList[2] = new Elder("Архимед - 3",forkList.getFork(2),forkList.getFork(3));
        eldersList[3] = new Elder("Декарт - 4",forkList.getFork(3),forkList.getFork(4));
        eldersList[4] = new Elder("Ломоносов - 5",forkList.getFork(4),forkList.getFork(5));

        ElderThread elderTread1 = new ElderThread(eldersList[0]);
        ElderThread elderTread2 = new ElderThread(eldersList[1]);
        ElderThread elderTread3 = new ElderThread(eldersList[2]);
        ElderThread elderTread4 = new ElderThread(eldersList[3]);
        ElderThread elderTread5 = new ElderThread(eldersList[4]);

        elderTread1.start();
        elderTread2.start();
        elderTread3.start();
        elderTread4.start();
        elderTread5.start();

    }
}
