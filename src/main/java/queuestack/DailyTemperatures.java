package queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            ans[i] = stack.size() > 0 ? stack.peek() - i : 0;
            stack.push(i);
        }
        return ans;
    }
}
