package JJAnimal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Hello ABSTRACT_ANIMAL!");

        Class<?> abstractAnimal = Class.forName("JJAnimal.AbstractAnimal");
        Constructor<?>[] constructorsAbstractAnimal = abstractAnimal.getConstructors();
        Method[] abstrMethods = abstractAnimal.getDeclaredMethods();

        Class<?> cat = Class.forName("JJAnimal.Cat");
        Constructor<?>[] constructorsCat = cat.getConstructors();
        Object catejka =constructorsCat[0].newInstance("5", "Cat_1");
        Method[] catejkaMethods = catejka.getClass().getDeclaredMethods();

        Class<?> dog = Class.forName("JJAnimal.Dog");
        Constructor<?>[] constructorsDog = dog.getConstructors();
        Object sobaken =constructorsDog[0].newInstance("4", "Dog_1");
        Method[] sobakenMethods = sobaken.getClass().getDeclaredMethods();

        sobakenMethods[1].invoke(sobaken);
        sobakenMethods[0].invoke(sobaken);

        ArrayList<AbstractAnimal> animalList = new ArrayList<>();

        animalList.add((Dog) sobaken);
        animalList.add((Cat) catejka);

        for ( Object animal:animalList) {

            System.out.println(animal);;

        }

    }
}