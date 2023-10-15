package CompArray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello ArrayComparator");
        ArrayComparator arrayComparator = new ArrayComparator(); // ТУТ Я ЗАПОМНИЛ КАК ИЗБАВИТСЯ ОТ Static)
        Integer[] intArr1 = {1, 2, 3};
        Integer[] intArr2 = {1, 2, 3};
        Integer[] intArr3 = {4, 5, 6};

        String[] strArr1 = {"раз", "два", "три"};
        String[] strArr2 = {"раз", "два", "три"};
        String[] strArr3 = {"1", "два", "3"};

        arrayComparator.comparatorResult(intArr1, intArr2);
        arrayComparator.comparatorResult(intArr1, intArr3);
        arrayComparator.comparatorResult(strArr1, strArr2);
        arrayComparator.comparatorResult(strArr1, strArr3);

//        arrayComparator.printArr(intArr1);
//        arrayComparator.printArr(intArr2);
//        System.out.println("Одинаковые INT (intArray1, intArray2): "
//                + arrayComparator.compareArrays(intArr1, intArr2));
//        arrayComparator.printArr(intArr1);
//        arrayComparator.printArr(intArr3);
//        System.out.println("Разные INT(intArray1, intArray3): "
//                + arrayComparator.compareArrays(intArr1, intArr3));
//        arrayComparator.printArr(strArr1);
//        arrayComparator.printArr(strArr2);
//        System.out.println("Одинаковые строчные(strArray1, strArray2): "
//                + arrayComparator.compareArrays(strArr1, strArr2));
//        arrayComparator.printArr(strArr1);
//        arrayComparator.printArr(strArr3);
//        System.out.println("Разные строчные (strArray1, strArray3): "
//                + arrayComparator.compareArrays(strArr1, strArr3));
    }
}