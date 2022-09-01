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
        long lq1 = 0l;  //queue1 의 총합
        long lq2 = 0l;  //queue2 의 총합
        Queue<Integer> q1 = new LinkedList<>(); //Array to Queue
        Queue<Integer> q2 = new LinkedList<>();
        for(int a : queue1) {
            lq1+=a;
            q1.add(a);
        }
        for(int b : queue2) {
            lq2+=b;
            q2.add(b);
        }

        long lqt = lq1+lq2; //total

        if(lqt%2==0) {    //총 합이 짝수일때만 가능함
            while(lq1!=lq2 && count < queue1.length*3){
                //queue끼리의 총합이 같거나, 움직인횟수가 총 길이의 3배가 넘어가면 멈춤
                // -> 3배가 넘어가면 멈추는 이유, 반복문으로 움직일때 길이의 3배만큼 움직이면 처음과 동일해지므로
                //    더이상 계산할 필요가 없기 때문 = 불가능
                if(lq1>lq2){    //합이큰 queue에서 합이 작은 queue로 값을 이동
                    int tmp = q1.poll();    //1. 합이 큰곳에서 숫자 하나를 뺀다음(queue1)
                    lq1-=tmp;               //2. queue1의 총합에서 빼고
                    lq2+=tmp;               //3. queue2의 총합에서 더한다
                    q2.add(tmp);            //4. 합이 작은곳에 숫자를 추가한다(queue2)
                    count++;                //5. 움직임을 하나 추가한다.
                }else{
                    int tmp = q2.poll();    //위와 동일함
                    lq2-=tmp;
                    lq1+=tmp;
                    q1.add(tmp);
                    count++;
                }
            }

            if(count == queue1.length*3) {  //길이의 3배 넘어가면 불가능처리
                return -1;
            }else{
                return count;
            }
        }else{  //홀수일때는 해당 로직 사용 불가
            return -1;
        }
    }
}
