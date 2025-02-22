import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int k = 1;
        while (X > k * (k + 1) / 2) {
            k++;
        }

        int indexInDiagonal = X - (k * (k - 1) / 2);
        int numerator, denominator;

        if (k % 2 == 1) { // 홀수 대각선 → 위에서 아래로 진행
            numerator = k - indexInDiagonal + 1;
            denominator = indexInDiagonal;
        } else { // 짝수 대각선 → 아래에서 위로 진행
            numerator = indexInDiagonal;
            denominator = k - indexInDiagonal + 1;
        }

        System.out.println(numerator + "/" + denominator);
    }
}