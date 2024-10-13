package org.example;

import org.example.Exception.IndexOutOfSizeException;
import org.example.Exception.ItemIsNullException;
import org.example.Exception.ItemNotFoundException;

import java.util.Arrays;

public class IntegerListService implements IntegerList{

    private final Integer[] massive;
    private int size;


    public IntegerListService () {
        massive = new Integer[6];
    }
    public IntegerListService (int DEFAULT_MASSIVE_SIZE) {
        massive = new Integer[DEFAULT_MASSIVE_SIZE];
    }
    private void checkItemIsNull (Integer item) {
        if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
    }
    private void checkIndexOutOfSize (int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfSizeException("Индекс вне массива");
        }
    }

    @Override
    public Integer add(Integer item) {
        massive[size] = item;
        checkItemIsNull(item);
        size ++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItemIsNull(item);
        if (index == size) {
            massive[size++] = item;
            return item;
        }
        System.arraycopy(massive,index,massive,index + 1,size - index);
        massive[index] = item;
        size++;
        return item;
        //massive[index] = item;
        //if (index < 0 || index >= size) {
        //throw new IndexOutOfSizeException("Индекс вне массива");
        //}
        //else if (item == null) {
        //throw new ItemIsNullException("Item не может быть Null");
        //}
        //return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndexOutOfSize(index);
        checkItemIsNull(item);
        massive[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) throws ItemNotFoundException {
        checkItemIsNull(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException("Элемент не найден");
        }
        if (index == size) {
            massive[size--] = null;
            return item;
        }
        System.arraycopy(massive,index + 1,massive, index, size - index);
        size--;

        return item;
    }

    @Override
    public Integer remove(int index) throws ItemNotFoundException {
        checkIndexOutOfSize(index);
        if (index == -1) {
            throw new ItemNotFoundException("Элемент не найден");
        }
        Integer item = massive[index];
        if (index == size) {
            massive[size--] = null;
            return item;
        }
        System.arraycopy(massive,index + 1,massive, index, size - index);
        size--;

        return item;
    }

    private int containsItem (Integer item) {
        int itemIndex = -1;
        for (int i = 0; i < size; i++) {
            if (massive[i].equals(item)) {
                itemIndex = i;
            }
        }
        return itemIndex;
    }
    @Override
    public boolean contains(Integer item) {
        Integer[] massiveCopy = toArray();
        sortInsertion(massiveCopy);
        return binary(massiveCopy,item);
        //int itemIndex = containsItem(item);
        //if (item == null) {
        //  throw new ItemIsNullException("Item не может быть Null");
        //}
        //if (itemIndex != -1) {
        //   return true;
        //} else {
        //  throw new ItemNotFoundException("Элемент не найден");
        //}
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = massive[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size; i >= 0; i--) {
            Integer s = massive[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndexOutOfSize(index);
        return massive[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        for (int i = 0; i < size; i++) {
            if (this.get(i) != otherList.get(i))
                return false;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(massive, size);
    }

    @Override
    public String toString() {
        return "IntegerListService{" +
                "massive=" + Arrays.toString(massive) +
                ", size=" + size +
                '}';
    }
    private static void swapElements(Integer [] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    //public static void sortBubble(Integer [] massive) {
    //  for (int i = 0; i < massive.length - 1; i++) {
    //      for (int j = 0; j < massive.length - 1 - i; j++) {
    //          if (massive[j] > massive[j + 1]) {
    //              swapElements(massive, j, j + 1);
    //           }
    //      }
    //  }
    //}
    //public static void sortSelection(Integer[] massive) {
    //for (int i = 0; i < massive.length - 1; i++) {
    //      int minElementIndex = i;
    //      for (int j = i + 1; j < massive.length; j++) {
    //          if (massive[j] < massive[minElementIndex]) {
    //              minElementIndex = j;
    //          }
    //      }
    //      swapElements(massive, i, minElementIndex);
    //  }
    //}
    public static void sortInsertion(Integer[] massive) {
        for (int i = 1; i < massive.length; i++) {
            int temp = massive[i];
            int j = i;
            while (j > 0 && massive[j - 1] >= temp) {
                massive[j] = massive[j - 1];
                j--;
            }
            massive[j] = temp;
        }
    }
    public static boolean binary(Integer[] massive, Integer item) {
        int min = 0;
        int max = massive.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == massive[mid]) {
                return true;
            }

            if (item < massive[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}