package Elders;

import java.util.concurrent.ConcurrentHashMap;

public class ElderList {

    private ConcurrentHashMap<Integer, Elder> elderList = new ConcurrentHashMap<>();

    //Добавляем человека
    public void addElderInElderlist(int id,Elder elder){
        this.elderList.put(id, elder);
    }

    //Удаляем когда он поел
    public void delElderFromElderlist(int id){
          this.elderList.remove(id);
    }

}
