import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
  private List<Movement> movements = new ArrayList<>();

  public void addMovement(Movement movement) throws Exception {
    throw new Exception("Player X should move first");
  }
}
