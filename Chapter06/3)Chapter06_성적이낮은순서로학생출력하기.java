import java.util.*;
class Student implements Comparable<Student>{
	private String name;
	private int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getStudentName() {
		return name;
	}
	public int getStudentScore() {
		return score;
	}
	
    // ���� ������ '������ ���� ����'
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
    
}
public class Chapter06_3_�����̳����������л�����ϱ� {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Student> studentData = new ArrayList<Student>();
		for(int i=0; i<n; i++) {
			String name = in.next();
			int score = in.nextInt();
			studentData.add(new Student(name, score));
		}
		Collections.sort(studentData);
		
		for(int i=0; i<n; i++)
			System.out.print(studentData.get(i).getStudentName()+ " ");
		
	}

}
