import java.util.*;
class Stage implements Comparable<Stage>{
    int num;
    double fail;
    Stage(int num, double fail){
        this.num = num;
        this.fail = fail;
    }
    public int getNum(){
        return num;
    }
    public double getFail(){
        return fail;
    }
    @Override
    public int compareTo(Stage other){
        return Double.compare(other.fail, fail);
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int len = stages.length;
        ArrayList<Stage> arr = new ArrayList<>();
        
        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=0; j<stages.length; j++){
                if(i == stages[j])
                    cnt++;
            }
            if(len == 0){
                arr.add(new Stage(i, 0));
            }
            else{
                arr.add(new Stage(i, cnt/(double)len));
                len -= cnt;
            }
        }
        // int d[] = new int[502];
        // for(int i=0; i<len; i++){
        //     d[stages[i]] += 1;
        // }
        // for(int i=1; i<=N; i++){
        //     if(len == 0){
        //         arr.add(new Stage(i, 0));
        //     }
        //     else{
        //         arr.add(new Stage(i, d[i]/(double)len));
        //         len -= d[i];
        //     }
        // }
        Collections.sort(arr);
        int answer[] = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = arr.get(i).getNum();
        }
        return answer;
    }
}