package study.effectivejava.item5;

import java.util.List;


public class Dictionary1 implements Dictionary {

    @Override
    public boolean isValid(String word) {
        System.out.println("Dictionary1");
        return false;
    }

    @Override
    public List<String> suggestions(String typo) {
        return null;
    }
}
