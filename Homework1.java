
import java.util.Scanner;
import java.util.Stack;


public class Homework11 {
	
	private Stack<String> stack;
	public static Stack<String> stack1 = new Stack<String>();
	private String infixExp;
	private String postfixExp = "";
	public static Node OneNode;
	public static Node TwoNode;
	public static String cal;
	public static Character culator;

	
	public String returnS;
	public Homework11(String exp){
		
		
		String str = "";
		postfixExp = exp;
		stack = new Stack<String>();
		
		for (int i=0;i<postfixExp.length();i++){
			
			str = postfixExp.substring(i,i+1);
			if(str.matches("[0-9]"))
				postfixExp += str;
			else if (isOperator(str)){
				
				if (stack.isEmpty()){
					stack.push(str);
				}
				else{
					
					String stackTop = stack.peek();
					while (Calculate1(stackTop,str).equals(stackTop)&& !(stack.isEmpty())){
						postfixExp += stack.pop();
						if (!(stack.isEmpty()))
							stackTop = stack.peek();
					}
					stack.push(str);
				}
			}
		}
		
		while(!(stack.isEmpty()))
			postfixExp += stack.pop();
		
		returnS=infixExp;
	}
	private Object Calculate1(String stackTop, String str) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void Infix (Node OneNode) {
		if(OneNode.Value.equalsIgnoreCase("+")||
				OneNode.Value.equalsIgnoreCase("-")||
				OneNode.Value.equalsIgnoreCase("*")||
				OneNode.Value.equalsIgnoreCase("/")) {
			OneNode.NRight = new Node (stack1.pop());
			Infix(OneNode.NLeft);
		}	
		}
		private boolean isOperator(String ch){
			
			String operators = "*/%+-";
			if (operators.indexOf(ch) != -1)
				return true;
			else
				return false;
			
	}
	public static void Inorder (Node TwoNode) {
		if(TwoNode.Value.equalsIgnoreCase("+")||
				TwoNode.Value.equalsIgnoreCase("-")||
				TwoNode.Value.equalsIgnoreCase("*")||
				TwoNode.Value.equalsIgnoreCase("/")) {
			OneNode.NRight = new Node (stack1.pop());
			if (TwoNode != OneNode)
				System.out.print("(");
			
			Inorder(TwoNode.NLeft);
			System.out.print(TwoNode.Value);
			Inorder(TwoNode.NRight);
			if(TwoNode != OneNode)
				System.out.print("(");
			
	}
		else
		{
			System.out.print(TwoNode.Value);
		}
}
		public static int Calculate1 (Node n) {
			int answer = 0;

		     
		        if (n.Value.matches("[0-9]")){
		            return Integer.valueOf(n.Value);
		        }
		        double inputA,inputB;
		        double answer1 = 0;
		        
		        inputA = Calculate1(n.NLeft);
		        inputB = Calculate1(n.NRight);
		        Scanner input = new Scanner(System.in);

			    Maths Maths = new Maths();
		        
		        switch (n.Value) {
	            case "+": answer1 = Maths.add(inputA, inputB);
	                      break;
	            case "-": answer1 = Maths.subtract(inputA, inputB);
	                      break;
	            case "*": answer1 = Maths.multiply(inputA, inputB);
	                      break;
	            case "/": answer1 = Maths.divide(inputA, inputB);
	                      break;
	            case "^": answer1 = Maths.power(inputA, inputB);
	                      break;
	        }
	  
		       
		        return answer;
	}		
	public static void main(String[] args) {
		// Begin of arguments input sample
		if (args.length > 0) {
			
			String input = args[0];
			
			String expression =("(2*(5-1))+(3*2)=14");
			System.out.println("infix:"+expression);
			
}
	}}
