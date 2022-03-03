package study.effectivejava.item4;

public class ChildStringUtils extends ParentStringUtils {

    public ChildStringUtils(String s) {
        super(s);
        System.out.println("child");
    }
}
