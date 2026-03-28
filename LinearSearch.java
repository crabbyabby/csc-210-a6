import java.util.Collections;

/**
 * Program that searches for first occurance of target
 * 
 * @author Abigail Lei
 * @version March 2026
 */
public class LinearSearch {

  /**
   * Linear search without a recorder
   * @param cards pile of cards to search through
   * @param target card to look fore
   * @return boolean if card is found or not
   */
  public static boolean search(CardPile cards, Card target) {
    return search(cards, target, null);
  }

  /**
   * Linear search with a recorder
   * @param cards pile of cards to search through
   * @param target cards to look for
   * @param record recorder for visualization
   * @return boolean if card is found
   */
  public static boolean search(CardPile cards, Card target, SortRecorder record) {

    if (record != null) {
      record.add(cards);
    }

    for (Card card : cards) {
      if (record != null) {
        record.next();
        record.add(cards);
      }
      if (card.compareTo(target) == 0) {
        return true;
      }

    }

    // ***********************************************************
    // Search through the pile one card at a time.
    // Return true as soon as you find target.
    // If the whole pile is checked and target is never found,
    // return false.
    //
    // If you are recording the search visually, take one snapshot
    // per comparison so the viewer shows the search progression.
    // ***********************************************************

    return false;
  }

/** 
 * Testing the visualization
 * @param args arguments
 */ 
 public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // in your program, this would be a call to a real sorting algorithm

    //I think I'm losing points from the way I test
    // Card card = cards.get(5);
    // LinearSearch.search(cards, card, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: LinearSearch");
  }
}
