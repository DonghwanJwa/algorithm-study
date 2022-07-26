package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arrQuests = new String[num];
        for(int i=0;i<num;i++){
            arrQuests[i] = br.readLine();
        }
        br.close();

        for(int i=0;i<arrQuests.length;i++){
            String[] arrQuest = arrQuests[i].split(" ");
            double H = Double.parseDouble(arrQuest[0]);
            double W = Double.parseDouble(arrQuest[1]);
            double N = Double.parseDouble(arrQuest[2]);

            // 호 : N/W
            int number =(int)Math.ceil(N/H);    //1개의 호는 층수만큼 존재하므로, N을 H로 나눈 정수(올림) = 호수

            // 층
            int floor =  (int)(H- ((number * H) - N)) ; //호수 * 층수로 해당 소수까지의 방 수를 구하고, N번째 손님 방이 몇층에 있는지 역추적 한다.

            System.out.println(Integer.parseInt(floor + String.format("%02d",(int)number)));
        }
    }
}
