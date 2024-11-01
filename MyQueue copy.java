import java.util.ArrayList;
import java.util.Objects;

/**
 * An array base queue implementation. 
 * @author ZahraSarfraz
 *
 */
public class MyQueue<T> implements QueueInterface<T> {

  private Object[] elements;
  private int first;
  private int last;
  private int numElements;
  private int capacity;


/**
 * MyQueue with a fixed capacity
 */
  public MyQueue() {
    capacity = 20;
    elements = new Object[capacity];

  }

/**
 * MyQueue with the capacity
 * @param capacity the capacity of this queue
 */
  public MyQueue(int capacity) {
    this.capacity = capacity;
    this.first = this.last = -1;
    this.numElements = 0;
    elements = new Object[capacity];
  }

  /**
   * Determines if Queue is empty
   * @return true if Queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return numElements == 0;
  }

  /**
   * Determines if full
   * @return true if queue is full, false otherwise
   */
  @Override
  public boolean isFull() {
    return capacity == numElements;
  }

 /**
  * Deletes and returns the element at the front of the Queue
  * @return the element at the front of the Queue
  */
  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    @SuppressWarnings("unchecked")
    T firstInLine = (T) elements[first];
    if (firstInLine == null)
      return null;
    elements[first] = null;
    first++;
    numElements--;
    return firstInLine;
  }

  /**
   * Number of elements in the Queue
   * @returnnumber of elements in queue
   */
  @Override
  public int size() {
    return numElements;
  }

 /**
  * Adds an element to the end of the Queue
  * @param e the element to add to the end of the Queue
  * @return true if the add was successful, otherwise false
   */
  @Override
  public boolean enqueue(T e) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }
    
    if(isEmpty()) {
      first = last = 0;
    } else {
      last++;
    }
    numElements++;
    elements[last] = e;
    return true;
  }

/**
 * Returns the string representation of the elements in the Queue
 * @return string representation of the Queue 
 */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
   
    for (int i = first; i <= last; i++) {
      sb.append(elements[i]);
    }
    return sb.toString();
  }

  /**
   * Returns the string representation of the elements in the Queue
   * @param delimiter - string used to separate queue elements
   * @return string representation of the Queue with elements separated with the delimiter
   */
  @Override
  public String toString(String delimiter) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = first; i < last; i++) {
      sb.append(elements[i] + delimiter);
    }
    sb.append(elements[last]);
    return sb.toString();
  }

/**
 * Fills the Queue with the elements of the ArrayList
 * @param list elements to be added to the Queue 
 */
  @Override
  public void fill(ArrayList<T> list) {
    ArrayList<T> cloneList = new ArrayList<>(list);
    cloneList.forEach(t -> {
      try {
        enqueue(t);
      } catch (QueueOverflowException ex) {
        ex.getMessage();
      }
    });
  }

}