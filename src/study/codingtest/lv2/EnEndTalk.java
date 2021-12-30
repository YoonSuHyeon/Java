package study.codingtest.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 영어 끝말잇기
 * 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
 * 만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
 */
public class EnEndTalk {
    public int[] solution(int n, String[] words) {
        //초기화
        int[] answer = {0, 0};
        List<String> used = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            //비어있지 않고, 규칙에 어긋난 경우
            if (!used.isEmpty() && (used.contains(words[i]) || !checkWord(used.get(used.size() - 1), words[i]))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            used.add(words[i]);
        }

        return answer;
    }

    /**
     * @param lastWord
     * @param newWord
     * @return
     */
    private boolean checkWord(String lastWord, String newWord) {
        return newWord.startsWith(lastWord.substring(lastWord.length() - 1));
    }

    public static void main(String[] args) {
        EnEndTalk enEndTalk = new EnEndTalk();
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = enEndTalk.solution(3, words);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
