package algorithm.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);        //사람수
        int M = Integer.parseInt(first[1]);        //파티수

        //인원정보
        HashMap<Integer,Boolean> member = new HashMap<>();  //전체인원정보 <인원번호, 진실여부>
        for(int i=1;i<=N;i++) {
            member.put(i,false);
        }

        //진실아는친구 구분
        String[] know = br.readLine().split(" ");
        int num = Integer.parseInt(know[0]);        //사람수
        if(num != 0) {
            for (int j = 1; j <= num; j++) {
                member.put(Integer.parseInt(know[j]), true);
            }
        }

        //파티정보
        List<Party> arrParty = new ArrayList<>();
        for(int k=1;k<=M;k++){
            int[] partyInfo = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            arrParty.add(new Party(partyInfo));
        }
        br.close();

        int numOfLie = 0;
        if(arrParty.size() > 0) {
            arrParty.sort(Comparator.reverseOrder());
            for (int m = 0; m < arrParty.size(); m++) {
                int[] list = arrParty.get(m).getList();
                boolean truth = false;
                for (int n = 1; n < list.length; n++) { 
                    if (member.get(list[n])) {//파티참여자중에 한명이라도 진실을 아는자가있으면
                        truth = true;
                        break;
                    }
                }
                if (truth) {
                    for (int n = 1; n < list.length; n++) {
                        member.put(list[n], true);  //그파티 참여자는 모두진실을 알게되버림
                    }
                } else {
                    numOfLie++;
                }
            }
        }
        System.out.println(numOfLie);
    }
}

class Party implements Comparable<Party> {
    private String tot;
    private int[] list;

    public Party(int[] info) {
        this.tot = Integer.toString(info[0]);
        this.list = info;
    }

    @Override
    public int compareTo(Party party) {
        return this.tot.compareTo(party.tot);
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }
}
