package study.effectivejava.item1;

public class Application {
    public static void main(String[] args) {
        Grade a = GradeCalculator.of(90);
        Grade b = GradeCalculator.of(80);
        Grade c = GradeCalculator.of(70);

        System.out.println(a.toText());
        System.out.println(b.toText());
        System.out.println(c.toText());

    }
}
