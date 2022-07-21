package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        // N = A*3 + B*5
        // A는 최소
        // EX ) 11 = 2 * 3 + 1 * 5 : 3봉
        //    ) 18 = 1 * 3 + 3 * 5 : 4봉

        int T = N;  //TOTAL 에서 봉지를 깍아내리는 방식
        int A = 0;  //3KG
        int B = 0;  //5KG
        while(0<T){
            if(T%5 == 0){
                B = T/5;
                break;
            }
            T -= 3;
            A++;
        }

        if(T<0){
            System.out.println(-1);
        }else{
            System.out.println(A+B);
        }

    }
}
