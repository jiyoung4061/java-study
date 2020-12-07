package algorithmWithJava;

public class MakeStrangeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "try hello world";
		String answer = "";
		String[] arr = s.split(" ");
		
		for(int i = 0 ; i < arr.length ; i++) {
			String[] arr2 = arr[i].split("");
			for(int j = 0 ; j < arr2.length ; j++) {
				if(j%2 == 0) {
					arr2[j] = arr2[j].toUpperCase();
				}
				answer += arr2[j];
			}
			answer += " ";
		}
		answer = answer.substring(answer.length()-2, answer.length()-1);
		System.out.println(answer);
	}
}
