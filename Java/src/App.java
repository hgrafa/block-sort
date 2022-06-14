import java.util.Scanner;

import utilities.BlockSort;

public class App {
    public static void main(String[] args) throws Exception {

        Integer[] v = {0, 1, 2, 6, 5, 4, 3, 7, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
        BlockSort block = new BlockSort(v);

        System.out.println(63 >> 1);


        System.out.println(v.length + " = " + block.floorPowerOfTwo(v.length));

        for(Integer integer : block.getArray()) System.out.print(integer + " ");
        System.out.println();
    
        block.sort();

        for(Integer integer : block.getArray()) System.out.print(integer + " ");
        System.out.println();
    
      }
}
