package study.effectivejava.item1.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 기계
 * 45개의 숫자 중 당첨 번호 여섯 개를 골라주는 로또 기계
 */
public class LottoMachine {

    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    /**
     * 자동 로또 구매
     *
     * @return
     */
    public static Lotto drawAutoLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(PickType.AUTO, lottoNumbers.subList(0, LOTTO_SIZE));
    }

    /**
     * 수동 로또 구매
     *
     * @param numbers
     * @return
     */
    public static Lotto drawDefaultLotto(List<Integer> numbers) {
        //뽑은 번호가 1 ~ 45 사이 숫자인지 확인..
        if (!lottoNumbers.containsAll(numbers))
            throw new RuntimeException("Invalid Lotto Numbers");

        return new Lotto(PickType.DEFAULT, numbers);
    }

}
