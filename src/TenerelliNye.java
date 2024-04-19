import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/**
 * Sort by finding the smallest element, and setting it to the earliet index that doesnt already have a given.
 *
 * @author Nye Tenerelli
 */

public class TenerelliNye implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one/**
 *
 */
  public static Sorter SORTER = new TenerelliNye();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  TenerelliNye() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  public <T> void TenerelliNye(T[] values, Comparator<? super T> order) {
    int min = 0;
    for (int j = 0; j < values.length; j++) {
      min = j;
      for (int i = j; i < values.length; i++) {
        if(order.compare(values[min], values[j]) < 1) {
          min = j;
        }
      }
      values[j] = values[min];
    }

  } // FakeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    TenerelliNye(values, order);
  } // sort(T[], Comparator<? super T>

} // class MergeSort
