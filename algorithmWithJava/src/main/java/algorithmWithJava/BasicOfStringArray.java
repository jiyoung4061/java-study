package algorithmWithJava;

public class BasicOfStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		String s = "1234";

		if (s.length() == 4 || s.length() == 6){
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					System.out.println(arr[i]);
				} else
					answer = false;
			}
		}
		
		System.out.println(answer);
	}

}
