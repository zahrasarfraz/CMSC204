import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * This class contains JUnit tests for the MyQueue class, which is a custom queue implementation.
 * The tests cover various methods of the queue, such as enqueue, dequeue, isEmpty, isFull, size, 
 * toString, and handling exceptions like QueueUnderflowException and QueueOverflowException.
 * Additionally, it includes student tests for a Double-based queue (doubleQ).
 * 
 * @author Zahra Sarfraz
 */
public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	  /**
     * A MyQueue instance for testing String type.
     */
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
    /**
     * Sample String elements used for testing.
     */
	public Double one = 1.0, two = 2.0, three = 3.0, four = 4.0, five = 5.0, six = 6.0;

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		   doubleQ = new MyQueue<Double>(5);
		    doubleQ.enqueue(one);
		    doubleQ.enqueue(two);
		    doubleQ.enqueue(three);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		  // Use the doubleQ for student tests
	    try {
	      assertEquals(one, doubleQ.dequeue());
	      assertEquals(two, doubleQ.dequeue());
	      assertEquals(three, doubleQ.dequeue());
	      // Queue is empty, next statement should cause QueueUnderFlowException
	      doubleQ.dequeue();
	      assertTrue("This should have caused an QueueUnderflowException", false);
	    } catch (QueueUnderflowException e) {
	      assertTrue("This should have caused an QueueUnderflowException", true);
	    } catch (Exception e) {
	      assertTrue("This should have caused an QueueUnderflowException", false);
	    }
	}

	@Test
	public void testSize() throws QueueUnderflowException, QueueOverflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		// Use the doubleQ for student tests
	    try {
	      assertEquals(3, doubleQ.size());
	      assertEquals(true, doubleQ.enqueue(four));
	      assertEquals(4, doubleQ.size());
	      assertEquals(true, doubleQ.enqueue(five));
	      assertEquals(5, doubleQ.size());
	      // Queue is full, next statement should cause QueueOverFlowException
	      doubleQ.enqueue(six);
	      assertTrue("This should have caused an QueueOverflowException", false);
	    } catch (QueueOverflowException e) {
	      assertTrue("This should have caused an QueueOverflowException", true);
	    } catch (Exception e) {
	      assertTrue("This should have caused an QueueOverflowException", false);
	    }
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	/**
	 * Student test for the toString method using doubleQ.
	 * @throws QueueOverflowException if the queue is full and enqueue is added
	 */
	@Test
	public void testToStringStudent() throws QueueOverflowException {
	    // Use the doubleQ for student tests
	    assertEquals("1.02.03.0", doubleQ.toString());
	    doubleQ.enqueue(four);
	    assertEquals("1.02.03.04.0", doubleQ.toString());
	    doubleQ.enqueue(five);
	    assertEquals("1.02.03.04.05.0", doubleQ.toString());
	}

	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() throws QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
