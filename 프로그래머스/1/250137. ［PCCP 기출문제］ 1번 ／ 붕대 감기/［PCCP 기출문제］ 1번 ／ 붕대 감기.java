import java.util.*;
class Node {
    public int time;
    public int damage;
    Node(int time, int damage){
        this.time=time;
        this.damage=damage;
    }
}
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Queue<Node> node = new LinkedList<>();
        for(int i=0; i<attacks.length; i++){
            node.offer(new Node(attacks[i][0],attacks[i][1]));
        }
        int stage = 0;
        int cont = 0;
        int max = health;
        while(!node.isEmpty()){
            stage += 1;
            if(node.peek().time == stage){
                cont = 0;
                Node now = node.poll();
                health -= now.damage;
                if (health <= 0){
                    health = -1;
                    break;
                }
            }
            else{
                cont += 1;
                if(cont == bandage[0]){
                    health += bandage[2];
                    cont = 0;
                }
                health += bandage[1];
                if(health >= max) health = max;
            }
        }
        return health;
    }
}