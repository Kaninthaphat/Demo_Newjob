package view;

import java.util.Scanner;

public class view_pyramid3 {

	public static int getNum(Scanner a) {
		System.out.print("Number is : ");
		int num = a.nextInt();
		return num;
	}
	
	public static void main(String[]agres){
		Scanner a = new Scanner(System.in);
		int count = getNum(a);
		for(int i = 0; i<count; i++){
			for(int j = 0; j<i; j++){
				System.out.print(" ");
			}
			for(int k = 0; k< (count*2-i); k++){ 
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println();
	}
}