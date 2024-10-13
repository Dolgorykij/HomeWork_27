import org.example.Exception.ItemIsNullException;
import org.example.Exception.ItemNotFoundException;
import org.example.IntegerListService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerListServiceTest {

    IntegerListService IntegerListService = new IntegerListService();

    @Test
    public void testAddItem() {
        Integer[] testArray;
        testArray = new Integer[6];
        testArray[0] = 1;
        testArray[1] = 2;
        var expected = testArray;
        IntegerListService.add(1);
        IntegerListService.add(1, 2);
        var actual = IntegerListService.toString();
        assertThat(actual.toString().contains(expected.toString()));
    }
    @Test
    public void testAddIndex() {
        Integer[] testArray;
        testArray = new Integer[6];
        testArray[0] = 1;
        testArray[1] = 2;
        var expected = testArray;
        IntegerListService.add(0, 1);
        IntegerListService.add(1, 2);
        var actual = IntegerListService.toString();
        assertThat(actual.toString().contains(expected.toString()));
    }

    @Test
    public void testItemIsNull() {
        assertThrows(ItemIsNullException.class,() -> IntegerListService.add(null));
    }
    @Test
    public void testSet () {
        Integer[] testArray;
        testArray = new Integer[6];
        testArray[0] = 1;
        testArray[1] = 4;
        testArray[2] = 3;
        IntegerListService.add(0,1);
        IntegerListService.add(1,2);
        IntegerListService.add(2,3);
        IntegerListService.set(1,4);
        assertThat(Arrays.toString(testArray).equals(IntegerListService.toString()));
    }

    @Test
    public void testRemoveItem () {
        Integer[] testArray;
        testArray = new Integer[6];
        testArray[0] = 1;
        testArray[1] = 3;
        IntegerListService.add(0,1);
        IntegerListService.add(1,2);
        IntegerListService.add(2,3);
        IntegerListService.remove(2);
        assertThat(Arrays.toString(testArray).equals(IntegerListService.toString()));
    }
    @Test
    public void testRomeveIndex () {
        Integer[] testArray;
        testArray = new Integer[6];
        testArray[0] = 1;
        testArray[1] = 3;
        IntegerListService.add(0,1);
        IntegerListService.add(1,2);
        IntegerListService.add(2,3);
        IntegerListService.remove(1);
        assertThat(Arrays.toString(testArray).equals(IntegerListService.toString()));
    }
}
