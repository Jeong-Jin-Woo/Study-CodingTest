import java.util.*;
class Node implements Comparable<Node>{
    int x;
    int y;
    int stuff;
    Node(int x, int y, int stuff){
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getStuff(){
        return stuff;
    }
    public int compareTo(Node other){
        if(this.x == other.getX() && this.y == other.getY())
            return Integer.compare(this.stuff, other.getStuff());
        if(this.x == other.getX())
            return Integer.compare(this.y, other.getY());
        return Integer.compare(this.x,other.getX());
    }
}
class Solution {
    public boolean possible(ArrayList<ArrayList<Integer>> arr){
        for(int i=0; i<arr.size(); i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i).get(1);
            int stuff = arr.get(i).get(2);
            
            if(stuff == 0){//기둥
                boolean chk = false;
                for(int s=0; s<arr.size(); s++){
                    if(y==0) chk = true;
                    if(x==arr.get(s).get(0) && y-1==arr.get(s).get(1) && 0 ==arr.get(s).get(2)) chk = true;
                    if(x-1 == arr.get(s).get(0) && y==arr.get(s).get(1) && 1 == arr.get(s).get(2)) chk = true;
                    if(x==arr.get(s).get(0) && y == arr.get(s).get(1) && 1 == arr.get(s).get(2)) chk = true;
                }
                if(!chk) return false;
            }
            else if(stuff == 1){//보
                boolean chk = false;
                boolean left = false;
                boolean right = false;
                for(int s=0; s<arr.size(); s++){
                    if(x==arr.get(s).get(0) && y-1 ==arr.get(s).get(1)&&0 == arr.get(s).get(2)) chk = true;
                    if(x+1==arr.get(s).get(0) && y-1 == arr.get(s).get(1) && 0 == arr.get(s).get(2)) chk = true;
                    if(x-1 ==arr.get(s).get(0)&& y==arr.get(s).get(1) && 1 == arr.get(s).get(2)) left = true;
                    if(x+1 == arr.get(s).get(0) && y==arr.get(s).get(1) && 1 == arr.get(s).get(2)) right = true;
                }
                if(left && right) chk = true;
                if(!chk) return false;
            } 
        }
        return true;
    }
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int op = build_frame[i][3];
            
            if(op == 1){ //추가
                ArrayList<Integer> insert = new ArrayList<Integer>();
                insert.add(x);
                insert.add(y);
                insert.add(stuff);
                arr.add(insert);
                if(!possible(arr)){
                    arr.remove(arr.size()-1);
                }
            }
            if(op == 0){ //삭제
                int index=0;
                for(int s=0; s<arr.size(); s++){
                    if(x == arr.get(s).get(0) && y == arr.get(s).get(1) && stuff == arr.get(s).get(2))
                        index = s;
                }
                ArrayList<Integer> re = arr.get(index);
                arr.remove(index);
                if(!possible(arr)){
                    arr.add(re);
                }
            }
        }
        ArrayList<Node> node = new ArrayList<Node>();
        for(int i=0; i<arr.size(); i++){
            node.add(new Node(arr.get(i).get(0), arr.get(i).get(1), arr.get(i).get(2)));
        }
        Collections.sort(node);
        
        int[][] answer = new int[node.size()][3];
        for(int i=0; i<answer.length; i++){
            answer[i][0] = node.get(i).getX();
            answer[i][1] = node.get(i).getY();
            answer[i][2] = node.get(i).getStuff();
        }
        return answer;
    }
}