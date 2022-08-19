package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        br.close();

        //X가 3으로 나누어 떨어지면, 3으로 나눈다.
        //X가 2로 나누어 떨어지면, 2로 나눈다.
        //1을 뺀다.

        //3으로 나눠져 ? 2로나눠져 ? 3과 2모두 나눠져?, 아무것도 안나눠져? 로나눠야될듯
        //근데 이걸 계속 반복해야됨.. 모든가능성을 체크하며 내값을 찾아가자
        //bottom-up을 이용

        //연산에 대한 결과값을 Memoization할 배열
        int[] memo = new int[num+1];

        //노가다로 해보자
        //값 0번과 1번은 연산자체가 필요없으므로 0으로 강제입력
        memo[0] = 0;
        memo[1] = 0;

        //2가 들어왔을 때
        // -1할때 2-1 = 1 -> 횟수가 1임
        // /2할때 2/2 = 1 -> 횟수가 1임
        // /3할때 나누기 불가
        // d[2] = d[2-1] + 1;
        // if(2 % 2 == 0) memo[2] = Math.min(memo[2],memo[2/2]+1);

        //3이 들어왔을 때
        // -1할때 3-1 = 2 , 2가 들어왔을때의 횟수 + 1이됨
        // /2할때 나누기 불가
        // /3할때 3/3 = 1 -> 횟수가 1임
        // d[3] = d[3-1]+1;
        // if(3 % 3 == 0) memo[3] = Math.min(memo[3],memo[3/3]+1);

        //4가 들어왔을 때
        // -1할때 4-1 = 3, 3이 들어왔을때의 횟수 + 1
        // /2할때 4/2 = 2, 2로 들어왔을때 횟수 + 1이됨
        // /3할때 나누기 불가
        
        //결론 : 2 혹은 3으로 나눠지면 전단계 횟수 + 1이됨

       //반복하는데
        for(int i=2;i<=num;i++){
            memo[i] = memo[i-1] + 1;
            if(i % 2 == 0) memo[i] = Math.min(memo[i],memo[i/2]+1);
            if(i % 3 == 0) memo[i] = Math.min(memo[i],memo[i/3]+1);
        }
        System.out.println(memo[num]);
    }
}
