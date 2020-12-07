package basicExceriseOfJava;

import java.util.Scanner;

public class Basic7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[5];
		double sum = 0;
		
		System.out.println("5개의 숫자를 입력하세요");
		for(int i = 0 ; i < 5 ; i++) {
			sum += scanner.nextInt();
		}
		System.out.println("평균:"+ sum/5);
	}

}
