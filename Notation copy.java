/**
 * The Notation class provides static methods for evaluating postfix expressions,and for converting between postfix, infix, and vice-versa.
 * It uses a stack and queue to perform these operations and throws custom exceptions 
 * when invalid formats or stack/queue overflows/underflows occur.
 * CMSC 204
 * Professor Sandro Fouche
 * @author ZahraSarfraz
 */
public class Notation extends Object {

    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpr the postfix expression to evaluate
     * @return the result of the postfix expression as a double
     * @throws InvalidNotationFormatException if the expression format is invalid
     */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		double result = 0;
		MyStack<String> stack = new MyStack<String>(50);
		double EndResult = 0;
		
		for(int i = 0; i < postfixExpr.length();i++) {
			char current = postfixExpr.charAt(i);
			
			if(current== ' ') {
				continue;
			}
			else if(Character.isDigit(current)|| current=='(') {
				try{
					stack.push(String.valueOf(current));
				}catch(StackOverflowException e){
					e.printStackTrace();
				}
			}else if(current == '+'|| current =='-'||current == '*'||current == '/') {	
				
				if(stack.size()<2) {
					throw new InvalidNotationFormatException();
				}else {
					//try using try catch blocks!!!
					switch(current){
					
						case '+':
							try{
								double rightOperand= Double.valueOf(stack.pop());
								double leftOperand= Double.valueOf(stack.pop());
								result = leftOperand + rightOperand;
								stack.push(String.valueOf(result));
							}catch(StackUnderflowException e){
								e.printStackTrace();
							}
							catch(StackOverflowException e){
								e.printStackTrace();
							}
							break;
							
						case '-':
							try{
								double rightOperand= Double.valueOf(stack.pop());
								double leftOperand= Double.valueOf(stack.pop());
								result = leftOperand - rightOperand;
								stack.push(String.valueOf(result));
							}catch(StackUnderflowException e){
								e.printStackTrace();
							}catch(StackOverflowException e){
								e.printStackTrace();
							}
							break;
							
						case '*':
							try{
								double rightOperand= Double.valueOf(stack.pop());
								double leftOperand= Double.valueOf(stack.pop());
								result = leftOperand * rightOperand;
								stack.push(String.valueOf(result));
							}catch(StackUnderflowException e){
								e.printStackTrace();
							}catch(StackOverflowException e){
								e.printStackTrace();
							}
							break;
							
						case '/':
							try{
								double rightOperand= Double.valueOf(stack.pop());
								double leftOperand= Double.valueOf(stack.pop());
								result = leftOperand / rightOperand;
								stack.push(String.valueOf(result));
							}catch(StackUnderflowException e){
								e.printStackTrace();
							}catch(StackOverflowException e){
								e.printStackTrace();
							}
							break;
								
					}	//switch

				}//else
			}//else if
		}
		try{
			if(stack.size()==1) {
				EndResult= Double.valueOf(stack.pop());				
			}
		}catch(StackUnderflowException e){
			e.printStackTrace();
			throw new InvalidNotationFormatException();
		}
		return EndResult;
	}
	
	
    /**
     * Converts an infix expression to postfix.
     * 
     * @param infix the infix expression to convert
     * @return the corresponding postfix expression as a string
     * @throws InvalidNotationFormatException if the expression format is invalid
     */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<Character> stack3 = new MyStack<Character>(50);
		MyQueue<Character> queue = new MyQueue<Character>(50);
		
		for(int i=0; i<infix.length();i++) {
			char current3 = infix.charAt(i);
			
			if(current3==' ') {
				continue;
			}else if(Character.isDigit(current3)){
				try{
					queue.enqueue(current3);
				}catch(QueueOverflowException e){
					e.printStackTrace();
				}
			}else if (current3=='(') {
				try{
					stack3.push(current3);
				}catch(StackOverflowException e){
					e.printStackTrace();
				}
			}else if (current3 == '+'|| current3 =='-'||current3 == '*'||current3 == '/') {
				while(!stack3.isEmpty()){
					try{
						if(((stack3.top() == '*' || stack3.top() == '/') && (current3 == '-' || current3 == '+')) || ((stack3.top() == '-' || stack3.top() == '+') && (current3 == '-' || current3 == '+')) || ((stack3.top() == '*' || stack3.top() == '/') && (current3 == '*' || current3 == '/'))){
							queue.enqueue(stack3.pop());
						}
					}catch(StackUnderflowException e){
						e.printStackTrace();
					}catch(QueueOverflowException e){
						e.printStackTrace();
					}
				}
				try{
					stack3.push(current3);
				}catch(StackOverflowException e){
					e.printStackTrace();
				}
			}else if(current3 == ')'){
				try{
					char tempOp = stack3.pop();
					while(tempOp != '('){
						queue.enqueue(tempOp);
						tempOp = stack3.pop();
					}
				} catch(StackUnderflowException e){
					e.printStackTrace();
					throw new InvalidNotationFormatException();
				} catch (QueueOverflowException e){
					e.printStackTrace();
				}
			}
		}//for
		while(!stack3.isEmpty()){
			try{
				queue.enqueue(stack3.pop());
			}catch(StackUnderflowException e){
				e.printStackTrace();
			}catch(QueueOverflowException e){
				e.printStackTrace();
			}
		}
		return queue.toString();
	}//for the method

    /**
     * Converts a postfix expression to infix.
     * 
     * @param postfix the postfix expression to convert
     * @return the corresponding infix expression as a string
     * @throws InvalidNotationFormatException if the expression format is invalid
     */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		MyStack<String> stack2 = new MyStack<String>(50);
	
		for(int i=0; i<postfix.length();i++) {
			char current2 = (char)postfix.charAt(i);
			
			if(current2==' ') {
				
				continue;
			}else if(Character.isDigit(current2)) {
				try{
					stack2.push(String.valueOf(current2));
				}catch(StackOverflowException e){
					e.printStackTrace();
				}
			}
			else if(current2 == '+'|| current2 =='-'||current2 == '*'||current2 == '/') {
				
				if(stack2.size()<2) {
					throw new InvalidNotationFormatException();
				}else {
					try{
						//not working try different ones
//						char rightOperand= (char)stack2.pop();
//						char leftOperand= (char)stack2.pop();
						String leftOperand= String.valueOf(stack2.pop());
						String rightOperand= String.valueOf(stack2.pop());
						
						String resultString ="("+ rightOperand + current2+leftOperand+")";
						stack2.push(resultString);
					} catch(StackUnderflowException e){
						e.printStackTrace();
					} catch(StackOverflowException e){
						e.printStackTrace();
					}
				}//else
			}//else if
		}
		//try and catch block
		String comp = "";
		if(stack2.size() == 1) {
			comp = stack2.toString();
		}else{
			throw new InvalidNotationFormatException();
		}
		return comp;
	}
	
	}//notion
	
