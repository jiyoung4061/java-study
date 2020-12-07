package basicExceriseOfJava;

import java.util.Scanner;

public class Basic1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num=0;
		
		System.out.print("수를 입력하세요:");
		num = scanner.nextInt();
		
		if(num%3 == 0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("3의 배수가 아닙니다.");
		}
	}

}
