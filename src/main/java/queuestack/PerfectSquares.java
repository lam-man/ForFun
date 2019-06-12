package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    public int numSquares(int n) {
        int nSqrt = (int) Math.sqrt(n), level = 0;
        boolean[] visited = new boolean[n];
        int[] perfectSquares = new int[nSqrt];

        for (int i = 1; i <= nSqrt; i++) {
            perfectSquares[i-1] = i*i;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                for (int pSquare : perfectSquares) {
                    int remain = num - pSquare;
                    if (remain == 0) {
                        return level;
                    } else if( remain > 0 && !visited[remain-1]) {
                        visited[remain - 1] = true;
                        q.offer(remain);
                    } else if (remain < 0) {
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
