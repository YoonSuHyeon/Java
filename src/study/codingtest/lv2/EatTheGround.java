package study.codingtest.lv2;

import java.util.Arrays;

/**
 * 땅따먹기 게임을 하려고 합니다.
 * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 * 최고점 반환
 */
public class EatTheGround {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}};
        EatTheGround eatTheGround = new EatTheGround();

        System.out.println(eatTheGround.solution(land));
    }
}
