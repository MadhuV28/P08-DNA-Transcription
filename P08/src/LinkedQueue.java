/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: LinkedQueue
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru
// Email: mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// pair programming was not used for this assignment
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * this class has LinkedQueue of type T which implements QueueADT<T> and the needed constructors and
 * mutators
 * 
 * @author mvuyyuru
 *
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T> {
  private int n;// The number of elements in the queue
  protected Node<T> front;// The node at the front of the queue, added LEAST recently
  protected Node<T> back;// The node at the back of the queue, added MOST recently

  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   * 
   */
  @Override
  public void enqueue(T data) {
    // TODO Auto-generated method stub
    Node<T> newNode = new Node<T>(data);
    if (back == null || front == null) {
      front = back = newNode;
      n++;
      return;
    }
    back.setNext(newNode);
    back = newNode;
    n++;
  }

  /**
   * Removes and returns the item from this queue that was least recently added
   * 
   * @return data the item from this queue that was least recently added
   * @throws NoSuchElementException - if this queue is empty
   * 
   */
  @Override
  public T dequeue() throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }
    T data = front.getData();
    front = front.getNext();
    n--;
    return data;
  }

  /**
   * Returns the item least recently added to this queue without removing it
   * 
   * @return dataPeek -the item least recently added to this queue
   * @throws NoSuchElementException - if this queue is empty
   * 
   */
  @Override
  public T peek() throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }
    T dataPeek = front.getData();
    return dataPeek;
  }

  /**
   * Checks whether the queue contains any elements
   * 
   * @return true if this queue is empty; false otherwise
   */
  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if (front == null || back == null || n == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the number of items in this queue
   * 
   * @return n - the number of items in this queue
   * 
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String output = "";
    Node<T> temp = front;
    while (temp != null) {
      output += temp.getData() + " ";
      temp = temp.getNext();
    }
    return output;
  }
}
