package study.effectivejava.item3;

import java.lang.reflect.Constructor;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        SingletonEx1 singleton = SingletonEx1.INSTANCE;

        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        SingletonEx1 singleton2 = (SingletonEx1) constructor.newInstance();

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        singleton.setValue(1);
        singleton2.setValue(2);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}
