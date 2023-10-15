package CompArray;

public class ArrayComparator<T> implements ArrayComparatorInterF<T> {
    @Override
    public boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == null) {
                if (array2[i] != null) {
                    return false;
                }
            } else if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void printArr(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void comparatorResult(T[] array1, T[] array2){
        printArr(array1);
        printArr(array2);
        System.out.println(compareArrays(array1, array2));

    }
}

