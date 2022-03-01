package study.effectivejava.item1.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 랜덤으로 6개의 숫자를 뽑는 클래스
 */
public class LottoResultMachine {
    /**
     * 당첨 번호
     */
    private static final List<Integer> selectedNumbers = Arrays.asList(1, 5, 41, 32, 25, 11);

    public static Result check(Lotto lotto) {
        String result = selectedNumbers.containsAll(lotto.getLottoNumbers()) ? "당첨" : "낙첨";
        if (lotto.getPickType() == PickType.AUTO)
            return new AutoResult(result);

        return new DefaultResult(result);
    }

}
