package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Inflearn0301 {
    public static void main(String[] args) throws IOException {
        //출제자가 원하는 방식이 아닌것.... 다시 풀어보자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int[] arrFirst = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int second = Integer.parseInt(br.readLine());
        int[] arrSecond = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        br.close();

        List<Integer> arrSum = new ArrayList<>();

        for(int i=0;i<first;i++) {
            arrSum.add(arrFirst[i]);
        }

        for(int i=0;i<second;i++) {
            arrSum.add(arrSecond[i]);
        }
        arrSum.sort(Comparator.naturalOrder());
        String result = "";
        for(int num : arrSum){
            result += Integer.toString(num) + " ";
        }
        System.out.println(result.substring(0,result.length()-1));
    }
}
