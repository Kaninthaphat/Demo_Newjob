package view;

import java.util.Arrays;

public class view_substring_4 {

	public static void main(String[] args) {
		
		String s = "abba";
		String ans[] = getCharArray(s);
		System.out.print(Arrays.toString(ans));
		
	}
	
	public static String[] getCharArray(String s){
		String strArr[] = new String[2];
		strArr[0] = s.substring(0,2);
		strArr[1] = s.substring(2,s.length());
		return strArr;
	}

}