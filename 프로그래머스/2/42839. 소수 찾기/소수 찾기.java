import java.util.*;

class Solution {
    static int N;
    static int temp;
    static boolean[] check;
    static String tempNumbers;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        N = numbers.length();
        temp = 0;
        check = new boolean[N];
        tempNumbers = numbers;
        set = new HashSet<>();
        
        perm(0);
        
        // 중복 제거 후 소수 갯수 리턴
        return set.size();
    }
    
    // 순열
    static void perm(int cnt) {
        if (cnt > 0) {
            // 소수인지 확인
            checkNum(temp);
        }
        
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            
            temp = temp * 10 + (tempNumbers.charAt(i) - '0');
            check[i] = true;
            perm(cnt + 1);
            check[i] = false;
            temp /= 10;
        }
        
    }
    
    // 소수인지 확인
    static void checkNum(int num) {
        if (num <= 1) return;
        
        for (int i = 2; i <= Math.sqrt(num);i++) {
            
            // 소수 아닌 경우
            if (num % i == 0) {
                return;
            }
        }
        
        // 소수인 경우 set에 추가
        set.add(num);
    }
}