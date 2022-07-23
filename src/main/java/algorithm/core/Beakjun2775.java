package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            //k층n호 인원수 = (k-1)층 n(n-1)호 인원수
            //단 0층은 1 2 3 4 5 인원으로 증가됨(호수수만큼)
            //k : 층수
            //n : 호수

            //4층 : 1  6  21 56 126
            //3층 : 1  5  15 35 70 126                                           4 10 20 35 56
            //2층 : 1  4  10 20 35 56 84 120 165 220 286 364 455 560             3 6  10 15 21
            //1층 : 1  3  6  10 15 21 28 36  45  55  66  78  91  105             2 3  4  5  6
            //0층 : 1  2  3  4  5  6  7  8   9   10  11  12  13  14              1 1  1  1  1

            //0층 n호 = 1~n까지 합
            //k층 n호 = (k-1)층n호 + k층(n-1)호
            //1 <= k, n <= 14
            int[][] arrMembers = new int[15][14];   //k층n호 인원 배열
            //1. 0층 전체 입력, 1호 입력
            for(int j=0;j<=13;j++){
                arrMembers[0][j] = j+1;
            }
            for(int j=0;j<=14;j++) {
                arrMembers[j][0] = 1;
            }

            //2. 1층부터 k층 n호 = (k-1)층n호 + k층(n-1)호 로직 입력해주기
            for(int c=1;c<=k;c++) { //층(c) : 1층부터 k층까지 (index : 0 = 0층)
                for(int h=1;h<=n-1;h++){ //호(h) : 2호부터 n호까지 (index : 0 = 1호)
                    arrMembers[c][h] = arrMembers[c-1][h] +  arrMembers[c][h-1];
                }
            }
            System.out.println(arrMembers[k][n-1]);
        }
        br.close();
    }
}
