package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Inflearn0303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrVar = br.readLine().split(" ");
        int[] arrSales = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        br.close();
        int days = Integer.parseInt(arrVar[0]);
        int gap = Integer.parseInt(arrVar[1]);

        int idxStart = 0;
        int idxEnd = 0 + gap -1;

        int sum = 0;
        //초기 sum
        for(int i=0;i<=idxEnd;i++){
            sum += arrSales[i];
        }
        int max = sum;

        //하루 지나면 전날 매출 빼고, 다음날 매출 더하기
        while(idxEnd < days - 1){
            sum -= arrSales[idxStart];
            sum += arrSales[idxEnd+1];
            if(max < sum){
                max = sum;
            }
            idxStart++;
            idxEnd++;
        }

        System.out.println(max);
    }
}
