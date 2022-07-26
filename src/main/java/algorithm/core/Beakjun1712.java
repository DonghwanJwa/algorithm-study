package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrVars = br.readLine().split(" ");

        double A = Integer.parseInt(arrVars[0]);        //고정비용
        double B = Integer.parseInt(arrVars[1]);        //노트북 1대 생산비용
        double C = Integer.parseInt(arrVars[2]);        //노트북 1대 가격

        br.close();
        if(C<=B) {
            System.out.println(-1);
        }else {
            // A+B*N < C*N  (N = 대수)
            // A/(C-B) < N
            int n = (int) Math.floor(A / (C - B));
            System.out.println(n + 1);
        }
    }
}
