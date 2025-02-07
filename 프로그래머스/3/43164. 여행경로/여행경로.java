import java.util.*;

class Solution {
    static LinkedList<String> list;
    static Map<String, PriorityQueue<String>> map;
    
    public String[] solution(String[][] tickets) {
        list = new LinkedList<>();
        map = new HashMap<>();
        
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        
        dfs("ICN");
       
        return list.toArray(new String[0]);
    }
   
    static void dfs(String location) {
        
        while (map.containsKey(location) && !map.get(location).isEmpty()) {
            String to = map.get(location).poll();
            dfs(to);
        }
        list.addFirst(location);
    }
}