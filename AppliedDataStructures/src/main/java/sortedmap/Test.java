package sortedmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

  public static class Pair {
    private int workerIndex;
    private int bikeIndex;
    private int distance;

    public int getWorkerIndex() {
      return workerIndex;
    }

    public int getBikeIndex() {
      return bikeIndex;
    }

    public int getDistance() {
      return distance;
    }

    public Pair(int workerIndex, int bikeIndex, int distance) {
      this.workerIndex = workerIndex;
      this.bikeIndex = bikeIndex;
      this.distance = distance;
    }

    public String toString() {
      return "workerIndex: " + workerIndex + " bikeIndex: " + bikeIndex + " distance: " + distance;
    }

  }

  public static void main(String[] args) {
    Comparator<Pair> myComp =
        Comparator.comparing(Pair::getDistance)
        .thenComparing(Pair::getBikeIndex)
        .thenComparing(Pair::getWorkerIndex);

    Pair pair3 = new Pair(3, 2, 1);
    Pair pair2 = new Pair(4, 5, 6);
    Pair pair1 = new Pair(9, 8, 7);

    List<Pair> pairs = new ArrayList<>();
    pairs.add(pair1);
    pairs.add(pair2);
    pairs.add(pair3);

    System.out.println(pairs.toString());
    pairs.sort(myComp);
    System.out.println(pairs.toString());
  }
}
