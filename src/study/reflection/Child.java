package study.reflection;

public class Child extends Parent {
    public String cs;
    private String cs2;

    public Child() {
    }

    private Child(String str) {

    }

    public int method4(int n) {
        System.out.println("method4" + n);
        return n;
    }

    private int method5(int n) {
        System.out.println("method5" + n);
        return n;
    }
}
