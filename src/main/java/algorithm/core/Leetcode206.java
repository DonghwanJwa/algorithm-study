package algorithm.core;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


//  Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode206 {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        ListNode head = null;
        int num = 5;
        while(num > 0){
            if(head == null){
                head = new ListNode(num);
            }else{
                head = new ListNode(num,head);
            }
            --num;
        }
        ListNode result = s.reverseList(head);
        ListNode next = result;
        while(true) {
            if(next == null) {
                break;
            }else if(next.next == null){
                System.out.println(next.val);
                break;
            }else{
                System.out.println(next.val);
            }
            next = next.next;
        }
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        //나하씩 빼내면서 Queue에 담는다.
        ListNode next = head;
        Queue<Integer> q = new LinkedList<>();
        while(true){
            if(next == null) {
                break;
            }else if(next.next == null) {
                q.add(next.val);
                break;
            }else{
                q.add(next.val);
            }
            next = next.next;
        }

        //Queue에서 하나씩 빼면서 ListNode에 담음
        ListNode result = null;
        while(!q.isEmpty()){
            if(result == null){
                result = new ListNode(q.poll());
            }else{
                result = new ListNode(q.poll(),result);
            }
        }

        return result;
    }
}