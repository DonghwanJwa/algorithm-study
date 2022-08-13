package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrVar = br.readLine().split(" ");  //10의 10000승 2개
        br.close();

        String f = arrVar[0];
        String s = arrVar[1];
        String result = "";
        int t = f.length()<s.length() ? s.length() : f.length();    //둘중에 뭐가 더 길지 모르므로..
        //double까지도 담을 수 없는 수...
        //String 상태로 잘라서 더한다.
        // array index와 자릿수가 안맞을 수 있음
        // ex) 1 100 수가 들어왔을때 index 0 = 1 과 1이 되버림.. 뒤집어야한다
        String rf = new StringBuffer(f).reverse().toString();
        String rs = new StringBuffer(s).reverse().toString();

        boolean b = false; //합이 10이 넘어가면 다음자리수에 +1
        for (int i = 0; i < t ; i++) {
            int fn = f.length() > i ? Integer.parseInt(rf.substring(i,i+1)) : 0;
            int sn = s.length() > i ? Integer.parseInt(rs.substring(i,i+1)) : 0;
            int p =  b ? fn + sn + 1 : fn + sn;
            b = p >= 10;
            if(p>0){
                if(i == t-1){
                    result = p + result;
                }else{
                    result = p%10 + result;
                }
            }else{
                result = "0" + result;
            }
        }
        System.out.println(result);
    }
}
