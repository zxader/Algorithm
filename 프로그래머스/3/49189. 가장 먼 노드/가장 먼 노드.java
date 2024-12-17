import java.util.*;

class Solution {
    class Node {
        int n;
        Node next;
        
        Node(int n, Node next) {
            this.n = n;
            this.next = next;
        }
    }
    
    static int N;
    static Node[] node;
    static boolean[] check;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        N = n;
        node = new Node[n + 1];
        check = new boolean[n + 1];
        
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            node[from] = new Node(to, node[from]);
            node[to] = new Node(from, node[to]);
        }
        answer = bfs();
        return answer;
    }
    
    public static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        check[1] = true;
        q.add(1);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count = 0;
            while(--size >= 0) {
                int num = q.poll();
                for (Node temp = node[num]; temp != null; temp = temp.next) {
                    if (!check[temp.n]) {
                        q.add(temp.n);
                        check[temp.n] = true;
                    }
                }
                count++;
            }
        }
        return count;
    }
}