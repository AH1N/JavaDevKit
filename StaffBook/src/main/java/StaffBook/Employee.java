package StaffBook;

import java.util.Objects;

public class Employee {

    public int personalNumber;
    public int phoneNumber;
    public String name;
    public int experience;

    public Employee(int personalNumber, int phoneNumber, String name, int experience){
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public void printEmployee(){
        System.out.println(personalNumber +"\t"+"\t"+ name +"\t"+"\t"+ phoneNumber +"\t"+ experience);
        System.out.println("-------------------------------------------------------------------------");
    }

    public int getPeronalNumber(){
        return this.personalNumber;
    }

    public boolean isPersonalNumber(int inputNumber) {
        return this.getPeronalNumber() == inputNumber;
//        return this.personalNumber == inputNumber;
    }


    public int getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getName(){
        return this.name;
    }
    public boolean isName(String inputName) {
        return this.name.equals(inputName);
    }

    public boolean isName2(String inputName) {
        return this.name == inputName;
    }

    public int getExperience(){
        return this.experience;
    }

    public boolean isExperience(int inputExperience) {
        return this.getExperience() == inputExperience;
    }

}
