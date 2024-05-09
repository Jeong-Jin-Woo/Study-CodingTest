import java.util.*;
class Node implements Comparable<Node>{
    public int x, value;
    Node(int x, int value){
        this.x=x;
        this.value=value;
    }
    @Override
    public int compareTo(Node other){
        return Integer.compare(other.value, value);
    }
}
class Solution {
    public int solution(int k, int[] tangerine) {
        int n = tangerine.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }
            else{
                map.put(tangerine[i], 1);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i : map.keySet()){
            pq.offer(new Node(i, map.get(i)));
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int x = now.x;
            int value = now.value;
            k -= value;
            answer += 1;
            if(k <= 0){
                break;
            }
        }
        return answer;
    }
}