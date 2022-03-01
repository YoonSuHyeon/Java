package study.effectivejava.item3;

public class EnumDemo {

    public static void main(String[] args) {
        SingletonEx4 singleton = SingletonEx4.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
