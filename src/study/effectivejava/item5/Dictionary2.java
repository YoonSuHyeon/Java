package study.effectivejava.item5;

import java.util.List;

public class Dictionary2 implements Dictionary {
    @Override
    public boolean isValid(String word) {
        System.out.println("Dictionary2");
        return false;
    }

    @Override
    public List<String> suggestions(String typo) {
        return null;
    }
}
