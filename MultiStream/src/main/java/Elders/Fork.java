package Elders;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private String name;
    private boolean inUse = false;
    public Elder forkHost = null;
//    private Lock locker = new ReentrantLock(); //подглядел в https://metanit.com/java/tutorial/8.9.php
//    но не получается реализовать

    public Fork(String name) {
        this.name = name;
    }

    public synchronized boolean pickUpFork() {
        if (inUse == false && !isHost()) {
            inUse = true;
            System.out.println(this.name + " ВЗЯТА и ИСПОЛЬЗУЕТСЯ " + this.forkHost.getName());
            return true;
        }else{
            return false;
        }
    }

    public synchronized void putDownFork() {
        inUse = false;
        resetForkHost();
        System.out.println(this.name + " ПОЛОЖЕНА и НЕ ИСПОЛЬЗУЕТСЯ "); //this.forkHost.getName()
    }

    public String getInUse() {
        return String.valueOf(this.inUse);
    }

    public String getName() {
        return name;
    }

    public Elder getForkHost() {
        return forkHost;
    }

    public void setForkHost(Elder elder){
        this.forkHost = elder;
    }

    public void resetForkHost(){
        this.forkHost = null;
    }

    public boolean isHost(){
        if(this.forkHost == null){
            return true;
        }else{
            return false;
        }
    }
    //    // берём вилку
//    public boolean pickUpFork() {
//        //пытается получить блокировку, если блокировка получена, то возвращает true.
//        if (locker.tryLock()) {
//            System.out.println(locker.tryLock());
//            if (!inUse) {           //Получаем блокировку, меняем флаг, если вилка не используется
//                inUse = true;
//                return true;
//            }
//            locker.unlock();        //Не получается получить блокировку - вилка занята
//        }
//        return false;               //Вилка не заблокирована
//    }
//
//    public void putDownFork() {     //Кладём вилку назад
//        inUse = false;
//        locker.unlock();
//    }

}
