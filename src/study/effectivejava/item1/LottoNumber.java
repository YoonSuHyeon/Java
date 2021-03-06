package study.effectivejava.item1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Static Factory Method Example 2
 * Two Advantage : Do not create new objects.
 */
public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return lottoNumberCache.get(number);
    }

    public static void main(String[] args) {
        LottoNumber lottoNumber = LottoNumber.of(1);
        System.out.println(lottoNumber.number);

        LottoNumber sameNumber = LottoNumber.of(1);
        System.out.println(lottoNumber == sameNumber);

    }
}


