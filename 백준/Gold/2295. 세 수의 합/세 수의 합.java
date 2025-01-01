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

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sums);

        int result = Integer.MIN_VALUE;

        for (int k = N - 1; k >= 0; k--) { 
            for (int i = 0; i < N; i++) {
                int target = arr[k] - arr[i];
                if (binarySearch(target)) {
                    result = Math.max(result, arr[k]);
                }
            }
        }

        System.out.println(result);
    }

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