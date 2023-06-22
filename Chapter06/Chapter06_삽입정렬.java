import java.util.*;
public class Chapter06_»ğÀÔÁ¤·Ä {
	public static void main(String[] args) {
		int[] card = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		//»ğÀÔÁ¤·Ä
		for(int i=0; i<card.length; i++) {
			for(int j=i; j>0; j--) {
				if(card[j-1] > card[j]) {
					int tmp = card[j-1];
					card[j-1] = card[j];
					card[j] = tmp;
				}
			}	
		}
		for(int i=0; i<card.length; i++)
			System.out.print(card[i] + " ");
	}

}