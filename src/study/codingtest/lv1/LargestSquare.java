package study.codingtest.lv1;

/**
 * 가장 큰 정사각형 찾기
 */
public class LargestSquare {
    public int solution(int[][] board) {
        if(board.length == 1)
            return 1;

        int max = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    int min = Math.min(Math.min(board[i][j - 1], board[i - 1][j - 1]), board[i - 1][j]) + 1;
                    if (max < min)
                        max = min;

                    board[i][j] = min;
                }
            }
        }
        return max * max;
    }


    public static void main(String[] args) {
        int[][] board = {{1, 0}, {0, 0}};
        LargestSquare largestSquare = new LargestSquare();

        System.out.println("largestSquare = " + largestSquare.solution(board));
    }
}
