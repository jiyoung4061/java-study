package dataStructure_Stack;

public class TestOfBracketWithStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "[a{b+c-(a*3)}+4]"; // ���� ����
		System.out.println(checkMatch(expression));
		
		expression = "[a{b+c-(a*3)+4]"; //����1 ����
		System.out.println(checkMatch(expression));
		
		expression = ")(a+b))"; // ����2 ����
		System.out.println(checkMatch(expression));
		
		expression = "[a{b+c-(a/2}+1)]"; // ����3 ����
		System.out.println(checkMatch(expression));
	}
	
	public static boolean checkMatch(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		char[] arr = s.toCharArray(); // charŸ���� �迭�� �ٲ���!!
//		// ����� => if�� ���
//		for(int i = 0 ; i < arr.length ;i++) {
//			if(arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
//				stack.push(arr[i]);				
//			}else if(arr[i] == ')') {
//				if(stack.empty() || stack.pop() != '(') return false; // �ݴ� ��ȣ�� ���� ���� ��� || pop�� ���� ¦�� �ȸ´� ��� return false;
//			}else if(arr[i] == '}') {
//				if(stack.empty() || stack.pop() != '{') return false;
//			} else if(arr[i] == ']') {
//				if(stack.empty()|| stack.pop() != '[') return false;
//			}
//		}
//		
//		if(stack.empty()) {
//			return true;
//		} else {			
//			return false;
//		}
		
		// ������ Ǯ�� ���
		boolean valueOfReturn = true;
		
		for(int i = 0 ; i < arr.length ;i++) {
			if(arr[i] == '[' || arr[i] == '{' || arr[i] == '(')
				stack.push(arr[i]);
			else {
				switch(arr[i]) {
				case '}' :
					if(stack.empty() || stack.pop() != '{')
						valueOfReturn = false;
					break;
				case ']' : 
					if(stack.empty() || stack.pop() != '[')
						valueOfReturn = false;
					break;
				case ')' :
					if(stack.empty() || stack.pop() != '(')
						valueOfReturn = false;
					break;
				}
				if(!valueOfReturn) return valueOfReturn; // valueOfReturn���� false�� �Ǹ� �ٷ� �Լ� �����ָ��!
			}
		}
		if(!stack.empty())
			valueOfReturn = false;
		return valueOfReturn;
	}
}
