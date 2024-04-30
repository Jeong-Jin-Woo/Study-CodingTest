class Solution {
    static int answer = (int)1e9;
    static boolean[] visit;
    static void dfs(int[] value, int d, int ir, int s, int count, int min){
        if((d==0 && ir==0 && s==0) || (count == value.length)){
            answer = Math.min(min, answer);
            // System.out.println("Return!");
            return;
        }
        if(!visit[count]){
            visit[count] = true;
            if(d > 0){
                int sum = 0;
                int csum = 0;
                for(int j=count; j<value.length && j<count+5; j++){
                    csum += 1;
                    sum += 1;
                }
                dfs(value, d-1,ir,s,csum + count, sum + min);
                // System.out.println("dia 실행");
            }
            if(ir > 0){
                int sum = 0;
                int csum = 0;
                for(int j=count; j<value.length && j<count+5; j++){
                    csum += 1;
                    if(value[j] == 25) sum += 5;
                    else sum += 1;
                }
                // System.out.println("iron 실행");
                // System.out.println(d + " " + ir + " " + s + " " + (csum+count) + " " + (sum+min));
                dfs(value, d,ir-1,s,csum + count, sum + min);
            }
            if(s > 0){
                int sum = 0;
                int csum = 0;
                for(int j=count; j<value.length && j<count+5; j++){
                    csum += 1;
                    sum += value[j];
                }
                // System.out.println("stone 실행");
                // System.out.println(d + " " + ir + " " + s + " " + (csum+count) + " " + (sum+min));
                dfs(value, d,ir,s-1,csum + count, sum + min);
            }
            visit[count] = false;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int n = picks.length;
        int m = minerals.length;
        int[] value = new int[m];
        visit = new boolean[m];
        for(int i=0; i<m; i++){
            if(minerals[i].equals("diamond")){
                value[i] = 25;
            }
            else if(minerals[i].equals("iron")){
                value[i] = 5;
            }
            else{
                value[i] = 1;
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            count += picks[i];
        }
        dfs(value, picks[0], picks[1], picks[2], 0, 0);
        return answer;
    }
}