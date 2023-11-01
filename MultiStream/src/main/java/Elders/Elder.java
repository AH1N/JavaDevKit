package Elders;

import java.util.List;

public class Elder {
    private String name;
    private int eatCount;
    private Fork leftFork;
    private Fork rightFork;

    public Elder(String name, Fork leftFork, Fork rightFork) {
        this.eatCount = 0;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public String getName() {
        return name;
    }

    public void elderPickUpFork(Fork fork){
        if (fork.getForkHost() == null){
            fork.setForkHost(this);
            fork.pickUpFork();
        }
    }

    public void elderPutDownFork(Fork fork) {
        if(fork.getForkHost() == this){
            fork.resetForkHost();
            fork.putDownFork();
        }
    }

    private void elderPickUpBothForks(Fork leftFork, Fork rightFork){
        elderPickUpFork(this.leftFork);
        elderPickUpFork(this.rightFork);
        System.out.println(this.leftFork.getForkHost().name);
        System.out.println(this.rightFork.getForkHost().name);

    }

    private void elderPutDownBothForks(Fork leftFork, Fork rightFork){
        elderPutDownFork(this.leftFork);
        elderPutDownFork(this.rightFork);
    }


    private boolean isPickUpForks(){
        return this.leftFork.getForkHost() == this && this.rightFork.getForkHost() == this;
    }

    public synchronized void elderEatOneTime() {
        elderPickUpBothForks(this.leftFork, this.rightFork);
        if (isPickUpForks()) {
            plusOneEatCount();
            System.out.println(this.name + " поел " + getEatCount() + " раз ");
            elderPutDownBothForks(this.leftFork, this.rightFork);
        }else{
            elderPutDownBothForks(this.leftFork, this.rightFork);
            blaBla();
        }
    }

    public int getEatCount(){
        return this.eatCount;
    }

    private void plusOneEatCount(){
        this.eatCount++;

    }

    private void blaBla(){

        System.out.println(this.name + " РАССУЖДАЕТ"+"\n\tЛевая вилка "+" "+leftFork.getInUse()+
                "\n\tПравая вилка "+" "+rightFork.getInUse() );
//        System.out.println(this.name + " РАССУЖДАЕТ"+"\n\tЛевая вилка "+leftFork.getForkHost().getName()+" "+leftFork.getInUse()+
//                "\n\tПравая вилка "+rightFork.getForkHost().getName()+" "+rightFork.getInUse() );
    }

    public boolean isEatThreeTimes(){
        return this.eatCount != 3;
    }

}
