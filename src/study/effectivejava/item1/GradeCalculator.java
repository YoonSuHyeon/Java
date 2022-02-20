package study.effectivejava.item1;

public class GradeCalculator {

    public static Grade of(int score) {
        if (score >= 90)
            return new AGrade();

        if (score >= 80)
            return new BGrade();

        return new FGrade();
    }
}
