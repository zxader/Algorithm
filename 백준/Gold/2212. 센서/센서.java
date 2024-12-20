import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static List<Integer> sensors;
	static List<Integer> distances;
	
	public static void main(String[] args) throws Exception{
		
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		sensors = new ArrayList<>();
		distances = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensors.add(Integer.parseInt(st.nextToken()));
		}
		
		// 센서 좌표 정렬
		Collections.sort(sensors);
		
		// 센서 간의 거리 계산
		for (int i = 0; i < N - 1; i++) {
            distances.add(sensors.get(i + 1) - sensors.get(i));
        }
		
        // 거리 정렬
		Collections.sort(distances);
		
		// 최소 영역 길이 구하기
		int result = 0;
		for (int i = 0; i < N - K; i++) {
			result += distances.get(i);
		}
		
		sb.append(result);
		System.out.println(sb);
	}
}