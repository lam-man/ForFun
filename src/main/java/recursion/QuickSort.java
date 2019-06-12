package recursion;

public class QuickSort {

    public void quickSort(int[] input) {
        int n = input.length;
        qSort(input, 0, n - 1);
    }

    private void qSort(int[] input, int lo, int hi) {
        if (lo < hi) {
            int p = partition(input, lo, hi);
            qSort(input, lo, p - 1);
            qSort(input, p + 1, hi);
        }
    }

    public int partition(int[] input, int lo, int hi) {
        int pivot = input[hi];
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (input[j] < pivot) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            }
        }
        int temp = input[i];
        input[i] = input[hi];
        input[hi] = temp;
        return i;
    }
}
