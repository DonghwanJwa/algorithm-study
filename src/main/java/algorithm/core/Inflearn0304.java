package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inflearn0304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrVar = br.readLine().split(" ");
        String[] arrNums = br.readLine().split(" ");
        br.close();

        int num = Integer.parseInt(arrVar[0]);
        int expect = Integer.parseInt(arrVar[1]);

        int[] arrNumbers = new int[num];
        for (int i = 0; i < num; i++) {
            arrNumbers[i] = Integer.parseInt(arrNums[i]);
        }
        int result = 0;
        int idxS = 0;
        int idxE = 0;
        int sum = 0;

        while(idxE < num) {
            sum += arrNumbers[idxE++]; //End만큼 더해줌

            if(sum == expect) {
                result++;
            }

            while(sum>=expect) { //expect값 이상이면 Start만큼 빼준다.
                sum -= arrNumbers[idxS++];
                if(sum == expect) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
