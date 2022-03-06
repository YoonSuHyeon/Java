package study.effectivejava.item5;

import java.util.List;

/**
 * 사전 interface
 */
public interface Dictionary {
    boolean isValid(String word);

    List<String> suggestions(String typo);
}
