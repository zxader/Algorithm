import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static Map<Integer, Integer> myCards;
	static int[] cards;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        myCards = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	int myCard = Integer.parseInt(st.nextToken());
        	
        	if (myCards.containsKey(myCard)) {
        		myCards.put(myCard, myCards.get(myCard) + 1);
        	}
        	else {
        		myCards.put(myCard, 1);
        	}
        }
        
        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	int card = Integer.parseInt(st.nextToken());
        	sb.append(myCards.getOrDefault(card, 0) + " ");
        }
        
        System.out.println(sb);
    }

}