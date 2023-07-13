import java.util.*;
class Student implements Comparable<Student>{
	int kScore;
	int eScore;
	int mScore;
	String name;
	
	Student(int k, int e, int m, String n){
		kScore = k;
		eScore = e;
		mScore = m;
		name = n;
	}
	
	@Override
	public int compareTo(Student other) {
		if(other.kScore == kScore && other.eScore == eScore && other.mScore==this.mScore)
			return this.name.compareTo(other.name);
		if(other.kScore == kScore && other.eScore == eScore)
			return Integer.compare(other.mScore, this.mScore);
		if(other.kScore == kScore)
			return Integer.compare(this.eScore, other.eScore);
		return Integer.compare(other.kScore, this.kScore);
	}
}
public class Chapter14_23_±¹¿µ¼ö {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Student> s = new ArrayList<Student>();
		
		for(int i=0; i<n; i++) {
			String name = in.next();
			int k = in.nextInt();
			int e = in.nextInt();
			int m = in.nextInt();
			s.add(new Student(k,e,m,name));
		}
		
		Collections.sort(s);
		
		for(int i=0; i<s.size(); i++)
			System.out.println(s.get(i).name);
		
	}
}