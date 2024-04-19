import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Nye Tenerelli
 * @author Samuel A. Rebelsky
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  public <T> void InsertionSort(T[] values, Comparator<? super T> order) {
    for (int i = 1; i < values.length; i++) {
      if (order.compare(values[i-1],  values[i]) > 0){
        T val = values[i];
        values[i] = values[i-1];
        values[i-1] = val;

        if(i > 1) {
          i = i-2;
        } else {
          i = i-1;
        }
      } 

    }
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    InsertionSort(values, order);
  } 
} // class InsertionSort
