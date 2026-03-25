import java.util.Collections;

public class LinearSearch {

  public static boolean search(CardPile cards, Card target) {
    return search(cards, target, null);
  }

  public static boolean search(CardPile cards, Card target, SortRecorder record) {

    if (record != null) {
      record.add(cards);
    }

    for (Card card : cards) {
      if (card.compareTo(target) == 0) {
        return true;
      }

    if (record != null) {
      record.next();
      record.add(cards);
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
    Card card = cards.get(5);
    LinearSearch.search(cards, card, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: LinearSearch");
  }
}
