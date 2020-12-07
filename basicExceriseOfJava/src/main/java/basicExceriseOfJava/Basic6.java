package basicExceriseOfJava;

import java.util.Scanner;

public class Basic6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액: ");
		int num = scanner.nextInt();
		
		int[] arr1 = {50000,10000,5000,1000,500,100,50,10,5,1};
		
		for(int i = 0 ; i <  arr1.length ; i++) {
			int count = 0;
			while(arr1[i] <= num) {
				count++;
				num -= arr1[i];
			}
			System.out.println(arr1[i]+"원:"+count);
		}
	}

}
