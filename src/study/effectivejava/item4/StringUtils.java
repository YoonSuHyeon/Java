package study.effectivejava.item4;

public class StringUtils {
    private static String EX_PREFIX = "TEST";

    /**
     * 인스턴스화를 불가능하게하는 방법
     */
    private StringUtils() {
        throw new AssertionError();
    }

    public static String addPrefix(String s) {
        return EX_PREFIX + s;
    }
}
