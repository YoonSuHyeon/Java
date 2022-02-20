package study.effectivejava.item1;

/**
 * Static Factory Method Example 3
 * Three Advantage : Can Return an Object of any subtype of their return type.
 */
public class Animal {

    public static Animal of(AnimalType type) {
        return switch (type) {
            case DOG -> new Dog();
            case CAT -> new Cat();
        };
    }

    public static void main(String[] args) {
        Animal cat = Animal.of(AnimalType.CAT);
        System.out.println(cat.getClass());
    }
}
