package study.reflection;

public class Child extends Parent {
    public String cs;
    private String cs2 ="cs2";

    public Child() {
    }

    private Child(String str) {

    }

    public void method3() {
        System.out.println("method3");
    }

    public int method4(int n) {
        System.out.println("method4" + n);
        return n;
    }

    public int method6(int n, String s) {
        System.out.println("method6" + n + s);
        return n;
    }

    private int method5(int n) {
        System.out.println("method5" + n);
        return n;
    }
}
