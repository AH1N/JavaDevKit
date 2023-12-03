package JJAnimal;

public class Cat extends AbstractAnimal{

    public Cat(String age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
