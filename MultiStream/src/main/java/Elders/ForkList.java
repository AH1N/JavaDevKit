package Elders;

import java.util.concurrent.ConcurrentHashMap;

public class ForkList {

    private ConcurrentHashMap<Integer, Fork> forkList = new ConcurrentHashMap<>();

    public void addFork(int id, Fork fork) {
        forkList.put(id, fork);
    }

    public Fork getFork(int id) {
        return forkList.get(id);
    }

}
