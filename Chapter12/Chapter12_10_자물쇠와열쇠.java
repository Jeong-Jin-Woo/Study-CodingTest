import java.util.*;
class Solution {
    public int[][] rotate(int[][] key){
        int n = key.length;
        int m = key[0].length;
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n-1-i] = key[i][j];
            }
        }
        return result;
    }
    public boolean check(int[][] map){
        int len = map.length/3;
        for(int i=len; i<len*2; i++){
            for(int j=len; j<len*2; j++){
                if(map[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;
        int map[][] = new int[n*3][n*3];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i+n][j+n] = lock[i][j];
            }
        }
        
        for(int rotate=0; rotate<4; rotate++){
            key = rotate(key);
            for(int i=0; i<n*2; i++){
                for(int j=0; j<n*2; j++){
                    for(int x=0; x<m; x++){
                        for(int y=0; y<m; y++){
                           map[i+x][j+y] += key[x][y];
                        }
                    }
                    if(check(map))
                        return true;
                    for(int a=0; a<n; a++){
                        for(int b=0; b<n; b++){
                            map[a+n][b+n] = lock[a][b];
                        }
                    }
                }
            }
            
        }
        
        return answer;
    }
}