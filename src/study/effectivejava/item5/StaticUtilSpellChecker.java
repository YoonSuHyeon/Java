package study.effectivejava.item5;

import java.util.List;

/**
 * 맞춤법 검사기 : static utility 구현 (올바르지 않다.)
 */
public class StaticUtilSpellChecker {
    private static final Dictionary dictionary = new Dictionary1();

    private StaticUtilSpellChecker() {
    }

    public static boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public static List<String> suggestions(String typo) {
        return dictionary.suggestions(typo);
    }

}
