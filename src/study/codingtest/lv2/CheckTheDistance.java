package study.codingtest.lv2;

import java.util.Arrays;


/**
 * 거리두기 확인하기
 * 아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
 * <p>
 * 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
 * 거리두기를 위하여 응시자들 끼리는 맨해튼 거리가 2 이하로 앉지 말아 주세요.
 * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
 * P : 응시자가 앉아 있는 자리 ,O : 빈 테이블 , X: 파티션
 * <p>
 * 5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다.
 * 자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 places가 매개변수로 주어집니다.
 * 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 * <p>
 * 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
 */
public class CheckTheDistance {


    public int[] solution(String[][] places) {
        return Arrays.stream(places).mapToInt(this::getInt).toArray();
    }

    private int getInt(String[] strings) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (strings[i].charAt(j) == 'P' && !checked(i, j, strings))
                    return 0;
        return 1;
    }

    private boolean checked(int i, int j, String[] strings) {
        //옆에 P 인경우
        if (j < 4 && strings[i].charAt(j + 1) == 'P')
            return false;
        //아래가 P 인경우
        if (i < 4 && strings[i + 1].charAt(j) == 'P')
            return false;
        //P O P 인경우
        if (j < 3 && strings[i].charAt(j + 1) == 'O' && strings[i].charAt(j + 2) == 'P')
            return false;
        //P
        //O
        //P 인경우
        if (i < 3 && strings[i + 1].charAt(j) == 'O' && strings[i + 2].charAt(j) == 'P')
            return false;

        if (i < 4 && j < 4 && strings[i + 1].charAt(j + 1) == 'P' && !(strings[i + 1].charAt(j) == 'X' &&
                strings[i].charAt(j + 1) == 'X'))
            return false;

        //O P
        //P O 인경우
        if (i < 4 && j > 0 && strings[i + 1].charAt(j - 1) == 'P' && !(strings[i].charAt(j - 1) == 'X' &&
                strings[i + 1].charAt(j) == 'X'))
            return false;

        return true;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };


        CheckTheDistance checkTheDistance = new CheckTheDistance();
        int[] solution = checkTheDistance.solution(places);

        for (int i : solution)
            System.out.println(i);
    }
}
