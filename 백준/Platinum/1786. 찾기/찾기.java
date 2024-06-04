
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{

		// 0. 입력파일 읽어들이기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력 파일 객체화
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();

		// 2. 알고리즘 풀기
		int tLength = T.length; // 본문 길이
		int pLength = P.length; // 패턴 길이

		// 1단계: 부분일치 테이블 만들기 (패턴 분석하기)
		int[] pi = new int[pLength]; // pi 테이블

		// i: 패턴의 접시마 포인터
		// j: 패턴의 접두사 포인터
		for (int i = 1, j = 0; i < pLength; i++) {

			// 현재 비교하는 문자가 불일치하면
			while (j > 0 && P[i] != P[j]) {
				// 패턴의 접미사가 패턴의 접두사가
				// 일치하도록 j 포인터를 옮긴다. 
				// (처음부터 비교하지 않고 접두사 길이만큼 생략하여
				// 그 다음부터 비교)
				j = pi[j - 1];
			}

			// 일치하는 부분 발견
			// 연속적으로 일치하게 되면 접두사 혹은 접미사의 길이가 길어짐
			if (P[i] == P[j]) {
				pi[i] = ++j;
			}
			// 불일치하면 처음부터 비교하기 위한 인덱스 번호 0 넣기
			else {
				pi[i] = 0;
			}
		}

		// 2단계: 부분일치 테이블을 활용하여 텍스트와 패턴 비교
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		
		// i: 텍스트의 접시마 포인터
		// j: 패턴의 접두사 포인터
		for (int i = 0, j = 0; i < tLength; i++) {

			// 현재 비교하는 문자가 불일치하면
			while (j > 0 && T[i] != P[j]) {
				// 텍스트의 접미사가 패턴의 접두사가
				// 일치하도록 j 포인터를 옮긴다. 
				// (처음부터 비교하지 않고 접두사 길이만큼 생략하여 그 다음부터 비교)
				j = pi[j - 1] ;
			}
			
			// 두 글자 일치
			if (T[i] == P[j]) {
				
				// j가 패턴의 마지막 인덱스라면 패턴과 일치하는 단어 찾기
				if (j == pLength - 1) {
					cnt++; // 찾은 단어 개수 증가
					list.add(i - (pLength - 1)); // 찾은 단어의 첫 인덱스 번호를 저장
					
					// j 위치까지는 일치 했으므로 일치했던 곳의 인덱스 번호를 부분일치 테이블에서 가져옴
					j = pi[j];
				}
				// j가 패턴의 마지막 인덱스가 아닐 경우는 다음 패턴 인덱스로 이동
				else {
					j++;
				}
			}
			
		}

		// 3. 정답 출력
		sb.append(cnt).append("\n");
		
		if (cnt > 0) {
			for (int i : list) {
				sb.append(i + 1).append(" ");
			}
		}
		System.out.println(sb);
	}
}
