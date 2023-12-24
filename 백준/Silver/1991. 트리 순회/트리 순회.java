import java.util.*;

public class Main {
	static ArrayList<ArrayList<Character>> tree = new ArrayList<>();

	public static void preorder(ArrayList<ArrayList<Character>> tree, int n){
		System.out.print((char)(n+'A'));
		if(tree.get(n).get(0) != '.')
			preorder(tree, tree.get(n).get(0)-'A');
		if(tree.get(n).get(1) != '.')
			preorder(tree, tree.get(n).get(1)-'A');
	}
	public static void inorder(ArrayList<ArrayList<Character>> tree, int n){
		if(tree.get(n).get(0) != '.')
			inorder(tree, tree.get(n).get(0)-'A');
		System.out.print((char)(n+'A'));
		if(tree.get(n).get(1) != '.')
			inorder(tree, tree.get(n).get(1)-'A');
	}

	public static void postorder(ArrayList<ArrayList<Character>> tree, int n){
		if(tree.get(n).get(0) != '.')
			postorder(tree, tree.get(n).get(0)-'A');
		if(tree.get(n).get(1) != '.')
			postorder(tree, tree.get(n).get(1)-'A');
		System.out.print((char)(n+'A'));
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			char c = in.next().charAt(0);
			char l = in.next().charAt(0);
			char r = in.next().charAt(0);
			tree.get(c - 'A').add(l);
			tree.get(c - 'A').add(r);
		}
		preorder(tree, 0);
		System.out.println();
		inorder(tree, 0);
		System.out.println();
		postorder(tree, 0);
		System.out.println();
	}
}