package study.effectivejava.item1.lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * 복권 객체
 */
public class Lotto {
    private PickType pickType;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(PickType pickType, List<Integer> lottoNumbers) {
        this.pickType = pickType;
        this.lottoNumbers = lottoNumbers;
    }

    public PickType getPickType() {
        return pickType;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
