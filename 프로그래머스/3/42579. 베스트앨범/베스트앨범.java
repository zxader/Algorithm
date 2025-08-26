import java.util.*;

class Solution {
    static class Music implements Comparable<Music> {
        int no, plays;
        String genre;
        
        Music(int no, int plays, String genre) {
            this.no = no;
            this.plays = plays;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Music o) {
            if (o.genre.equals(this.genre)) {
                if (this.plays == o.plays) return this.no - o.no;
                return o.plays - this.plays;
            }
            return map.get(o.genre) - map.get(this.genre);
        }
    }
    
    static Map<String, Integer> map;
    
    public int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Music> q = new PriorityQueue<>();
        for (int i = 0; i < genres.length; i++) {
            q.offer(new Music(i, plays[i], genres[i]));
        }
        
        String genre = q.peek().genre;
        int cnt = 0;
        
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Music m = q.poll();
            cnt++;
            
            if (!genre.equals(m.genre)) {
                genre = m.genre;
                cnt = 1;
            }
            
            list.add(m.no);
            
            if (cnt == 2) {
                while (!q.isEmpty()) {
                    if (!q.peek().genre.equals(genre)) break;
                    q.poll();
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}