package view;

import java.util.Scanner;

public class view_check {

	public static void main(String[] args) {
		
		String s;
		Scanner scan = new Scanner(System.in);
	    System.out.println("Enter a character:");
	    s = scan.nextLine();
		System.out.println(stringWithPosition(s));		
    }
	
	public static String stringWithPosition(String s){
		String pos = "";
		for(int i = 0; i < s.length(); i++){
			pos += (i);
		}
		return String.format("%s\n%s", pos,s);
	}
}