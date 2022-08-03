package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inflearn0405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrVar = br.readLine().split(" ");
        String[] arrNums = br.readLine().split(" ");
        br.close();

        int num = Integer.parseInt(arrVar[0]);
        int count = Integer.parseInt(arrVar[1]);

        int[] arrNumbers = new int[num];
        for (int i = 0; i < num; i++) {
            arrNumbers[i] = Integer.parseInt(arrNums[i]);
        }

        //3장합이 큰것
        //ArrayList에 3개 합한것 다 저장하고, sort시킴
        List<Integer> arrSum = new ArrayList<>();

        for(int i=0;i<num;i++){           //3번째장
            for(int j=i+1;j<num;j++){       //2번째장
                for(int k=j+1;k<num;k++) {  //1번째장
                    int tmp = arrNumbers[i] + arrNumbers[j] +  arrNumbers[k];
                    if(!arrSum.contains(tmp)){
                        arrSum.add(tmp);
                    }
                }
            }
        }
        arrSum.sort(Comparator.reverseOrder()); //오름차순 정렬

        if(arrSum.size() < count) {
            System.out.println(-1);
        }else {
            System.out.println(arrSum.get(count-1));
        }
    }
}
