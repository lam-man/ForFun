package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort sort;
    private int[] input;

    @BeforeEach
    public void setUp() {
        sort = new QuickSort();
        input = new int[] {1,5,3,2,4,7,6,8};
    }

    @Test
    public void testPartition() {
        sort.partition(input, 0, input.length - 1);
    }
}