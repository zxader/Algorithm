import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited; 
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Point implements Comparable<Point> {
        int r; 
        int c;
        int wall;

        public Point(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }

        @Override
        public int compareTo(Point o) {
            return this.wall - o.wall; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE; 
            }
        }

        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, 0));
        visited[0][0] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == N - 1 && p.c == M - 1) {
                System.out.println(p.wall);
                break;
            }

            for (int[] delta : deltas) {
                int dr = p.r + delta[0];
                int dc = p.c + delta[1];

                if (0 <= dr && dr < N && 0 <= dc && dc < M) {
                    int newWall = p.wall + map[dr][dc];
                   
                    if (visited[dr][dc] > newWall) {
                        visited[dr][dc] = newWall;
                        q.add(new Point(dr, dc, newWall));
                    }
                }
            }
        }
    }
}