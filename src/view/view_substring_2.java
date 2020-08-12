package view;

import java.util.Arrays;

public class view_substring_2 {

	public static void main(String[] args) {
		String s = "dddd";
		char ans[] = getCharArray(s);
		System.out.print(Arrays.toString(ans));
		
	}
	
	public static char[] getCharArray(String str){
		char ch[] = str.toCharArray();
		return ch;
	}
}