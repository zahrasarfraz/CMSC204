/**
 * Exception thrown if push method is called on a full stack
 * @author ZahraSarfraz
 */
public class StackOverflowException extends Exception {
 
	public StackOverflowException() {
		super("Stack is overflowing");
	}
}
