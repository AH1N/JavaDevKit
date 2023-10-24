package StaffBook;

public class Main {
    public static void main(String[] args) {

        System.out.println("Полный список: ");
        StaffBookClass staffBook = new StaffBookClass();

        staffBook.addInEmployeeList(new Employee(101, 55512345, "Анна", 5));
        staffBook.addInEmployeeList(new Employee(102, 55567890, "Борис", 7));
        staffBook.addInEmployeeList(new Employee(103, 55524680, "Ахмед", 3));
        staffBook.addInEmployeeList(new Employee(104, 55598765, "Георгий", 9));
        staffBook.addInEmployeeList(new Employee(105, 55511122, "Дарья", 6));
        staffBook.addInEmployeeList(new Employee(106, 55533344, "Евгений", 4));
        staffBook.addInEmployeeList(new Employee(107, 55599900, "Зинаида", 9));

        staffBook.printEmployeeList();
        System.out.println("========================================================= ");
        System.out.println("По стажу : ");
        staffBook.findByExperience(9);
        staffBook.findByExperience(5);
        staffBook.findByExperience(1000000);
        System.out.println("========================================================= ");
        System.out.println("По Имени : ");
        staffBook.findPhonenumberByName("Ктулху");
        staffBook.findPhonenumberByName("Дарья");
        System.out.println("========================================================= ");
        System.out.println("По Табелю : ");
        staffBook.findNameByPersonalNumber(0);
        staffBook.findNameByPersonalNumber(102);
        System.out.println("========================================================= ");
        System.out.println("Добавляем и ищем по стажк, имени и по табельному : ");
        staffBook.addInEmployeeList(new Employee(0, 5000000, "Ктулху", 1000000));
        staffBook.findByExperience(1000000);
        staffBook.findPhonenumberByName("Ктулху");
        staffBook.findNameByPersonalNumber(0);
    }
}