package study.effectivejava.item3;

/**
 * With Lazy Initialization
 */
public class SingletonEx3 {
    private static SingletonEx3 INSTANCE = null;

    private SingletonEx3() {

    }

    public static SingletonEx3 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonEx3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonEx3();
                }
            }
        }
        return INSTANCE;
    }
}
