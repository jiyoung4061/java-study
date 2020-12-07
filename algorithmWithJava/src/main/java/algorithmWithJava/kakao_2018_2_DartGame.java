package algorithmWithJava;

import java.util.Stack;
import java.util.StringTokenizer;

public class kakao_2018_2_DartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String dartResult = "1S*2T*3S";
			int answer = 0;
			
			char[] arr = dartResult.toCharArray();
			Stack<Integer> stack = new Stack<Integer>();
			String strscore = "";
			for(int i = 0 ; i < arr.length ; i++) {
				if( arr[i] >='0' && arr[i] <= '9') {
					strscore += arr[i];
				} else if(arr[i] == '*') {
					int a = stack.pop();
					if( !stack.empty()) {
						int b = stack.pop();						
						stack.push(b * 2);
						stack.push(a * 2);
					} else {
						stack.push(a*2);
					}					
				} else if(arr[i] == '#') {
					stack.push(stack.pop()*(-1));
				} else {
					stack.push(getResult(Integer.parseInt(strscore) , arr[i]));
					strscore = "";
					System.out.println("peek:"+stack.peek());
				}
			}
			while(!stack.empty()) {
				System.out.println(stack.pop());
			}
			System.out.println(answer);
			
			
	}
	public static int getResult(int a, char b) {
		int result = 0;
		switch(b) {
		case 'S':
			result = a;
			break;
		case 'D':
			result = (int)Math.pow(a, 2);
			break;
		case 'T':	
			result = (int)Math.pow(a, 3);
			break;
		}
		System.out.println("Res:"+result);
		return result;
	}
}
