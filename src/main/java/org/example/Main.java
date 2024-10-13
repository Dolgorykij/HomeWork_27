package org.example;

import java.util.Arrays;
import java.util.Random;

import static org.example.IntegerListService.*;

public class Main {
    public static void main(String[] args) {
        IntegerListService integerListService = new IntegerListService();


        int length = 100000;
        Integer[] nums = new Integer [length];
        Random random = new Random();
        for (int i = 0; i < length; i++)
            nums[i] = random.nextInt(100);

        //long start = System.currentTimeMillis();
        //sortBubble(nums);
        //System.out.println(System.currentTimeMillis() - start);    //24728   //24933
        //Integer [] nums2 = Arrays.copyOf(nums, 100000);
        //long start1 = System.currentTimeMillis();
        //sortSelection(nums2);
        //System.out.println(System.currentTimeMillis() - start1);//1488  //1487
        //Integer [] nums3 = Arrays.copyOf(nums2, 100000);
        long start = System.currentTimeMillis();
        sortInsertion(nums);
        System.out.println(System.currentTimeMillis() - start); //115  // 116 //124
    }
}

