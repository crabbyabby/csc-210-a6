import java.util.Collections;

/**
 * Class that does selection sort
 * Find smallest item in unsorted area and
 * put in sorted section until unsorted pile
 * has nothing in it!
 * 
 * @author Abigail Lei
 * @version March 2026
 */
public class SelectionSort {
  
  /**
   * Runs the selection sort without recorder
   * @param unsorted pile of cards
   * @return the beautifully sorted cardpile
   */
  public static CardPile sort(CardPile unsorted) {
    return sort(unsorted, null);
  }

  /**
   * Runs selection sort with recorder
   * @param unsorted pile of cards
   * @param record recorder for visualization
   * @return beautifully sorted cardpile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    if (record != null) {
      record.add(unsorted);
    }
    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
    
    while (unsorted.size() > 0) {
      Card smallest = unsorted.peek();      for (Card card: unsorted) {
        if (card.compareTo(smallest) < 0) {
          smallest = card;
        }
      }
      sorted.add(smallest);
      unsorted.remove(smallest);
      
      if (record != null) {
        record.next();
        record.add(sorted);
        record.add(unsorted);
      }
    }
    
    return sorted; 
  }

  /**
   * @param args arguments
   * Test visualization */
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

      // if you want to sort in array form, use:
      Card[] card_arr = cards.toArray(new Card[0]);

      // in your program, this would be a call to a real sorting algorithm
      cards = SelectionSort.sort(cards, recorder);

      // We can print out the (un)sorted result:
      System.out.println(cards);

      // make window appear showing the record
      recorder.display("Card Sort Demo: SelectionSort");
  }
}
