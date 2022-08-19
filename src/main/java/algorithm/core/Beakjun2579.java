package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun2579 {

    static Integer dp[];    //Memoization, int로 배열을 만들 경우 값을 0으로초기화 하므로 Integer로 선언함..null을 이용할것이므로
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());  //어디까지 ?

        dp = new Integer[num + 1];
        arr = new int[num + 1];

        for(int i=1;i<=num;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        //a층에서 다음으로 넘어갈때 a+1이 큰지 a+2가 큰지 판단
        //단, 3번 연속으로 계단밟기 불가
        //위 조건때문에 max 층으로부터 top-down 형태로 가야되지 않을까 ?

        //bottom - up
        //노가다
        //10 20 10 30 40 1

        //첫번째 칸 점수
        // 한번가서 10

        //두번째 칸 점수
        // 도약해서 20
        // 두번가서 10+20

        //세번째 칸 점수
        // 첫번째칸 최대점수(10) + 10
        // 두번째칸 최대점수(30) + 10

        //네번째 칸 점수
        // 두번째칸 최대점수(30) + 40
        // 세번째칸 최대점수(40) + 40

        //top-down
        // 최고점수 X라고 할때
        // 마지막 계단에 도달할때 비교할 점수 값은
        // 전전계단에서 연속 2번 밟아서 올라왔을때  vs 전전계단에서 2칸점프 했을때
        // 로 max값을 비교하면 될듯
        // 이 비교하는것을 재귀함수로 계속 호출해보자


        dp[0] = arr[0]; //index 0 은 0 처리
        dp[1] = arr[1]; //초기 비교를 위한 값 주입

        if(num >=2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(num));
    }

    static int find(int n) {
        //계산해본적 없는 경우의 수를 입력해준다.
        if(dp[n] == null){
            dp[n] = Math.max(find(n-2),find(n-3) + arr[n-1]) + arr[n];
        }

        return dp[n];
    }
}
