import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        if (x>0 && y>0){
            res = 1;
        } else if (x<0 && y>0){
            res = 2;
        } else if (x<0 && y<0){
            res = 3;
        } else {
            res = 4;
        }
        System.out.println(res);
    }
}