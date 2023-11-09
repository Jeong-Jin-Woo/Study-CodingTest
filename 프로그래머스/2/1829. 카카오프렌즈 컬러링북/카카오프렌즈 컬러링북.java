class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int M, N;
    static int[][] map;
    static int count;
    static boolean dfs(int x, int y, int v){
        if(x < 0 || y < 0 || x >= N || y >= M){
            return false;
        }
        if(map[x][y] == v){
            map[x][y] = 0;
            count += 1;
            dfs(x-1,y,v);
            dfs(x+1,y,v);
            dfs(x,y-1,v);
            dfs(x,y+1,v);
            return true;
        }
        return false;
    }
    public int[] solution(int m, int n, int[][] picture) {
        N=m;M=n;
        count=0;
    numberOfArea=0;
    maxSizeOfOneArea=0;
        map = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = picture[i][j];
            }
        }
        for(int i=0;i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    count = 0;
                    if(dfs(i, j, map[i][j])){
                        numberOfArea += 1;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
