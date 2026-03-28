import java.util.Collections;
import java.util.ListIterator;

/**
 * Program to sort cards via Insertion Sort
 * Sorting algorithm that takes unsorted item
 * and sorts it into the sorted section
 * 
 * @author Abigail Lei
 * @version March 2026
 */
public class InsertionSort {
  
  /**
   * Runs selection sort without recorder
   * @param unsorted pile of cards
   * @return beautiful sorted pile of cards
   */
  public static CardPile sort(CardPile unsorted) {
    return sort(unsorted, null);
  }

  /**
   * Runs selection sort with recorder
   * @param unsorted pile of cards
   * @param record recorder for the program
   * @return sorted pile of cards
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    if (record != null) {
      record.add(unsorted);
    }

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    while (unsorted.size() > 0) {
      Card added = unsorted.removeFirst();
      ListIterator<Card> iterator = sorted.listIterator();
      
      while (iterator.hasNext()) {
        Card current = iterator.next();
        if (added.compareTo(current) <= 0) {
          iterator.previous();
          iterator.add(added);
          break;
        }
      }
      
      if (!iterator.hasNext()) {
        iterator.add(added);
      }

      if (record != null) {
        record.next();
        record.add(sorted);
        record.add(unsorted);
      }
    }
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred

    // ***********************************************************

    // return the sorted result here
    return sorted;
  }

/**
 * Running code
 * @param args the argumments
 */ public static void main(String[] args) {
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
      cards = InsertionSort.sort(cards, recorder);

      // We can print out the (un)sorted result:
      System.out.println(cards);

      // make window appear showing the record
      recorder.display("Card Sort Demo: InsertionSort");
  }
}
