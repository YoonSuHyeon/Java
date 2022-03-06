package study.effectivejava.item6;

public class MainTest {

    public static void main(String[] args) {
        String s = new String("TEST");
        String s1 = "TEST";
    }

    private static long sum() {
        //Long -> long 을 사용하는것이 성능상 이점을 얻을 수 있다.
        //의도하지 않은 Autoboxing을 피하자
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
