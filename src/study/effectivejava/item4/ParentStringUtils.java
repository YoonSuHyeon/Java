package study.effectivejava.item4;

/**
 * private 기본 생성자를 갖고 있고 다른 public 생성자를 갖는경우
 */
public class ParentStringUtils {
    private ParentStringUtils() {
        System.out.println("private 생성자");
    }

    public ParentStringUtils(String s) {
        System.out.println("public 생성자");
    }
}
