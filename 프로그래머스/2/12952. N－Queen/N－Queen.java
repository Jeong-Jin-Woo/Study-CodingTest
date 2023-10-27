class Solution {
    static int[] map;
    static int answer = 0;
    static void dfs(int n, int count){
        if(n == count){
            answer += 1;
            return;
        }
        for(int i=0; i<n; i++){ 
            map[count] = i;
            if(possible(count)){
                dfs(n, count+1);
            }
        }
    }
    static boolean possible(int count){
        for(int i=0; i<count; i++){
            if(map[i] == map[count]) return false;
            if(Math.abs(map[i] - map[count]) == Math.abs(i - count)){
                return false;
            }
        }
        return true;
    }
    public int solution(int n) {
        map = new int[n];
        dfs(n, 0);
        return answer;
    }
}