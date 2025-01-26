import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
        
        int[] arr = new int[N];  // 용액의 특성값
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투포인터를 활용하여 두 용액 구하기
        Arrays.sort(arr);
        
        int left = 0;
        int right = N - 1;
        int resultLeft = arr[0]; 
        int resultRight = arr[N - 1];
        int result = Integer.MAX_VALUE; // 두 용액을 합해서  0에 가까운 값을 저장하기 위한 변수 
        
        while (left < right) {
        	int sum = arr[left] + arr[right];
        	
        	if (Math.abs(sum) < result) {
        		result = Math.abs(sum);
        		resultLeft = arr[left];
        		resultRight = arr[right];
        	}
        	
        	if (sum > 0) {
        		right--;
        	}
        	else {
        		left++;
        	}
        }
        
        // 결과 출력
        System.out.println(resultLeft + " " + resultRight);
	}
}