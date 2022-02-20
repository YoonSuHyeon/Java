package study.effectivejava.item1.lotto;

/**
 * 로또 결과 반환 interface
 */
public interface Result {
    /**
     * 당첨 결과 확인.
     * 당첨 : 2개의 번호가 맞는 경우 -> "당첨" 반환
     * 낙첨 : "낙첨" 반환
     *
     * @return
     */
    String toText();
}
