import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        int n = A.length;
        PriorityQueue<Integer> Apq = new PriorityQueue<>();
        PriorityQueue<Integer> Bpq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            Apq.offer(A[i]);
            Bpq.offer(B[i]);
        }
        while(!Apq.isEmpty()){
            int a = Apq.poll();
            int b = Bpq.poll();
            answer += a*b;
        }
        return answer;
    }
}