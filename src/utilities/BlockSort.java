package utilities;

public class BlockSort<T> {
  
  T[] array;
  Comparable<T> compare;

  public BlockSort(T[] array){
    this.array = array;
  } 

  public BlockSort(T[] array, Comparable<T> compare){
    this.array = array;
    this.compare = compare;
  } 

  private void reverse(int start, int end){
    int middlePosition = (start + end) / 2 ;

    for(int i = start, j = end; i <= middlePosition; i++, j--){      
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  private int floorPowerOfTwo(int value){
    // pos and the negative pos shifted by 1
    // example 110 and 111 = 100 
    return value & ~(value>>1);
  }

  public T[] getArray() {
    return array;
  }

  public void sort(){
    int powerOfTwo = floorPowerOfTwo(array.length);
    

  }

  public static void main(String[] args) {

    Integer[] v = {0, 1, 2, 6, 5, 4, 3, 7, 8};
    BlockSort<Integer> block = new BlockSort<>(v);
    
    for(Integer integer : block.getArray()) System.out.print(integer + " ");
    System.out.println();

    block.reverse(3, 10);

    for(Integer integer : block.getArray()) System.out.print(integer + " ");
    System.out.println();

  }

}
