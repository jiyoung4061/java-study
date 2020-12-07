package algorithmWithJava;

public class kakao_2018_1_SecretMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] result = new String[n];
		
		for(int i = 0 ; i < result.length ; i++) {
			String element = Integer.toBinaryString(arr1[i] | arr2[i]);
			String blank = "";
			while(element.length() + blank.length() < n) {
				blank += "0";
			}
			result[i] = blank + element;
			result[i] = result[i].replace('1', '#');
			result[i] = result[i].replace('0', ' ');
			System.out.println(result[i]);
		}
		
//		char[][] sarr1 = new char[n][];
//		char[][] sarr2 = new char[n][];
//		String[] result = new String[n];
		// int -> binary leading zeros
//		for(int i = 0 ; i < arr1.length ;i++) {
//			String binaryelement = Integer.toBinaryString(arr1[i]);
//			String blank = "";
//			while(binaryelement.length() + blank.length() < n) {
//				blank += "0";
//			}
//			sarr1[i] = (blank + binaryelement).toCharArray();
//		}
//		
//		for(int i = 0 ; i < arr2.length ;i++) {
//			String binaryelement = Integer.toBinaryString(arr2[i]);
//			String blank = "";
//			while(binaryelement.length() + blank.length() < n) {
//				blank += "0";
//			}
//			sarr2[i] = (blank + binaryelement).toCharArray();
//			System.out.println(sarr2[i]);
//		}
//		System.out.println();
//		
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < n ; j++) {
//				if(sarr1[i][j] == '0' && sarr2[i][j] == '0') {
//					sarr1[i][j] = ' ';
//				} else {
//					sarr1[i][j] = '#';
//				}
//			}
//			result[i] = String.valueOf(sarr1[i]);
//			System.out.println(result[i]);
//		}
		
	}

}
