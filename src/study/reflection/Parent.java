package study.reflection;

public class Parent {
    private String s1;
    public String s2;

    public Parent() {

    }

    private void method1() {
        System.out.println("method1");
    }

    public void method2(int n) {
        System.out.println("method2" + n);
    }

    private void method3() {
        System.out.println("method3");
    }
}
