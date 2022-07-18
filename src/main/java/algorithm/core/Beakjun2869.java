package algorithm.core;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Beakjun2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Date().toString());
//        String result = "";
        String strVars  = sc.nextLine();
//        String[] arrVars = strVars.split(" ");
        StringTokenizer tokenizer = new StringTokenizer(strVars, " ");
//        double A = Double.parseDouble(arrVars[0]);
//        double B = Double.parseDouble(arrVars[1]);
//        double V = Double.parseDouble(arrVars[2]);
        double A = Double.parseDouble(tokenizer.nextToken());
        double B = Double.parseDouble(tokenizer.nextToken());
        double V = Double.parseDouble(tokenizer.nextToken());

        //A 낮에 올라감(m)
        //B 밤에 떨어짐(m)
        //V 높이(m)
        //B<A<V
        //몇일걸려?

        //낮밤이 같다는 전재하에 문제 진행하겠음.
        // D : 일수
        // H : 실시간 현재 높이(m)

//        int D = 0;
//        int H = 0;

        //첫번째 시도.. TIMEOUT
//        while(true){
//            D++;    //하루시작
//            H += A; //A만큼 올라감
//            if(V<=H){    //꼭대기보다 많이올라갔나 ?
//                break;
//            }else {
//                H -= B; //B만큼 내려감
//            }
//        }

        //두번째 시도.. 함수로 만들어 버린다... TIMEOUT
        // V < A*D - B*(D-1) 일때 D의 최소 정수
        // -> (V-B)/(A-B) < D
        // (V-B)/(A-B)의 올림값
//        D = (int)Math.ceil((V-B)/(A-B));
//        System.out.println(D);

        //세번째 시도.. Meth 사용하지 않기
//        double d = ((V-B)/(A-B)) + 0.5;
        System.out.println((int)(((V-B)/(A-B)) + 0.5));
        System.out.println(new Date().toString());
    }
}
