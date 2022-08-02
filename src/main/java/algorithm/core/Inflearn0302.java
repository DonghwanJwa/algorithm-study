package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Inflearn0302 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int[] arrFirst = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int second = Integer.parseInt(br.readLine());
        int[] arrSecond = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(arrFirst);
        Arrays.sort(arrSecond);

        int idxF = 0;
        int idxS = 0;
        String result = "";

        //공통된것 쌓기
        while(idxF < first && idxS < second) {
            if (arrFirst[idxF] == arrSecond[idxS]) {
                result += arrFirst[idxF] + " ";
                ++idxF;
                ++idxS;
            } else if (arrFirst[idxF] < arrSecond[idxS]) {
                ++idxF;
            } else {
                ++idxS;
            }
        }//한쪽만 남으면 공통된것이 없다!

        System.out.println(result.substring(0,result.length()-1));
    }
}
