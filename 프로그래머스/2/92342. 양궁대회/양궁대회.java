import java.util.*;
class Solution {
    static int[] answer;
    static int[] lion = new int[11];
    static int max = 0;
    static void dfs(int n, int[] info, int count){
        if(count == n){
            int diff = compare(info);
            if(max <= diff){
                max = diff;
                answer = lion.clone();
            }
            return;
        }
        for(int i=0; i<11 && lion[i] <= info[i]; i++){
            lion[i] += 1;
            dfs(n,info,count+1);
            lion[i] -= 1;
        }
    }
    static int compare(int[] info){
        int l = 0;
        int a = 0;
        for(int i=0; i<11; i++){
            if(info[i] == 0 && lion[i] == 0){
                continue;
            }
            if(info[i] < lion[i]){
                l += 10-i;
            }
            else{
                a += 10-i;
            }
        }
        return l-a;
    }
    public int[] solution(int n, int[] info) {
        dfs(n, info, 0);
        if(max <= 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        return answer;
    }
}