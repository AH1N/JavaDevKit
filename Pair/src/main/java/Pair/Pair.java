package Pair;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "1-->" + first + "; 2-->" + second;
    }

    public void prnt(){
        System.out.println(this.toString());

    }
}
