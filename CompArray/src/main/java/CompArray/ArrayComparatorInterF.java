package CompArray;

public interface ArrayComparatorInterF<T> { //Может не нужен он тут, но решил закрепить
    boolean compareArrays(T[] array1, T[] array2);
    void printArr(T[] array);
}
