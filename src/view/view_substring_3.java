package view;

import java.util.Arrays;

public class view_substring_3 {

	public static void main(String[] args) {
		String s = "cycle";
		String ans[] = getCharArray(s);
		System.out.print(Arrays.toString(ans));
		
	}
	
	public static String[] getCharArray(String str){
		String ch[] = str.split("",2);
		return ch;
	}

}
