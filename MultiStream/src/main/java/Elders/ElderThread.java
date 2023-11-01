package Elders;



public class ElderThread extends Thread {
    private Elder elder; // Это тот который будет есть в экземпляре потока
    private String name;

    public ElderThread(Elder elder) {
        this.elder = elder;
        this.name = elder.getName();
    }


    @Override
    public void run() {
        while(this.elder.getEatCount()!=3){
            this.elder.elderEatOneTime();
            try {
                ElderThread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

