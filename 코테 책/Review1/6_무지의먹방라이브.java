import java.util.*;
class Food implements Comparable<Food>{
    int index;
    int num;
    Food(int index, int num){
        this.index = index;
        this.num = num;
    }
    public int getIndex(){
        return index;
    }
    public int getNum(){
        return num;
    }
    @Override
    public int compareTo(Food other){
        return Integer.compare(this.num, other.num);
    }
}
class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for(int i=0; i<food_times.length; i++){
            sum += food_times[i];
        }
        if(sum <= k) return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for(int i=0; i<food_times.length; i++)
            pq.offer(new Food(i+1, food_times[i]));
        
        long summary = 0;
        long privious = 0;
        long len = food_times.length;
        while(summary + ((pq.peek().getNum() - privious) * len) <= k){
            int now = pq.poll().getNum();
            summary += (now - privious) * len;
            len -= 1;
            privious = now;
        }
        
        ArrayList<Food> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }
        Collections.sort(answer, new Comparator<Food>(){
           @Override
            public int compare(Food one, Food two){
                return Integer.compare(one.index, two.index);
            }
        });
        
        return answer.get((int)((k-summary) % len)).getIndex();
    }
}