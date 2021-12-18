package study.etc;

import java.util.ArrayList;
import java.util.List;

/**
 * 회사에서 실제로 분기처리에 관한 실수 관련
 */
public class StaticArea {

    private static final List<Integer> MISTATE_LIST;
    private static final List<Integer> OLD_LIST;
    private static final List<Integer> NEW_LIST;

    static {
        //실수한 코드
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        if (VersionChecker.isTest())
            list.add(4);
        MISTATE_LIST = list;

        //변경된 코드
        List<Integer> oldList = new ArrayList<>();
        oldList.add(1);
        oldList.add(2);
        oldList.add(3);
        OLD_LIST = oldList;

        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        NEW_LIST = newList;

    }

    /**
     * 다른 곳에서 사용
     *
     * @return
     */
    public List<Integer> getList() {
        if (!VersionChecker.isTest())
            return OLD_LIST;
        return NEW_LIST;
    }

    /**
     * 버전을 체크하는 클래스 테스트 용도로 작성
     */
    private static class VersionChecker {
        private static boolean isTest() {
            //특정한 조건 검사를 통해서 true, false 반환 (예시로 true 반환)
            return true;
        }
    }
}
