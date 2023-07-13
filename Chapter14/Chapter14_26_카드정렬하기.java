import java.util.*;
public class Chapter14_26_카드정렬하기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			arr.add(a);
		}
		
		Collections.sort(arr);
		
		int answer = 0;
		int answer2 = 0;
		for(int i=1; i<arr.size(); i++) {
			answer += arr.get(i-1); 
			answer2 += answer + arr.get(i);
		}
		System.out.println(answer2);
	}
}
/*

    public static int n, result;
		Scanner sc = new Scanner(System.in);
	n = sc.nextInt();

	PriorityQueue<Integer> pq = new PriorityQueue<>();
	// 힙(Heap)에 초기 카드 묶음을 모두 삽입
	for (int i = 0; i < n; i++) {
	    pq.offer(sc.nextInt());
	}

	// 힙(Heap)에 원소가 1개 남을 때까지
	while (pq.size() != 1) {
	    // 가장 작은 2개의 카드 묶음 꺼내기
	    int one = pq.poll();
	    int two = pq.poll();
	    // 카드 묶음을 합쳐서 다시 삽입
	    int summary = one + two;
	    result += summary;
	    pq.offer(summary);
	}

	System.out.println(result);

*/