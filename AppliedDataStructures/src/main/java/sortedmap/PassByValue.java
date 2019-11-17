package sortedmap;

public class PassByValue {

  private void setNull(Object obj) {
    obj = null;
  }

  public static void main(String[] args) {
    PassByValue test = new PassByValue();
    SplitGame game = new SplitGame(new int[] {2,2});
    test.setNull(game);
    System.out.println(game.equals(null));
  }
}

