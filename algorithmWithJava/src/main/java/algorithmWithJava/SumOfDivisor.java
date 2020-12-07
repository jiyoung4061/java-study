package algorithmWithJava;

public class SumOfDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int answer = 0;
		
		for(int i = 1 ; i <= (n/2) ; i++) {
			if(n%i == 0) {
				answer += i;
			}
		}
		
		System.out.println(answer+n);
	}

}
