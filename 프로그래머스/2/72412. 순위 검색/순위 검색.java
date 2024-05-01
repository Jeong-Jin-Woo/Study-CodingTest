import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static void dfs(String[] info, String str, int count){
        if(count == 4){
            int score = Integer.valueOf(info[count]);
            if(map.containsKey(str)){
                map.get(str).add(score);
            }else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(score);
                map.put(str, arr);
            }
            return;
        }
        dfs(info, str+"-", count+1);
        dfs(info, str+info[count], count+1);
    }
    static int search(String[] query){
        String str = query[0];
        if(!map.containsKey(str)) return 0;
        int target = Integer.valueOf(query[1]);
        ArrayList<Integer> score = map.get(str);
        int start = 0;
        int end = score.size();
        while(start < end){
            int mid = (start + end)/2;
            if(score.get(mid) >= target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return score.size() - start;
    }
    public int[] solution(String[] info, String[] query) {
        int m = query.length;
        for(int i=0; i<info.length; i++)
            dfs(info[i].split(" "), "", 0);
        for(String value : map.keySet()) {
            Collections.sort(map.get(value));
        }
        int[] answer = new int[m];
        for(int i=0; i<m; i++){
            answer[i] = search(query[i].replace(" and ", "").split(" "));
        }
        return answer;
    }
}