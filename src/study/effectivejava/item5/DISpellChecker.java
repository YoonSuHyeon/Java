package study.effectivejava.item5;

import java.util.List;

public class DISpellChecker {
    private final Dictionary dictionary;

    public DISpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggestions(typo);
    }
}
