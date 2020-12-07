package algorithmWithJava;

public class Caesar_cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s = "a B z";
			int n = 4;
			String answer="";
			
			char[] arr = s.toCharArray();
			System.out.println(arr);
			for(int i = 0 ; i < arr.length ; i++) {
				if(arr[i] <= 'z' && arr[i] >= 'a') {
					arr[i]+= n;
					if(arr[i] > 'z') {
						arr[i] -= 'z'-'a'+1;
					}

				} else if(arr[i] <= 'Z' && arr[i] >= 'A'){
					arr[i]+= n;
					if(arr[i] > 'Z') {
						arr[i] -= 'Z'-'A'+1;
					}
				}
				answer += arr[i];
				
			}
			System.out.println(answer);
	}
}
