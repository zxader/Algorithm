import java.util.*;

class Solution {
    static class Word {
        String w;
        int v;
        Word(String w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word w = q.poll();
            
            if (w.w.equals(target)) return w.v;
            for (int d = 0; d < words.length; d++) {
                if (visited[d]) continue;
                if (!isWord(w.w, words[d])) continue;
                q.offer(new Word(words[d], w.v + 1));
                visited[d] = true;
            }
        }
        
        return answer;
    }
    
    static boolean isWord(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}