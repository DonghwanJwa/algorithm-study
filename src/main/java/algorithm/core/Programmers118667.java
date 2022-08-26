package algorithm.core;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers118667 {
    public static void main(String[] args) throws IOException {
//        int[] queue1 = {3,2,7,2};
//        int[] queue2 = {4,6,5,1};
//        int[] queue1 = {1,2,1,2};
//        int[] queue2 = {1,10,1,2};
        int[] queue1 = {1};
        int[] queue2 = {1};

        //각 큐의 값이 같게 만드는 작업의 최소 횟수 return

        System.out.println(solution(queue1,queue2));
    }

    static int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long lq1 = 0l;
        long lq2 = 0l;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int a : queue1) {
            lq1+=a;
            q1.add(a);
        }
        for(int b : queue2) {
            lq2+=b;
            q2.add(b);
        }

        long lqt = lq1+lq2;

        if(lqt%2==0) {    //짝수일때만 가능함
            while(lq1!=lq2 && count < queue1.length*4){
                if(lq1>lq2){
                    int tmp = q1.poll();
                    lq1-=tmp;
                    lq2+=tmp;
                    q2.add(tmp);
                    count++;
                }else{
                    int tmp = q2.poll();
                    lq2-=tmp;
                    lq1+=tmp;
                    q1.add(tmp);
                    count++;
                }
            }

            if(count == queue1.length*4) {
                return -1;
            }else{
                return count;
            }
        }else{
            return -1;
        }
    }
}
