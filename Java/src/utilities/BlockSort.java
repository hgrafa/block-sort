package utilities;

import java.util.Arrays;
// import java.util.Comparator;

public class BlockSort {

  // atributos
  Integer[] array;

  // construtor
  public BlockSort(Integer[] array){
    this.array = array;
  }

  // 
  public Integer[] getArray() {
    return array;
  }

  // 
  private void rotate(int start, int end) {
    int middlePosition = (start + end) / 2;

    for (int i = start, j = end; i <= middlePosition; i++, j--) {
      Integer temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  // 
  public int floorPowerOfTwo(int value) {
    // pos and the negative pos shifted by 1
    // example 110 and 111 = 100
    return value & ~(value >> 1);
  }


  public void merge(Integer[] array, Integer[] left, Integer[] right,
      int start, int mid, int end) {

    int leftIterator = 0,
        rightIterator = 0,
        arrayIterator = start;

    // escolhe o menor de cada frente
    while (leftIterator != mid - 1 || rightIterator != end) {
      array[arrayIterator++] = (left[leftIterator] < right[rightIterator]) ?
                               left[leftIterator++] :
                               right[rightIterator++];
    }

    // esvazia o que sobrou a esquerda
    while(leftIterator != mid - 1) {
     array[arrayIterator++] = left[leftIterator++];
    }

    // esvazia o que sobrou a direita
    while(leftIterator != end) {
      array[arrayIterator++] = right[rightIterator++];
    }

  }

  public void sort() {
    int powerOfTwo = floorPowerOfTwo(array.length);
    int denominator = powerOfTwo / 16;
    int numeratorStep = array.length % denominator;
    int integerStep = (int) Math.floor(array.length / denominator);

    System.out.println("power of two = " + powerOfTwo);
    System.out.println("integer step = " + integerStep);

    while (integerStep < array.length) {

      System.out.println("here");

      int numerator = 0, integerPart = numerator;

      while (integerPart < array.length) {
        int start = integerPart;

        integerPart += integerStep;
        numerator += numeratorStep;

        if (numerator > denominator) {
          numerator -= denominator;
          integerPart++;
        }

        int middle = integerPart;

        integerPart += integerStep;
        numerator += numeratorStep;

        if (numerator >= denominator) {
          numerator -= denominator;
          integerPart++;
        }

        int end = integerPart;

        if (Integer.compare(array[end - 1], array[start]) > 0) {
          Integer[] left = Arrays.copyOfRange(array, start, middle);
          Integer[] right = Arrays.copyOfRange(array, middle, end);
          merge(array, left, right, start, middle, end);
        } else
          rotate(array[middle - 1], array[middle + 1]);

        integerStep *= 2;
        numeratorStep *= 2;
        if (numeratorStep > denominator) {
          numeratorStep -= denominator;
          integerStep++;
        }

      } 
    }

  }


}
