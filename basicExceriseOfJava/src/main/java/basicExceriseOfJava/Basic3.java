package basicExceriseOfJava;

import java.util.Scanner;

public class Basic3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요:");
		int num = scanner.nextInt();
		int sum = 0;
		
		for(int i = num ; i > 0 ; i-=2) {
			sum += i;
		}
		
		System.out.println("결과 값: "+ sum);
	}

}
