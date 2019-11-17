package sortedmap;

/**
 * SplitGame: keep split an array into two and you get 1 point whenever
 * the sum of left sub-array and right sub-array has the same sum value.
 * Will find the best score for an input array.
 */
public class SplitGame {

  // input resource
  private int[] source;

  /**
   * Construct a new game.
   * @param source input array
   */
  public SplitGame(int[] source) {
    this.source = source;
  }

  /**
   * Play and return the best score for the input.
   * @return best score
   */
  public int getBestScore() {
    if (source == null || source.length == 0 || source.length == 1)
      return 0;
    return getScore(source, 0, source.length);
  }

  /**
   * Game logic function, keep split the array until find the best score.
   * @param input input array
   * @param start start index
   * @param end end index
   * @return best score
   */
  private int getScore(int[] input, int start, int end) {
    if (end - start <= 1)
      return 0;
    int splitIndex = equalSum(input, start, end);
    if (splitIndex == -1) {
      return 0;
    }
    int leftScore = getScore(input, start, splitIndex) + 1;
    int rightScore = getScore(input, splitIndex + 1, end) + 1;

    return leftScore > rightScore ? leftScore : rightScore;
  }

  /**
   * Check if sum(lfet-sub-array) == sum(right-sub-array). Return index if
   * true, otherwise return -1;
   *
   * @param input input array
   * @param start start index
   * @param end end index
   * @return index of split or -1
   */
  private int equalSum(int[] input, int start, int end) {
    for (int i = start; i < end; i++) {
      int leftSum = sumArray(input, start, i + 1);
      int rightSum = sumArray(input, i + 1, end);
      if (leftSum == rightSum)
        return i;
    }
    return -1;
  }

  /**
   * Sum an array from given start to end
   * @param input input array
   * @param start start index
   * @param end end index
   * @return sum
   */
  private int sumArray(int[] input, int start, int end) {
    int result = 0;
    for (int i = start; i < end; i++) {
      result += input[i];
    }
    return result;
  }

  public static void main(String[] args) {
//    int[] input = {4, 0, 1, 0, 1, 0, 1, 1};
//    int[] input = {3,3,3};
    int[] input = {2, 2, 2, 2};
    SplitGame game = new SplitGame(input);
    System.out.println(game.getBestScore());
  }
}
