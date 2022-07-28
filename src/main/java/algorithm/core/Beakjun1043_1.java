package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun1043_1 {
    static int[] uf;
    static int[] know;

    public static int find(int x) {
        if(x == uf[x]){
            return x;
        }else{
            return uf[x] = find(uf[x]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) {
            uf[a] = b;
        }else {
            uf[b] = a;
        }
    }

    public static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);        //사람수
        int M = Integer.parseInt(first[1]);        //파티수

        //인원정보, union-find 배열 초기화
        uf = new int[N+1];
        for(int i=1;i<=N;i++) {
            uf[i] = i;
        }

        //진실아는친구 Grouping
        know = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        if(know[0] == 0) {
            for(int m=0;m<M;m++){
                br.readLine();
            }
            System.out.println(M);  //나는야허풍왕!
            System.exit(0);   //종료시켜줘야함..
        }else{
            //진실의방으로
            for(int m=1;m<know[0];m++){
                int p1 = know[m];
                int p2 = know[m+1];
                union(p1, p2);
            }
        }

        //파티정보
        int[] partyGroup = new int[M];
        for(int g=0;g<M;g++){
            int[] infos = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            int num = infos[0];
            int p1 = 0;
            int p2 = 0;
            if(num == 1){
                p1 = infos[1];  //파티에 1명참여하므로 대표그룹 번호 그 자체로 사용
            }else {
                //진실의방으로 2 feat.너그거알아?
                for (int n = 1; n < num; n++) {
                    p1 = infos[n];      //파티참여자 중 그룹대표 1명
                    p2 = infos[n + 1];
                    union(p1, p2);
                }
            }
            partyGroup[g] = p1;
        }
        br.close();

        //허황파티수?
        int lie = 0;
        for(int m=0;m<M;m++) {
            if(!isSameParent(partyGroup[m],know[1])){    //진실을아는번호 1개와 파티 대표그룹번호 1개를 비교
                 lie++;
            }
        }
        System.out.println(lie);
    }
}
