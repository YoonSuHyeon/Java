package study.effectivejava.item1.lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {

        // 로또를 자동 수동으로 뽑는다.
        Lotto autoLotto = LottoMachine.xx(PickType.AUTO);
        Lotto defaultLotto = LottoMachine.xx(PickType.DEFAULT);

        // 당첨 확인
        System.out.println(LottoReadMachine.check(autoLotto).toText());

    }
}
