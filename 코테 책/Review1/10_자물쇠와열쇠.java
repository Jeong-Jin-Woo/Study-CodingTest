import java.util.*;
class Solution {
    public static int[][] rotate(int[][] key){
        int n = key.length;
        int m = key[0].length;
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n-i-1] = key[i][j];
            }
        }
        return result;
    }
    public static boolean check(int[][] map){
        int n = map.length/3;
        for(int i=n; i<n*2; i++){
            for(int j=n; j<n*2; j++){
                if(map[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;
        int[][] map = new int[n*3][n*3];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i+n][j+n] = lock[i][j];
            }
        }
        for(int rotate = 0; rotate<4; rotate++){
            key = rotate(key);
            for(int a=0; a<n*2; a++){
                for(int b=0; b<n*2; b++){
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            map[i+a][j+b] += key[i][j];
                        }
                    }
                    if(check(map)){
                        return true;
                    }
                    for(int i=0; i<n; i++){
                        for(int j=0; j<n; j++){
                            map[i+n][j+n] = lock[i][j];
                        }
                    }
                }
                
            }
        }
        return answer;
    }
}