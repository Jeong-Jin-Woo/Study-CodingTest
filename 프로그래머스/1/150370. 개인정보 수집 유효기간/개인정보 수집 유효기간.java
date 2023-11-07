import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<>();
        String todays[] = today.split("\\.");
        int t_y = Integer.valueOf(todays[0]);
        int t_m = Integer.valueOf(todays[1]);
        int t_d = Integer.valueOf(todays[2]);
        for(int i=0; i<terms.length; i++){
            String termss[] = terms[i].split(" "); 
            for(int j=0; j<privacies.length; j++){
                String pri[] = privacies[j].split(" ");
                if(pri[1].equals(termss[0])){
                    String p[] = pri[0].split("\\.");
                    int y = Integer.valueOf(p[0]);
                    int m = Integer.valueOf(p[1]);
                    int d = Integer.valueOf(p[2]);
                    m += Integer.valueOf(termss[1]);
                    while(m > 12){
                        m -= 12;
                        y += 1;
                    }
                    if((y<=t_y && m <=t_m && d <= t_d)||(y<t_y)||(y<=t_y&&m < t_m))
                        ans.add(j+1);
                }
            }
        }
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}