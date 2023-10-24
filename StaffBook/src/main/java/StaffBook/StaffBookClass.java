package StaffBook;

import java.util.ArrayList;

public class StaffBookClass {
    private ArrayList<Employee> employeeList;

    public StaffBookClass(){
        this.employeeList = new ArrayList<>();
    }

    public void addInEmployeeList(Employee employee){
        this.employeeList.add(employee);
    }

    public void printEmployeeList(){
        for (Employee element: this.employeeList) {
           element.printEmployee();
        }
    }

    public ArrayList<Employee> getEmployeeList(){
        return this.employeeList;
    }

    private void printIfNotEmptyList(StaffBookClass tmpStaffBook, Object inputValue){
        if (!tmpStaffBook.getEmployeeList().isEmpty()){
            System.out.println("Результат поиска: \n");

            tmpStaffBook.printEmployeeList();
        }else {System.out.println("Ничего не найдено <" + inputValue + ">");}
    }

    public void findByExperience(int inputExperience){
        StaffBookClass tmpStaffBook = new StaffBookClass();
        for (Employee element: this.employeeList) {
            if (element.isExperience(inputExperience)){tmpStaffBook.addInEmployeeList(element);}
        }
        printIfNotEmptyList(tmpStaffBook, inputExperience);
    }

    public void findPhonenumberByName(String inputName){
        StaffBookClass tmpStaffBook = new StaffBookClass();
        for (Employee element: this.employeeList) {
            if (element.isName(inputName)){tmpStaffBook.addInEmployeeList(element);}
        }
        printIfNotEmptyList(tmpStaffBook, inputName);
    }

    public void findNameByPersonalNumber(int personalNumber){
        StaffBookClass tmpStaffBook = new StaffBookClass();
        for (Employee element: this.employeeList) {
            if (element.isPersonalNumber(personalNumber)){tmpStaffBook.addInEmployeeList(element);}
        }
        printIfNotEmptyList(tmpStaffBook, personalNumber);
    }
}
