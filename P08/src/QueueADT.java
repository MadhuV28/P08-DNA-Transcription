/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: QueueADT
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
/**
 * This class has the QueueADT<T> interface
 * 
 * @author mvuyyuru
 *
 * @param <T>
 */
public interface QueueADT<T> {
  /**
   * Adds one element to the back of the queue
   * 
   * @param element the element being addded to the back of the queue
   */
  public void enqueue(T element);

  /**
   * Removes and returns the element at the front of the queue
   * 
   * 
   */
  public T dequeue();

  /**
   * Returns without removing the element at the front of the queue
   * 
   * 
   */
  public T peek();

  /**
   * // Returns true if and only if the queue contains no elements
   * 
   * 
   */
  public boolean isEmpty();

  /**
   * // Returns the number of elements in the queue
   * 
   * 
   */
  public int size();

  /**
   * Returns a string representation of the queue
   * 
   * 
   */
  public String toString();
}
