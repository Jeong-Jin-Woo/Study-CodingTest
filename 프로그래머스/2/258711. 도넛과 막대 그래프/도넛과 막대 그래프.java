import java.util.*;
class Solution {
    static int n;
    static int[] answer = new int[4];
    static ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    static int[] income;
    static boolean[] visit;
    static boolean[] except;
    public int[] solution(int[][] edges) {
        for(int i=0; i<edges.length; i++)
            n = Math.max(n, Math.max(edges[i][0], edges[i][1]));
        for(int i=0; i<=n; i++){
            node.add(new ArrayList<>());
        }
        income = new int[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<edges.length; i++){
            node.get(edges[i][0]).add(edges[i][1]);
            income[edges[i][1]] += 1;
        }
        except = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(node.get(i).isEmpty() && income[i] == 0) except[i] = true;
        }
        answer[0] = findVertex();
        int totalShape = node.get(answer[0]).size();
        //시작노드의 간선 없애기
        for(int i=0; i<node.get(answer[0]).size(); i++){
            income[node.get(answer[0]).get(i)] -= 1;
        }
        node.set(answer[0], new ArrayList<>());
        //8자
        answer[3] = eightShape();
        //막대
        answer[2] = barShape(answer[0]);
        //도넛
        answer[1] = totalShape - answer[2] - answer[3];
        return answer;
    }
    static int barShape(int start){
        int count = 0;
        for(int i=1; i<node.size(); i++){
            if(start == i || except[i]) continue;
            if(node.get(i).size() == 0){
                visit[i] =true;
                count+=1;
            }
        }
        return count;
    }
    static int eightShape(){
        int count = 0;
        for(int i=1; i<node.size(); i++){
            if(!visit[i] && income[i] == 2 && node.get(i).size() == 2){
                visit[i] = true;
                count += 1;
            }
        }
        return count;
    }
    static int findVertex() {
        int vertex = 0;
        for(int i=1; i<node.size(); i++){
            if(node.get(i).size() >= 2 && income[i] == 0){
                vertex = i;
                break;
            }
        }
        visit[vertex] = true;
        return vertex;
    }
}