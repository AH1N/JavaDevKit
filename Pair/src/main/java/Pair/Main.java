package Pair;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello PAIR");

        Pair <Integer, String> pair1 = new Pair<>(1, "Колбаса");
        Pair <Integer, Integer> pair2 = new Pair<>(1, 1);
        Pair <String, String> pair3 = new Pair<>("Колбаса", "Колбаса");
        Pair <Boolean, String> pair4 = new Pair<>(true, "Колбаса");

        pair1.prnt();
        pair2.prnt();
        pair3.prnt();
        pair4.prnt();


//        System.out.println(pair1.toString());
//        System.out.println(pair2.toString());
//        System.out.println(pair3.toString());
//        System.out.println(pair4.toString());
    }
}