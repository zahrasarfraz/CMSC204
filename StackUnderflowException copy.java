/**
 * Exception thrown if pop method is called on a empty stack
 * @author ZahraSarfraz
 */
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("The stack is underflowing");
	}
}
