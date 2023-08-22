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
        return stuff; //0이 기둥, 1이 보
    }
    @Override
    public int compareTo(Node other){
        if(x == other.x && y == other.y){
            return Integer.compare(stuff, other.stuff);
        }
        if(x == other.x){
            return Integer.compare(y, other.y);
        }
        return Integer.compare(x, other.x);
    }
}

class Solution {
    public boolean possible(ArrayList<ArrayList<Integer>> arr){
        for(int i=0; i<arr.size(); i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i).get(1);
            int stuff = arr.get(i).get(2);
            if(stuff == 0){
                //기둥
                boolean chk = false;
                for(int s=0; s<arr.size(); s++){
                    if(y == 0) chk = true;  
                    if(x==arr.get(s).get(0) && y-1 == arr.get(s).get(1) && 0 == arr.get(s).get(2)) chk = true;  
                    if(x-1==arr.get(s).get(0) && y == arr.get(s).get(1) && 1 == arr.get(s).get(2)) chk = true;  
                    if(x==arr.get(s).get(0) && y == arr.get(s).get(1) && 1 == arr.get(s).get(2)) chk = true;
                }
                if(!chk) return false;
            }
            else{
                //보
                boolean chk = false;
                boolean right = false;
                boolean left = false;
                for(int s=0; s<arr.size(); s++){
                    if(x==arr.get(s).get(0) && y-1 == arr.get(s).get(1) && 0 == arr.get(s).get(2)) chk = true;  
                    if(x+1==arr.get(s).get(0) && y-1 == arr.get(s).get(1) && 0 == arr.get(s).get(2)) chk = true;
                    if(x+1==arr.get(s).get(0) && y == arr.get(s).get(1) && 1 == arr.get(s).get(2)) right = true;  
                    if(x-1==arr.get(s).get(0) && y == arr.get(s).get(1) && 1 == arr.get(s).get(2)) left = true;  
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
            if(op == 1){
                //설치
                ArrayList<Integer> insert = new ArrayList<>();
                insert.add(x);
                insert.add(y);
                insert.add(stuff);
                arr.add(insert);
                if(!possible(arr)){
                    arr.remove(arr.size()-1);
                }
            }
            else{
                //제거
                int index = 0;
                for(int s=0; s<arr.size(); s++){
                    
                    if(arr.get(s).get(0) == x && arr.get(s).get(1) == y && arr.get(s).get(2) == stuff){
                        index = s;
                    }
                }
                ArrayList<Integer> remove = arr.get(index);
                arr.remove(index);
                if(!possible(arr)){
                    arr.add(remove);
                }
            }
        }
        ArrayList<Node> node = new ArrayList<>();
        for(int i=0; i<arr.size(); i++){
            node.add(new Node(arr.get(i).get(0), arr.get(i).get(1), arr.get(i).get(2)));
        }
        Collections.sort(node);
        
        int[][] answer = new int[node.size()][3];
        for(int i=0; i<node.size(); i++){
            answer[i][0] = node.get(i).getX();
            answer[i][1] = node.get(i).getY();
            answer[i][2] = node.get(i).getStuff();
        }
        return answer;
    }
}