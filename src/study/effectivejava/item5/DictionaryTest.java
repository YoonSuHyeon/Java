package study.effectivejava.item5;

public class DictionaryTest {

    public static void main(String[] args) {
        //한가지의 사전만 사용
        SingletonSpellChecker.INSTANCE.isValid("TEST");
        StaticUtilSpellChecker.isValid("TEST");

        //여러가지가 가능한 경우
        DISpellChecker diSpellChecker1 = new DISpellChecker(new Dictionary1());
        diSpellChecker1.isValid("TEST");

        DISpellChecker diSpellChecker2 = new DISpellChecker(new Dictionary2());
        diSpellChecker2.isValid("TEST");

    }
}
