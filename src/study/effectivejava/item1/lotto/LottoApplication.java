package study.effectivejava.item1.lotto;


import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        //로또를 자동으로 뽑는다.
        Lotto autoLotto = LottoMachine.drawAutoLotto();

        //로또를 수동으로 뽑는다.
        List<Integer> drawNumbers = draw();
        Lotto defaultLotto = LottoMachine.drawDefaultLotto(drawNumbers);

        // 당첨 확인
        Result autoResult = LottoResultMachine.check(autoLotto);
        Result defaultResult = LottoResultMachine.check(defaultLotto);

        // 결과 출력
        System.out.println("autoResult = " + autoResult.toText());
        System.out.println("defaultResult = " + defaultResult.toText());
    }

    /**
     * 수동으로 6개 번호 뽑기
     *
     * @return
     */
    private static List<Integer> draw() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(41);
        list.add(32);
        list.add(25);
        list.add(11);
        return list;
    }
}
