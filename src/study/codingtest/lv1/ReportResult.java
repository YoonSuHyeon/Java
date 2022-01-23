package study.codingtest.lv1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 신고 결과 받기
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 * <p>
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 * 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 */
public class ReportResult {

    private static class Report {
        private String id;
        /**
         * 불량 이용자
         */
        private String badUserName;

        public Report(String report) {
            String[] split = report.split(" ");
            id = split[0];
            badUserName = split[1];
        }

        public String getId() {
            return id;
        }

        public String getBadUserName() {
            return badUserName;
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        //정지될 수 없는 경우 전부 0으로 반환
        int idSize = id_list.length;
        if (idSize <= k)
            return new int[idSize];

        int[] answer = new int[idSize];
        //중복된 신고는 무시 (어떤 Id 가 어떤 User를 신고했는지)
        Map<String, List<Report>> reports = Arrays.stream(report).distinct().map(Report::new).collect(Collectors.groupingBy(Report::getId));
        //신고된 유저 찾기
        Set<String> badUserNames = reports.values().stream().flatMap(Collection::stream).map(Report::getBadUserName).collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() >= k).map(Map.Entry::getKey).collect(Collectors.toSet());

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            List<Report> idReport = reports.getOrDefault(id, Collections.emptyList());

            int count = (int) idReport.stream().filter(r -> badUserNames.contains(r.getBadUserName())).count();
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        ReportResult reportResult = new ReportResult();
        System.out.println(Arrays.toString(reportResult.solution(idList, report, 2)));
    }
}
