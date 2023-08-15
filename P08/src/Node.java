/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Node
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
 * This class contains Node and the needed mutators and methods
 * 
 * @author mvuyyuru
 *
 * @param <T>
 */
public class Node<T> {
  private T data;// the data contained in the Node
  private Node<T> next;// the Node following this one

  /**
   * Basic constructor; creates a node that contains the provided data and no linkages.
   * 
   * @param data - the information to put inside the node
   * 
   */
  public Node(T data) {
    this.data = data;
  }

  /**
   * A constructor that allows specification of the next node in the chain
   * 
   * @param data - the information to put inside the Node
   * 
   * @param next - the next node, must contain the same type of data as this node
   * 
   */
  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  /**
   * Accessor method for this node's data
   * 
   * @return data - the data contained in this node
   * 
   */
  public T getData() {
    return data;
  }

  /**
   * Accessor method for the node following this one
   * 
   * @return next - the next node
   * 
   */
  public Node<T> getNext() {
    return next;
  }

  /**
   * Mutator method for the node following this one
   * 
   * @param next - the node to follow this one
   * 
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }
}
