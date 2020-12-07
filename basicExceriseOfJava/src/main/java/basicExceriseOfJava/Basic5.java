package basicExceriseOfJava;

public class Basic5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i < 100 ; i++) {
			if(i%10!=0 && (i%10)%3 == 0 ) {
				System.out.println(i+"짝");
			}
		}
	}

}
