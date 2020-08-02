package view;

import java.util.Scanner;

public class view_pyramid {

	public static int getNum(Scanner a) {
		System.out.print("Number is : ");
		int num = a.nextInt();
		return num;
	}
	
	public static void main(String[]agres){
		Scanner a = new Scanner(System.in);
		int count = getNum(a);
		for(int i = 0; i<count; i++){
			for(int j = 0; j< (count-i-1); j++){
				System.out.print(" ");
			}
			for(int k = 0; k< ((2*i)+1); k++){ 
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
}
