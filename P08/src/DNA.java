/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DNA
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
 * This class contains DNA which extends Object and has the needed methods and constructors
 * 
 * @author mvuyyuru
 *
 */
public class DNA extends Object {
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};// A two-dimensional array
                                                                  // containing the mRNA codons in
                                                                  // index 0 and the corresponding
                                                                  // amino acid (or STOP) in index 1

  protected LinkedQueue<Character> DNA;// The queue containing the original DNA sequence

  /**
   * Creates the DNA queue from the provided String. Each Node contains a single Character from the
   * sequence.
   * 
   * @param sequence - a String containing the original DNA sequence
   * 
   */
  public DNA(String sequence) {

    DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      DNA.enqueue(sequence.charAt(i));
    }
  }

  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA. The transcription is
   * done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
   * 
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNA = new LinkedQueue<>();
    for (int i = 0; i < DNA.size(); i++) {
      char c = DNA.dequeue();
      if (c == 'A') {
        mRNA.enqueue('U');
      } else if (c == 'T') {
        mRNA.enqueue('A');
      } else if (c == 'C') {
        mRNA.enqueue('G');
      } else if (c == 'G') {
        mRNA.enqueue('C');
      }
      DNA.enqueue(c);
    }
    return mRNA;
  }

  /**
   * Creates and returns a new queue of amino acids from a provided queue of mRNA characters. The
   * translation is done three characters at a time, according to the static mRNAtoProteinMap
   * provided above. Translation ends either when you run out of mRNA characters OR when a STOP
   * codon is reached (i.e. the three-character sequence corresponds to the word STOP in the map,
   * rather than a single amino acid character).
   * 
   * @param mRNA - a queue containing the mRNA sequence corresponding to the stored DNA sequence
   * 
   * @return the queue containing the amino acid sequence corresponding to the provided mRNA
   *         sequence
   * 
   */
  public LinkedQueue<String> mRNATranslate​(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> aminoAcid = new LinkedQueue<String>();
    int size = mRNA.size();
    for (int i = 0; i < size / 3; i++) {
      String codon = "";
      codon = codon + mRNA.dequeue() + mRNA.dequeue() + mRNA.dequeue();
      for (int j = 0; j < mRNAtoProteinMap.length; j++) {
        if (codon.equals(mRNAtoProteinMap[j][0])) {
          if (mRNAtoProteinMap[j][1].equals("STOP")) {
            return aminoAcid;
          } else {
            aminoAcid.enqueue(mRNAtoProteinMap[j][1]);
          }
        }
      }
    }
    return aminoAcid;
  }

  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using the
   * other two methods in this class
   * 
   * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence,
   *         via its mRNA transcription
   * 
   */
  public LinkedQueue<String> translateDNA() {
    return mRNATranslate​(transcribeDNA());
  }
}
