package study.codingtest.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 카카오는 하반기 경력 개발자 공개채용을 진행 중에 있으며 현재 지원서 접수와 코딩테스트가 종료되었습니다.
 * 이번 채용에서 지원자는 지원서 작성 시 아래와 같이 4가지 항목을 반드시 선택하도록 하였습니다.
 * <p>
 * 코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
 * 지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
 * 지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
 * 선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
 */
public class RankSearch {

    private static class Candidate {
        private Lang lang;
        private Occupation occupation;
        private Career career;
        private Food food;
        private int score;

        public Candidate(String info) {
            String[] split = info.split(" ");

            lang = Lang.valueOf(split[0]);
            occupation = Occupation.valueOf(split[1]);
            career = Career.valueOf(split[2]);
            food = Food.valueOf(split[3]);
            score = Integer.parseInt(split[4]);
        }

        public int getScore() {
            return score;
        }
    }

    private enum Lang {
        cpp, java, python
    }

    private enum Occupation {
        backend, frontend
    }

    private enum Career {
        junior, senior
    }

    private enum Food {
        chicken, pizza
    }

    public int[] solution(String[] info, String[] query) {
        Map<Integer, List<Candidate>> map = Arrays.stream(info).map(Candidate::new).collect(Collectors.groupingBy(Candidate::getScore));

        return Arrays.stream(query).mapToInt(q -> {
            String[] q1 = q.split(" and ");
            String[] q2 = q1[3].split(" ");
            List<Candidate> candidates = map.keySet().stream().filter(k -> Integer.parseInt(q2[1]) <= k).flatMap(integer -> map.get(integer).stream()).collect(Collectors.toList());

            Predicate<Candidate> f = c ->
                    (q1[0].equals("-") || Lang.valueOf(q1[0]) == c.lang)
                            && (q1[1].equals("-") || Occupation.valueOf(q1[1]) == c.occupation)
                            && (q1[2].equals("-") || Career.valueOf(q1[2]) == c.career)
                            && (q2[0].equals("-") || Food.valueOf(q2[0]) == c.food);

            return (int) candidates.stream().filter(f).count();
        }).toArray();

    }

//    public class Solution {
//        public int[] solution(String[] info, String[] query) {
//            Map<String, List<Integer>> infos = new HashMap<>();
//            for (String in : info) {
//                String[] split = in.split(" ");
//                int score = Integer.parseInt(split[4]);
//
//                for (int i = 0; i < (1 << 4); i++) {
//                    StringBuilder key = new StringBuilder();
//                    for (int j = 0; j < 4; j++) {
//                        if ((i & (1 << j)) > 0) key.append(split[j]);
//                    }
//                    infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
//                }
//            }
//
//            List<Integer> empty = new ArrayList<>();
//            for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
//                entry.getValue().sort(null);
//
//            int[] answer = new int[query.length];
//            for (int i = 0; i < query.length; i++) {
//                String[] split = query[i].replaceAll("-", "").split(" and | ");
//                String key = String.join("", split[0], split[1], split[2], split[3]);
//                int score = Integer.parseInt(split[4]);
//
//                List<Integer> list = infos.getOrDefault(key, empty);
//
//                int s = 0, e = list.size();
//
//                while (s < e) {
//                    int mid = (s + e) / 2;
//
//                    if (list.get(mid) < score) s = mid + 1;
//                    else e = mid;
//                }
//
//                answer[i] = list.size() - s;
//            }
//
//            return answer;
//        }
//    }


    //첫번째 시도
//    public int[] solution(String[] info, String[] query) {
//        Map<Integer, List<Candidate>> map = Arrays.stream(info).map(Candidate::new).collect(Collectors.groupingBy(Candidate::getScore));
//
//        return Arrays.stream(query).mapToInt(q -> {
//            String[] q1 = q.split(" and ");
//            String[] q2 = q1[3].split(" ");
//            List<Candidate> candidates = map.keySet().stream().filter(k -> Integer.parseInt(q2[1]) <= k).flatMap(integer -> map.get(integer).stream()).collect(Collectors.toList());
//
//            Predicate<Candidate> f = c ->
//                    (q1[0].equals("-") || Lang.valueOf(q1[0]) == c.lang)
//                            && (q1[1].equals("-") || Occupation.valueOf(q1[1]) == c.occupation)
//                            && (q1[2].equals("-") || Career.valueOf(q1[2]) == c.career)
//                            && (q2[0].equals("-") || Food.valueOf(q2[0]) == c.food);
//
//            return (int) candidates.stream().filter(f).count();
//        }).toArray();
//
//    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        RankSearch rankSearch = new RankSearch();
        int[] answer = rankSearch.solution(info, query);

        Arrays.stream(answer).forEach(System.out::println);
    }
}
