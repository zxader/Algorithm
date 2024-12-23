import java.util.*;

class Solution {
    private static String numbers; 
    private static boolean[] visited; 
    private static Set<Integer> primeSet;

    public int solution(String numbers) {
        this.numbers = numbers; 
        visited = new boolean[numbers.length()]; 
        primeSet = new HashSet<>(); 

        perm("");

        return primeSet.size(); // 소수의 개수 반환
    }

    // 순열 
    private void perm(String current) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primeSet.add(num); // 소수이면 Set에 추가
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) { 
                visited[i] = true; 
                perm(current + numbers.charAt(i));
                visited[i] = false; 
            }
        }
    }

    // 소수 판별 
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
