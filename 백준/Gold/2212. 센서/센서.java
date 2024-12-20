import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 센서의 개수
        int k = sc.nextInt(); // 집중국의 개수

        // 센서의 좌표 입력
        int[] sensors = new int[n];
        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }

        // 센서 좌표 정렬
        Arrays.sort(sensors);

        // 센서 간의 거리 계산
        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 내림차순 정렬
        Arrays.sort(distances);

        // 집중국이 센서보다 많거나 같은 경우 영역 길이는 0
        if (k >= n) {
            System.out.println(0);
            return;
        }

        // 가장 큰 (k-1)개의 거리를 제외한 합이 최소 영역 길이
        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += distances[i];
        }

        // 결과 출력
        System.out.println(result);
    }
}