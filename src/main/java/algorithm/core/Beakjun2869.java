package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjun2869 {
    public static void main(String[] args) throws IOException {
        //Scanner를 사용하면 시간이 오래걸림.. 이걸 의심못한 나.. 화난다 ㅠㅠ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strVars = br.readLine();
        br.close();

        StringTokenizer tokenizer = new StringTokenizer(strVars, " ");
        double A = Double.parseDouble(tokenizer.nextToken());
        double B = Double.parseDouble(tokenizer.nextToken());
        double V = Double.parseDouble(tokenizer.nextToken());

        //A 낮에 올라감(m)
        //B 밤에 떨어짐(m)
        //V 높이(m)
        //B<A<V
        //몇일걸려?

        // V < A*D - B*(D-1) 일때 D의 최소 정수
        // -> (V-B)/(A-B) < D
        // (V-B)/(A-B)의 올림값

        System.out.println((int)Math.ceil((V-B)/(A-B)));
    }
}
