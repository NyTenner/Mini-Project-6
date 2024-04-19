import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/**
 * Sort using merge sort.
 *
 * @author Nye Tenerelli
 * @author Samuel A. Rebelsky
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  public <T> void merge(T[] values, int l, int m, int r, Comparator<? super T> order) {

    T[] array = Arrays.copyOfRange(values, 0, values.length);
    int leftIndex = l;
    int rightIndex = m+1;
    int cur = l;

    while (leftIndex < m+1 && rightIndex < r+1){
      if (order.compare(values[leftIndex], values[rightIndex]) < 1){
        array[cur++] = values[leftIndex++];

      } else {
        array[cur++] = values[rightIndex++];
      }
    }

    while (leftIndex < m+1){
      array[cur++] = values[leftIndex++];
    }

    while (rightIndex < r+1){
      array[cur++] = values[rightIndex++];
    }

    for (int i = l; i < r+1; i++){
      values[i] = array[i];
    }
  }

  // public <T> void values(T[] values){
  //   for (int i = 0; i < values.length; i++) {
  //     System.out.print(values[i] + ", ");
  //   }
  //   System.out.println("LINE");, "charlie", "bravo", "alpha"
  // }

  public <T> void sorter(T[] values, int l, int r, Comparator<? super T> order) {
    int m = (l+r)/2;
    if (l >= r){
      return;
    }
    sorter(values, l, m, order);
    sorter(values, m+1, r, order);
    merge(values, l, m, r, order);
    // values(values);
  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sorter(values, 0, values.length-1, order);
  } // sort(T[], Comparator<? super T>

} // class MergeSort
