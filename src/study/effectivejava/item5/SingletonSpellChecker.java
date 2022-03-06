package study.effectivejava.item5;

import java.util.List;

/**
 * 맞춤법 검사기 : singleton 구현 (올바르지 않다.)
 */
public class SingletonSpellChecker {
    private final Dictionary dictionary = new Dictionary1();
    public static SingletonSpellChecker INSTANCE = new SingletonSpellChecker();

    private SingletonSpellChecker() {
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggestions(typo);
    }

}
