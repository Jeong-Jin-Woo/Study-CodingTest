import java.util.*;
class Stage implements Comparable<Stage>{
    int num;
    double failure;
    Stage(int num, double failure){
        this.num = num;
        this.failure = failure;
    }
    @Override
    public int compareTo(Stage other){
        if(failure == other.failure)
            return Integer.compare(this.num, other.num);
        return Double.compare(other.failure, this.failure);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Stage> s = new ArrayList<>();
        int num = stages.length;
        int d[] = new int[502];
        Arrays.sort(stages);

        for(int i=1; i<=stages.length; i++){
            d[stages[i-1]] += 1;
        }

        for(int i=1; i<=N; i++){
            if(num == 0)
                s.add(new Stage(i, 0));
            else{    
                s.add(new Stage(i, d[i]/Double.valueOf(num)));
                num -= d[i];
            }
        }
        Collections.sort(s);

//         for(int i=0; i<s.size(); i++)
//             System.out.println(s.get(i).num + " " + s.get(i).failure);


        for(int i=0; i<s.size(); i++)
            answer[i] = s.get(i).num;

        return answer;
    }
}
