package view;

import java.util.Scanner;

public class view_check {

	public static void main(String[] args) {
		
		String s;
		Scanner scan = new Scanner(System.in);
	    System.out.println("Enter input:");
	    s = scan.nextLine();
		System.out.println(stringWithPosition(s));
    }
	
	public static String stringWithPosition(String s){
		
		String a = "All Capital Letter";
		String b = "All Small Letter";
		String c = "Mix";
		String d = "Invalid Input";
		String ans;
		String num;
		for(int i =0 ; i<s.length(); i++){
			char aa = s.charAt(i);
            if(Character.isDigit(aa)){
            	ans = d;
            }
		}
		String upperStr = s.toUpperCase();
		String lowerStr = s.toLowerCase();
		if(s.equals(upperStr)){
			ans = a;
		}else if(s.equals(lowerStr)){
			ans = b;
		}else{
			ans = c;
		}
		return ans;
	}
}