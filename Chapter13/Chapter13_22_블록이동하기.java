import java.util.*;
class Dron {
    int left_x;
    int left_y;
    int right_x;
    int right_y;
    int dist;
    Dron(int left_x, int left_y, int right_x, int right_y, int dist){
        this.left_x = left_x;
        this.left_y = left_y;
        this.right_x = right_x;
        this.right_y = right_y;
        this.dist = dist;
    }
    public int getLeftX(){
        return left_x;
    }
    public int getLeftY(){
        return left_y;
    }
    public int getRightX(){
        return right_x;
    }
    public int getRightY(){
        return right_y;
    }
    public int getDist(){
        return dist;
    }
}
class Solution {
    static int n;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    public static ArrayList<Dron> possibleMove(Dron now, int[][] map){
        ArrayList<Dron> dron = new ArrayList<>();
        for(int i=0; i<4; i++){
            int lx = dx[i] + now.getLeftX();
            int ly = dy[i] + now.getLeftY();
            int rx = dx[i] + now.getRightX();
            int ry = dy[i] + now.getRightY();
            if(map[lx][ly] == 0 && map[rx][ry]  == 0){
                dron.add(new Dron(lx,ly,rx,ry,now.getDist()+1));
            }
        }
        int hor[] = {-1, 1};
        if(now.getLeftX() == now.getRightX()){
            for(int i=0; i<hor.length; i++){
                if(map[now.getLeftX()+hor[i]][now.getLeftY()] == 0 && map[now.getRightX()+hor[i]][now.getRightY()] == 0){
                    dron.add(new Dron(now.getLeftX(), now.getLeftY(), now.getLeftX()+hor[i], now.getLeftY(), now.getDist()+1));
                    dron.add(new Dron(now.getRightX()+hor[i], now.getRightY(), now.getRightX(), now.getRightY(), now.getDist()+1));
                }
            }
        }
        int ver[] = {-1, 1};
        if(now.getLeftY() == now.getRightY()){
            for(int i=0; i<ver.length; i++){
                if(map[now.getLeftX()][now.getLeftY()+ver[i]] == 0 && map[now.getRightX()][now.getRightY()+ver[i]] == 0){
                    dron.add(new Dron(now.getLeftX(), now.getLeftY(), now.getLeftX(), now.getLeftY()+ver[i], now.getDist()+1));
                    dron.add(new Dron(now.getRightX(), now.getRightY(), now.getRightX(), now.getRightY()+ver[i] , now.getDist()+1));
                }
            }
        }
        return dron;
    }
    public int solution(int[][] board) {
        int n = board.length;
        int map[][] = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            for(int j=0; j<n+2; j++){
                map[i][j] = 1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i+1][j+1] = board[i][j];
            }
        }
        Queue<Dron> q =new LinkedList<>();
        ArrayList<Dron> visit = new ArrayList<>();
        q.offer(new Dron(1,1,1,2,0));
        visit.add(new Dron(1,1,1,2,0));
        while(!q.isEmpty()){
            Dron dron = q.poll();
            int lx = dron.getLeftX();
            int ly = dron.getLeftY();
            int rx = dron.getRightX();
            int ry = dron.getRightY();
            if((lx == n && ly == n )||(rx == n && ry == n)) return dron.getDist();
            
            ArrayList<Dron> pos = possibleMove(dron, map);
            for(int i=0; i<pos.size(); i++){
                boolean check = false;
                for(int j=0; j<visit.size(); j++){
                    if(visit.get(j).getLeftX() == pos.get(i).getLeftX() && 
                      visit.get(j).getLeftY() == pos.get(i).getLeftY() &&
                      visit.get(j).getRightX() == pos.get(i).getRightX() &&
                      visit.get(j).getRightY() == pos.get(i).getRightY() ){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    q.offer(pos.get(i));
                    visit.add(pos.get(i));
                }
            }
        }
        
        int answer = 0;
        return answer;
    }
}