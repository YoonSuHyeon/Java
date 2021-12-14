package study.codingtest.lv1;

import java.util.*;

/**
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */
public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;

        for (int[] size : sizes) {
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);

            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
        }
        return maxX * maxY;
    }

    public static void main(String[] args) {
        MinimumRectangle minimumRectangle = new MinimumRectangle();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(minimumRectangle.solution(sizes));
    }
}
