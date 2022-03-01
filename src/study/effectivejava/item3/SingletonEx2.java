package study.effectivejava.item3;

/**
 * With Public Static Factory Method
 */
public class SingletonEx2 {
    private static final SingletonEx2 INSTANCE = new SingletonEx2();

    private SingletonEx2() {
    }

    public static SingletonEx2 getInstance() {
        return INSTANCE;
    }
}
