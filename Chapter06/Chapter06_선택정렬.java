import java.util.*;
public class Chapter06_선택정렬 {
	public static void main(String[] args) {
		int[] card = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		for(int i=0; i<card.length; i++) {
			int index = i;
			for(int j=i+1; j<card.length; j++) {
				if(card[index] > card[j]) {
					index = j;
				}
			}
			int tmp = card[index];
			card[index] = card[i];
			card[i] = tmp;
		}
		for(int i=0; i<card.length; i++)
			System.out.print(card[i] + " ");
	}

}
/*
bubble sort
		int[] card = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		for(int i=0; i<card.length; i++) {
			for(int j=i+1; j<card.length; j++) {
				if(card[i] > card[j]) {
					int tmp = card[j];
					card[j] = card[i];
					card[i] = tmp;
				}
			}
		}
		for(int i=0; i<card.length; i++)
			System.out.print(card[i] + " ");
*/