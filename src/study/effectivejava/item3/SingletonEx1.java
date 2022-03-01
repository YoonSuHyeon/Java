package study.effectivejava.item3;

import java.io.Serializable;

/**
 * With Public Static Final Field
 */
public class SingletonEx1 implements Serializable {
    private int value;
    public static final SingletonEx1 INSTANCE = new SingletonEx1();

    private SingletonEx1() {

    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Serializable 구현하지 않고 하는경우 오류
     *
     * @return
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}
