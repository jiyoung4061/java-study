package dataStructure_Stack;

public class StackCalculator {
	private String infixExpression;
	String res = "";

	public StackCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}

	public String infixToPostfix() {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = infixExpression.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				while (stack.peek() != '(') {
					res += stack.pop();
				}
				stack.pop();
			} else if (arr[i] >= '0' && arr[i] <= '9') {
				res += arr[i];
			} else {
				if (!stack.empty() && (compareOfOperand(arr[i], stack.peek()) < 1)) {
					while (!stack.empty() && stack.peek() != '(') {
						res += stack.pop();
					}
				}
				stack.push(arr[i]);
			}
		}
		while (!stack.empty()) { // stack�� �����ִ� �͵� �� pop
			res += stack.pop();
		}
		return res;
	}

	public int compareOfOperand(char a, char b) {
		// ������ a�� b���� �켱������ ū ��� +1
		// b�� �� ū��� -1
		// ���� ��� == 0
		int valOfReturn = 0; // 0���� �ʱⰪ�������!!!!!=> (��ȣ�� ������ ���!
		switch (a) {
		case '+':
		case '-':
			if (b == '/' || b == '*')
				valOfReturn = -1;
			else
				valOfReturn = 0;
			break;
		case '*':
		case '/':
			if (b == '+' || b == '-')
				valOfReturn = 1;
			else
				valOfReturn = 0;
			break;
		}
		return valOfReturn;
	}

	public int CalculatorUsingStack() {

		char[] arrayOfRes = res.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < arrayOfRes.length; i++) {
			if (arrayOfRes[i] >= '0' && arrayOfRes[i] <= '9') {
				stack.push(arrayOfRes[i] - '0');
			} else {
				stack.push(getResult(stack.pop(), stack.pop(), arrayOfRes[i]));
			}
		}
		return stack.pop();
	}

	public int getResult(int a, int b, char c) {
		int result = 0;
		switch (c) {
		case '+':
			result = b + a;
			break;
		case '-':
			result = b - a;
			break;
		case '*':
			result = b * a;
			break;
		case '/':
			result = b / a;
			break;
		}
		return result;
	}
}