package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Inflearn0301_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int[] arrFirst = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int second = Integer.parseInt(br.readLine());
        int[] arrSecond = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        br.close();

        int tot = first + second;
        int idxF = 0;
        int idxS = 0;
        String result = "";

        //차곡차곡 쌓기
        while(idxF < first && idxS < second) {
            if(arrFirst[idxF] <= arrSecond[idxS]) {
                result += arrFirst[idxF] + " ";
                ++idxF;
            }else {
                result += arrSecond[idxS] + " ";
                ++idxS;
            }
        }

        //쌓다가 남은 한쪽 배열값을 다 넣어준다.
        while(idxF < first) {
            result += arrFirst[idxF] + " ";
            ++idxF;
        }

        while(idxS < second) {
            result += arrSecond[idxS] + " ";
            ++idxS;
        }

        System.out.println(result.substring(0,result.length()-1));
    }
}
