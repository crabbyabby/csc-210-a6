import java.util.Collections;

/**
 * Class for quicksort. 
 * Choose a pivot, then sort into two piles,
 * smaller than pivot or bigger than pivot,
 * then combine.
 * 
 * @author Abigail Lei
 * @version March 2026
 */
public class Quicksort {
  
  /**
   * Quicksort without recorder
   * @param unsorted pile of cards
   * @return sorted pile of cards
   */
  public static CardPile sort(CardPile unsorted) {
    return sort(unsorted, null);
  }

  /**
   * Quicksort with recorder
   * @param unsorted pile of cards
   * @param record the recorder for visuals
   * @return sorted pile of cards
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    if (record != null) {
      record.add(unsorted);
    }

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************

    if (unsorted.size() <= 1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************

    Card pivot = unsorted.removeFirst();

    while (unsorted.size() > 0) {
      Card card = unsorted.removeFirst();
      if (card.compareTo(pivot) < 0) {
        smaller.add(card);
      } else {
        bigger.add(card);
      }
    }

    // register the partitions with the recorder
    if (record != null) {
      record.add(smaller);
      record.add(pivot);
      record.add(bigger);
      record.next();
    }

    CardPile sortedSmaller = sort(smaller, record);
    CardPile sortedBigger = sort(bigger, record);

    // This will hold the assembled result
    CardPile result = new CardPile();
    result.addAll(sortedSmaller);
    result.add(pivot);
    result.addAll(sortedBigger);

    // record sorted result
    if (record != null) {
      record.add(result);
      record.next();
    }

    // return sorted result here
    return result;
  }

  /**
   * beautiful testing
   * @param args more testing
   */
  public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();

    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    Collections.shuffle(cards);

    cards = Quicksort.sort(cards, recorder);

    System.out.println(cards);

    recorder.display("Card Sort Demo: Quicksort");
  }
}
