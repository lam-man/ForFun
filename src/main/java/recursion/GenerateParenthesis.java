package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            ans.add(current);
            return;
        }

        if (open < max) {
            backtrack(ans, current+"(", open+1, close, max);
        }

        if (close < open) {
            backtrack(ans, current+")", open, close+1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generator = new GenerateParenthesis();
        generator.generateParenthesis(3);
    }
}
