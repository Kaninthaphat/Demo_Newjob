package view;

import java.util.Scanner;

public class view_exchange {

	public static void main(String[] args) {
		
		int s;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter input: ");
		s = scan.nextInt();
		System.out.print("Ans: " +exchange(s));
	}

	public static int exchange(int s){
		int a = 3;
		int ans = 0;
		if(s >= 0 || s <= (10^9)){
			ans = s+(s/a);
		}
		return ans;
	}
	
}
