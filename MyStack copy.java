import java.util.ArrayList;

/**
 * A generic implementation of the StackInterface that provides a stack with a fixed capacity.
 * It includes methods for pushing, popping, and inspecting the top element, as well as 
 * checking whether the stack is full or empty.
 *@author ZahraSarfraz
 * @param <T> the type of elements stored in this stack
 */
public class MyStack<T> implements StackInterface<T> {

  private Object[] elements;
  private int first;
  private int last;
  private int numElements;
  private int capacity;

  /**
   * Default constructor that initializes the stack with a default capacity of 20.
   */
  public MyStack() {
    this.capacity = 20;
    this.elements = new Object[capacity];
  }
  
  
  /**
   * Constructor that initializes the stack with a given capacity.
   *
   * @param capacity the maximum number of elements the stack can hold
   */
  public MyStack(int capacity) {
    this.capacity = capacity;
    this.first = this.last = -1;
    this.numElements = 0;
    elements = new Object[capacity];
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack contains no elements, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return numElements == 0;
  }


  /**
   * Checks whether the stack is full.
   *
   * @return true if the stack has reached its capacity, false otherwise
   */
  @Override
  public boolean isFull() {
    return capacity == numElements;
  }

  /**
   * Removes and returns the element at the top of the stack.
   *
   * @return the element at the top of the stack
   * @throws StackUnderflowException if the stack is empty
   */
  @Override
  public T pop() throws StackUnderflowException {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    @SuppressWarnings("unchecked")
    T firstInTop = (T) elements[last];
    if (firstInTop == null)
      return null;
    elements[last] = null;
    last--;
    numElements--;
    return firstInTop;
  }

  /**
   * Retrieves, but does not remove, the element at the top of the stack.
   *
   * @return the element at the top of the stack
   * @throws StackUnderflowException if the stack is empty
   */
  @Override
  public T top() throws StackUnderflowException {
    if (isEmpty()) {
      throw new StackUnderflowException();
    }
    @SuppressWarnings("unchecked")
    T firstInTop = (T) elements[last];
    return firstInTop;
  }

  /**
   * Returns the number of elements currently in the stack.
   *
   * @return the number of elements in the stack
   */
  @Override
  public int size() {
    return numElements;
  }

  /**
   * Adds an element to the top of the stack.
   *
   * @param e the element to be added to the stack
   * @return true if the element is successfully added, false otherwise
   * @throws StackOverflowException if the stack is full
   */
  @Override
  public boolean push(T e) throws StackOverflowException {
    if (isFull()) {
      throw new StackOverflowException();
    }

    if (isEmpty()) {
      first = last = 0;
    } else {
      last++;
    }
    numElements++;
    elements[last] = e;
    return true;
  }

  /**
   * Returns a string representation of the stack elements.
   *
   * @return a string containing all elements of the stack
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
   * Returns a string representation of the stack elements separated by a specified delimiter.
   *
   * @param delimiter the string to separate each element in the stack
   * @return a string containing all elements of the stack, separated by the delimiter
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
   * Fills the stack with elements from the specified list.
   *
   * @param list the list containing elements to be added to the stack
   */
  @Override
  public void fill(ArrayList<T> list) {
    ArrayList<T> cloneList = new ArrayList<>(list);
    cloneList.forEach(t -> {
      try {
        push(t);
      } catch (StackOverflowException ex) {
        ex.getMessage();
      }
    });
  }

}