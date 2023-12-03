package JJAnimal;

public abstract class AbstractAnimal {
    String age;
    String name;

    public AbstractAnimal(String age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
