import java.util.*;
public class Chapter14_26_ī�������ϱ� {
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
	// ��(Heap)�� �ʱ� ī�� ������ ��� ����
	for (int i = 0; i < n; i++) {
	    pq.offer(sc.nextInt());
	}

	// ��(Heap)�� ���Ұ� 1�� ���� ������
	while (pq.size() != 1) {
	    // ���� ���� 2���� ī�� ���� ������
	    int one = pq.poll();
	    int two = pq.poll();
	    // ī�� ������ ���ļ� �ٽ� ����
	    int summary = one + two;
	    result += summary;
	    pq.offer(summary);
	}

	System.out.println(result);

*/