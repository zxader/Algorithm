import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static StringBuilder sb2;
	static int T;
	static void dfs(int N, int r) {
		if(N == 0) {
			return;
		}
		sb2 = new StringBuilder();

		for(int i = 0; i < r; i++) {
			sb2.append("____");
		}
		if(N == 1) {
			sb.append(sb2).append("\"재귀함수가 뭔가요?\"\n");
			sb.append(sb2).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		}else {
			sb.append(sb2).append("\"재귀함수가 뭔가요?\"").append("\n");
			sb.append(sb2).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
			sb.append(sb2).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
			sb.append(sb2).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
		}
		dfs(N-1,r+1);
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		T = Integer.parseInt(in.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		dfs(T+1, 0);
		sb.append(sb2).append("라고 답변하였지.").append("\n");
		
		for(int i = T-1; i >=0; i--) {
			sb2.delete(0,4);
			sb.append(sb2).append("라고 답변하였지.").append("\n");
			
		}
		System.out.println(sb);
	}
}