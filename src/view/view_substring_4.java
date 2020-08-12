package view;

import java.util.Arrays;

public class view_substring_4 {

	public static void main(String[] args) {
		String s = "abba";
		String ans[] = getCharArray(s);
		System.out.print(Arrays.toString(ans));
		
	}
	
	public static String[] getCharArray(String str){
		String ch[] = str.split("",2);
		return ch;
	}

}