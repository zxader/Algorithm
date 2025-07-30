import java.io.*;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][2 * N - 1];

        // 공백 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                stars[i][j] = ' ';
            }
        }

        drawStar(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (char[] row : stars) {
            sb.append(row).append("\n");
        }
        System.out.print(sb);
    }

    static void drawStar(int n, int r, int c) {
        if (n == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = '*';
            stars[r + 1][c + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                stars[r + 2][c + i] = '*';
            }
            return;
        }

        int half = n / 2;
        drawStar(half, r, c);                 // 위
        drawStar(half, r + half, c - half);   // 왼쪽 아래
        drawStar(half, r + half, c + half);   // 오른쪽 아래
    }
}
