import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
    		int num = Integer.parseInt(br.readLine());
    		
    		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
    			maxHeap.add(num);
    			sb.append(num).append("\n");
    			continue;
    		}
    		
    		if (minHeap.isEmpty()) {
    			int p = maxHeap.peek();
    			if (p <= num) {
    				sb.append(p);
    				minHeap.add(num);
    			}
    			else {
    				sb.append(num);
    				minHeap.add(maxHeap.poll());
    				maxHeap.add(num);
    			}
    			
    			sb.append("\n");
    			continue;
    		}
    		
    		int sizeLeft = maxHeap.size();
    		int sizeRight = minHeap.size();
    		int min = maxHeap.peek();
    		int max = minHeap.peek();
    		
    		if(sizeLeft > sizeRight) {
    			if (min > num) {
    				minHeap.add(maxHeap.poll());
    				maxHeap.add(num);
    			}
    			else {
    				minHeap.add(num);
    			}
    		}
    		else {
    			if (num <= max) {
    				maxHeap.add(num);
    			}
    			else {
    				maxHeap.add(minHeap.poll());
    				minHeap.add(num);
    			}
    			
    		}
    		
    		sb.append(maxHeap.peek());
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
}
