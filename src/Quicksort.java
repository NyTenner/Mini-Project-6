import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Nye Tenerelli
 * @author Samuel A. Rebelsky
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  public <T> void swapper(T[] values, int v1, int v2)  {
    T val = values[v1];
    values[v1] = values[v2];
    values[v2] = val;
  }


  public <T> int quickSorter(T[] values, int l, int r, Comparator<? super T> order) {
    int piv = r;


    int rightIndex = r-1;
    int cur = l;
    while(cur <= rightIndex) {
      if (order.compare(values[cur], values[r]) >= 0) {
        swapper(values, cur, rightIndex);
        System.out.println(Arrays.toString(values) + "SWAPPPP");
        rightIndex--;
      }else{
        cur++;
      }
    }
    if (order.compare(values[rightIndex+1], values[r]) >= 0) {
    swapper(values, rightIndex+1, r);
    }
    return rightIndex+1;
      
  } // Quicksort()

  public <T> void sort(T[] values, int l, int r, Comparator<? super T> order, int n) {
    if (l >= r || n > 15){
      return;
    } else {
      System.out.println(Arrays.toString(values) + "Here  " + l + " " + r);
      int m = quickSorter(values, l, r, order);
      System.out.println(Arrays.toString(values) + "Here  " + l + " " + m + " " + r);
      sort(values, l, m-1, order, n++);
      sort(values, m+1, r, order, n++);

    }
      
  } 
  
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, 0, values.length-1, order, 0);
  } // sort(T[], Comparator<? super T>
} // class Quicksort
