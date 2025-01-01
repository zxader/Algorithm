import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer> sums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sums = new ArrayList<>();

        // 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 두 수의 합 리스트 생성
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }

        // 두 수의 합 리스트 정렬
        Collections.sort(sums);

        int result = Integer.MIN_VALUE;

        // 세 수의 합 계산
        for (int k = N - 1; k >= 0; k--) { // arr[k]를 세 수의 합으로 고려
            for (int i = 0; i < N; i++) {  // arr[i]
                int target = arr[k] - arr[i];
                if (binarySearch(target)) {
                    result = Math.max(result, arr[k]);
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // 이분 탐색
    static boolean binarySearch(int target) {
        int start = 0;
        int end = sums.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (sums.get(mid) == target) {
                return true;
            } else if (sums.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}