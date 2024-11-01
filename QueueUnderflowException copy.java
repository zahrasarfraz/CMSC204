/**
 * Exception thrown if deenqueue called on a empty queuue
 * @author ZahraSarfraz
 */
public class QueueUnderflowException extends Exception {
	
	public QueueUnderflowException() {
		super("Queue is full");
	}
}
