package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());  //어디까지 ?
        br.close();

        //몇번째 태두리에 있느냐에 따라서 갯수 증가하는 패턴
        //숫자 N은 몇번째 태두리에 있는가 ? + 1 => 답
        //1번 태두리 6개         1
        //2번 태두리 12개        2
        //3번 태두리 18개 ...    3

        int t = 0;
        int n = 1;
        if(num > 1) {
            while (t < num - 1) {
                t += 6 * n;
                n++;
            }
            System.out.println(n);
        }else {
            System.out.println(1);
        }
    }
}
