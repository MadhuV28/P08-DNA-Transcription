/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DNATester
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
 * Test methods to verify your implementation of the methods for P08.
 */
import java.util.NoSuchElementException;

public class DNATester {

  // TODO: verify your LinkedQueue implementation directly

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    return false;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString().replaceAll(" ", ""));
    System.out.println("PQSIRWPCMTEPLEARSFRD");
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }

  /**
   * to test adding and removing things from your queue (hint: use its toString method)
   * 
   * @return true if and only if the method works correctly and false otherwise
   */
  public static boolean testEnqueueDequeue() {
    try {
      LinkedQueue<Integer> testQueue = new LinkedQueue<Integer>();
      testQueue.enqueue(1);
      testQueue.enqueue(2);
      testQueue.enqueue(3);
      String expectedOutput = "1 2 3 ";
      if (!testQueue.toString().equals(expectedOutput)) {
        System.out.println("Error: enqueue() did not work properly");
        return false;
      }
      testQueue.dequeue();
      testQueue.dequeue();
      expectedOutput = "3 ";
      if (!testQueue.toString().equals(expectedOutput)) {
        System.out.println("Error: dequeue() did not work properly");
        return false;
      }
      testQueue.dequeue();
      testQueue.dequeue();
      System.out.println("Error: dequeue did not throw error when the queue is empty");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println(
          "Error: dequeue did not throw the correct exception " + "when the queue is empty");
      return false;
    }
    return true;
  }

  /**
   * test the queue’s size and isEmpty methods
   * 
   * @return true if and only if the method works correctly and false otherwise
   */
  public static boolean testQueueSize() {
    try {
      LinkedQueue<Integer> testQueue = new LinkedQueue<Integer>();
      testQueue.enqueue(1);
      testQueue.enqueue(2);
      testQueue.enqueue(3);
      if (testQueue.size() != 3) {
        System.out.println(
            "Error: the testQueue size does not equal its expected size adfter adding values");
        return false;
      }
      testQueue.dequeue();
      if (testQueue.size() != 2) {
        System.out.println(
            "Error: the testQueue size does not equal its expected size after removing values");
        return false;
      }
      testQueue.dequeue();
      testQueue.dequeue();
      if (!testQueue.isEmpty()) {
        System.out.println("the testQueue size is not empty");
        return false;
      }

    } catch (Exception e) {
      System.out.println("isEmpty() or size() throws an exception");
      return false;
    }

    return true;
  }

  /**
   * Tests the mRNATranslate() method
   * 
   * @return true if and only if the method works correctly and false otherwise
   */
  public static boolean testMRNATranslate() {
    DNA testDNA = new DNA("GGA");
    LinkedQueue<Character> testmRNA = testDNA.transcribeDNA();
    if (testDNA.mRNATranslate​(testmRNA).toString().replaceAll(" ", "").trim().equals("P")) {


      DNA testDNA2 = new DNA("CCGGCCCTCCGGTGGATCCAA");
      LinkedQueue<Character> testmRNA2 = testDNA2.transcribeDNA();
      if (testDNA.mRNATranslate​(testmRNA2).toString().replaceAll(" ", "").trim().equals("GREAT")) {
        return true;
      }
    }
    return false;
  }



  /**
   * Tests all tester methods and returns true if they work and false otherwise
   * 
   * @return true if and only if the method works correctly and false otherwise
   */
  public static boolean testAll() {
    if (testTranscribeDNA() && testTranslateDNA() && testEnqueueDequeue() && testQueueSize()
        && testMRNATranslate()) {
      return true;
    }
    return false;
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println("testEnqueueDequeue: " + testEnqueueDequeue());
    System.out.println("testQueueSize: " + testQueueSize());
    System.out.println("testMRNATranslate: " + testMRNATranslate());
    System.out.println("testAll: " + testAll());


  }

}
