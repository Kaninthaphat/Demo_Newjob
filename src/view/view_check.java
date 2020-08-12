package view;

import java.util.Scanner;

public class view_check {

	public static void main(String[] args) {

		String s;
		Scanner scan = new Scanner(System.in);
	    System.out.print("Enter input: ");
	    s = scan.nextLine();
		System.out.println("Ans: " +checkStr(s));		
    }
	
	public static String checkStr(String s){
		String a = "All Capital Letter";
		String b = "All Small Letter";
		String c = "Mix";
		String d = "Invalid Input";
		String upper_str = s.toUpperCase();
		String lower_str = s.toLowerCase();
		String ans = null;
		if(s.equals(null)){
			ans = d;
		}
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(!(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z')){
				ans = d;
			}
		}
		if(ans != d){
			if(s.equals(upper_str)){
				ans = a;
			}else if(s.equals(lower_str)){
				ans = b;
			}else{
				ans = c;
			}
		}
		return ans;
	}
}