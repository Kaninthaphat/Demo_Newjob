package view;

import java.util.Scanner;

public class view_cal {

	public static int readInt(Scanner sc) {
        System.out.print("x : ");
        int x = sc.nextInt();
        return x;
        
	}
	
	public static int Calculate(int x){ 
		int a = 5832;
        int ans = 0;
        for(int i = 0; i<x; i++){
        	ans = a/3;
        	a = a-ans;
        }
        return ans;
    }
	
	public static void main(String[]agrgs){
		Scanner sc = new Scanner(System.in);
		 int x = readInt(sc);
		 int y;
		 y = Calculate(x);
		 System.out.print("y : "+y);
	}
	
}
