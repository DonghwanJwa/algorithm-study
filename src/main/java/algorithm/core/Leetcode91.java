package algorithm.core;

import java.io.IOException;

public class Leetcode91 {
    public static void main(String[] args) throws IOException {
        //문자 자르기
        String q = "226";
        // 1 2 6 1 2
        // 12 6 1 2
        // 1 26 1 2
        // 1 2 6 12
        // 12 6 12
        // 1 26 12

        System.out.println(numDecodings(q));
    }

    static int numDecodings(String s) {
        //솔직히 잘 모르겠음.....
        //memoization 을 사용해야할줄 어떻게 알까...
        int[] dp = new int[s.length()+1];
        if(s.length() == 0) return 0;

        // 저번 2로나누냐 3으로나누냐 -1로하냐 때와 같음
        // ex) 1212 들어왔을 때
        // 1번째 숫자로부터 2번째 숫자를 읽을꺼냐 2번째+3번째를 조합해서 읽을꺼냐
        // 1 2 혹은 1 21

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;    //0이면 0xx밖에 안되니까! 가능한 단어조합 자체가 성립 불가

        for (int i = 2; i <= s.length() ; i++) {
            char cur = s.charAt(i-1);
            char pre = s.charAt(i-2);

            //1~9
            if(cur>='1' && cur<='9') dp[i]+=dp[i-1];    //1~9일때 이전 조합 가능성을 기본세팅으로

            //11~19 , 21 ~ 26
            if(pre == '1' || (pre == '2' && cur<='6')) dp[i] += dp[i-2];    //두자릿수가 가능할때는 이전전 조합 가능성을 가져옴
        }

        return dp[s.length()];
    }
}
