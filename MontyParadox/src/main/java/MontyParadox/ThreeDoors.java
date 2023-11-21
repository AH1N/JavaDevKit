package MontyParadox;

import java.util.*;

public class ThreeDoors {

    public String door1;
    public String door2;
    public String door3;
    public int doorNumberWithCar;
    public ArrayList<String> doors;
    private int playerChose;
    private String playerFirstChose;
    private String playerSecondChose;
    public HashMap<Integer, List<String>> result;
    private ArrayList<String> initialDoors;

    public ThreeDoors() {
        this.playerFirstChose = null;
        this.playerSecondChose = null;
        this.door1 = "goat";
        this.door2 = "goat";
        this.door3 = "goat";
        this.doors = new ArrayList<>();
        this.playerChose = 0;
        this.result = new HashMap<>();
    }

    public void resetDoors() {
        this.doors.clear();
        this.door1 = "goat";
        this.door2 = "goat";
        this.door3 = "goat";
    }

    public void setDoor1() {
        this.door1 = "car";
    }

    public void setDoor2() {
        this.door2 = "car";
    }

    public void setDoor3() {
        this.door3 = "car";
    }

    private int chooseRandomDoor(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public void setDoors() {
        int chosenDoor = chooseRandomDoor(3);
        switch (chosenDoor) {
            case 0:
                setDoor1();
                break;
            case 1:
                setDoor2();
                break;
            case 2:
                setDoor3();
                break;
            default:
                System.out.println("Что-то пошло не так, проверьте свой код");
                break;
        }
    }

    private void addDoorsInList() {
        this.doors.add(this.door1);
        this.doors.add(this.door2);
        this.doors.add(this.door3);
    }

    private void removeDoor(int index) {
        this.doors.remove(index);
    }

    public void showDoors() {
        for (String door : this.doors) {
            System.out.println(door);
        }
    }

    public int playerPickDoorNumber(int max) {
        this.playerChose = chooseRandomDoor(max);
        return this.playerChose;
    }

    public String getPickDoorName(int numberOfDoor) {
        return this.doors.get(numberOfDoor);
    }

    public void hostPickDoor() {
        this.playerFirstChose = getPickDoorName(playerPickDoorNumber(doors.size()));

        System.out.println("Игрок выбрал дверь с " + this.playerFirstChose);

        // Находим дверь с козой, которую можно удалить
        int doorToRemoveIndex = -1;
        for (int i = 0; i < this.doors.size(); i++) {
            String door = this.doors.get(i);
            if ("goat".equals(door) && i != this.playerChose) {
                doorToRemoveIndex = i;
                break;
            }
        }

        if (doorToRemoveIndex != -1) {
            System.out.println("Ведущий удалил дверь с козой.");
            removeDoor(doorToRemoveIndex);
        } else {
            System.out.println("Ведущий не смог удалить дверь с козой.");
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Вот что получилось после действий ведущего: ");
        showDoors();
        System.out.println("-----------------------------------------------");
    }

    public void playerPickDoorSecondTime(String pickFirstTime, int i) {
        System.out.println("Второй раз");
        int tmpPlayerPickDoorSecondTime = playerPickDoorNumber(2);
        System.out.println(tmpPlayerPickDoorSecondTime + " playerPickDoor(2)");

        if (chooseRandomDoor(2) == 0) { //+
            System.out.println("Игрок выбрал удалить дверь");
            this.playerSecondChose = getPickDoorName(tmpPlayerPickDoorSecondTime);
            removeDoor(tmpPlayerPickDoorSecondTime);
        } else {
            this.playerSecondChose = this.playerFirstChose;
            System.out.println("Игрок не выбрал удалить дверь");
            System.out.println(pickFirstTime);
        }

        addResult(i);
        System.out.println("Результат:");
        showResult();
    }

    public void showResult() {
        for (Map.Entry<Integer, List<String>> entry : this.result.entrySet()) {
            int gameNumber = entry.getKey();
            List<String> choices = entry.getValue();

            if (choices.size() >= 2) {
                String firstChoice = choices.get(0);
                String secondChoice = choices.get(1);

                System.out.println("Игра №" + gameNumber + " " + firstChoice + " -> " + secondChoice);
            } else {
                System.out.println("Неверный формат данных для игры №" + gameNumber);
            }
        }
    }

    public void addResult(int i) {
        // Получаем текущий список значений для номера игры i
        List<String> resultList = this.result.get(i);

        // Если список не существует, создаем новый
        if (resultList == null) {
            resultList = new ArrayList<>();
        }

        // Добавляем пару (playerFirstChose, playerSecondChose) в список
        resultList.add(playerFirstChose);
        resultList.add(playerSecondChose);

        // Помещаем обновленный список обратно в HashMap
        this.result.put(i, resultList);
    }


    public void analyzeGames(int numGames) {
        int win = 0;
        int lose = 0;
        int stayWin = 0;
        int switchWin = 0;

        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            List<String> choices = entry.getValue();

            // Проверка, что список содержит хотя бы два элемента
            if (choices.size() >= 2) {
                String initialChoice = choices.get(0);
                String finalChoice = choices.get(1);

                if ("car".equals(initialChoice)) {
                    win++;
                    if ("car".equals(finalChoice)) {
                        stayWin++;
                    } else {
                        switchWin++;
                    }
                } else {
                    lose++;
                }
            } else {
                System.out.println("Неверный формат данных для игры №" + entry.getKey());
            }
        }

        System.out.println("Проведено " + numGames + " игр");
        System.out.println("Побед: " + win);
        System.out.println("Поражений: " + lose);
        System.out.println("Побед, оставив выбор неизменным: " + stayWin);
        System.out.println("Побед, сменив выбор: " + switchWin);
    }

    public void montyParadoxGame(int i) {
        resetDoors();  // Сначала сбрасываем все двери
        setDoors();
        addDoorsInList();
        showDoors();
        this.playerFirstChose = this.doors.get(playerPickDoorNumber(3));
        hostPickDoor();
        System.out.println("Финал");
        playerPickDoorSecondTime(playerFirstChose, i);
        System.out.println("длина хэшМэп: " + result.size());

    }

    public void playSeries(int numGames) {
        for (int i = 1; i <= numGames; i++) {
            System.out.println("Игра №" + i);
            montyParadoxGame(i);
            System.out.println("===========================================");
        }
        analyzeGames(numGames);
    }
}
