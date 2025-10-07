import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] map = new int[N][M];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = (type == 1) ? (-1) * skill[i][5] : skill[i][5];

            map[r1][c1] += degree;
            if (c2 + 1 < M) map[r1][c2 + 1] -= degree;
            if (r2 + 1 < N) map[r2 + 1][c1] -= degree;
            if (r2 + 1 < N && c2 + 1 < M) map[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                temp += map[i][j];
                map[i][j] = temp;
            }
        }
        
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                temp += map[j][i];
                map[j][i] = temp;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + map[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}