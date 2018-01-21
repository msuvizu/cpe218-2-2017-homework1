
import java.util.Scanner;
import java.util.Stack;


public class Infix2Postfix {
	
	private Stack<String> stack;
	private String infixExp;
	private String postfixExp = "";
	
	public String returnS;
	public Infix2Postfix(String exp){
		
		String str = "";
		infixExp = exp;
		stack = new Stack<String>();
		
		for (int i=0;i<infixExp.length();i++){
			
			str = infixExp.substring(i,i+1);
			if(str.matches("[0-9]|\\d"))
				postfixExp += str;
			else if (isOperator(str)){
				
				if (stack.isEmpty()){
					stack.push(str);
				}
				else{
					
					String stackTop = stack.peek();
					while (getPrecedence(stackTop,str).equals(stackTop)&& !(stack.isEmpty())){
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
		
		returnS=postfixExp;
	}
	
	
	private boolean isOperator(String ch){
		
		String operators = "*/%+-";
		if (operators.indexOf(ch) != -1)
			return true;
		else
			return false;
	}
	
	
	private String getPrecedence(String op1, String op2){
		
		String multiplicativeOps = "*/%";
		String additiveOps = "+-";
		
		if ((multiplicativeOps.indexOf(op1) != -1) && (additiveOps.indexOf(op2) != -1))
			return op1;
		else if ((multiplicativeOps.indexOf(op2) != -1) && (additiveOps.indexOf(op1) != -1))
			return op2;
		else if((multiplicativeOps.indexOf(op1) != -1) && (multiplicativeOps.indexOf(op2) != -1))
			return op1;
		else 
			return op1;
	}		
	
	public static void main(String[] args){
		
		
		
		String expression ="251-*32*+";
		// scanner.nextLine();
		System.out.println("(2*(5-1))+(3*2)=14");
		new Infix2Postfix(expression);
	}
}