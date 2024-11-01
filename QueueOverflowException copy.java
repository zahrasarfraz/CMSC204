/**
 * Exception thrown if enqueue called on a full queuue
 * @author ZahraSarfraz
 */
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("The Queue is not full and under the flow");
	}
}
