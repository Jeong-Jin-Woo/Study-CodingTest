import java.util.*;
class Node implements Comparable<Node>{
    String name;
    int hour;
    int minute;
    int last;
    Node(String name, int hour, int minute, int last){
        this.name=name;
        this.hour=hour;
        this.minute=minute;
        this.last=last;
    }
    @Override
    public int compareTo(Node other){
        if(hour == other.hour){
            return Integer.compare(minute, other.minute);
        }
        return Integer.compare(hour, other.hour);
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        ArrayList<Node> node = new ArrayList<>();
        for(int i=0; i<n; i++){
            String split[] = plans[i][1].split(":");
            node.add(new Node(plans[i][0], Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(plans[i][2])));
        }
        Collections.sort(node);
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.offer(node.get(i));
        }
        Stack<Node> st = new Stack<>();
        int time = 0;
        int count = 0;
        String[] answer = new String[n];
        while(count != n){
            int hour = time/60;
            int minute = time%60;
            if(!q.isEmpty()){
                if(hour == q.peek().hour && minute == q.peek().minute){
                    st.push(q.poll());
                }
            }
            if(!st.isEmpty()){
                Node now = st.pop();
                if(now.last - 1 <= 0){
                    answer[count] = now.name;
                    count += 1;
                }
                else{
                    st.push(new Node(now.name, now.hour, now.minute, now.last - 1));
                }
            }
            time += 1;
        }
        return answer;
    }
}