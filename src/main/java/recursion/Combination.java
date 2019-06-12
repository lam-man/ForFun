package recursion;

import java.util.*;

public class Combination {

    private List<List<Integer>> output = new LinkedList();
    private int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<Integer>());
        return output;
    }

    private void backTrack(int first, LinkedList<Integer> current) {
        if (current.size() == k) {
            output.add(new LinkedList(current));
        }

        for (int i = first; i <= n; i++) {
            current.add(i);
            backTrack(i + 1, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Combination comb = new Combination();
        List<List<Integer>> result = comb.combine(4, 2);
    }
}
