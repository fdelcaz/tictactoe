import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
  private List<Movement> movements = new ArrayList<>();

  public void addMovement(Movement movement) throws Exception {
    if(movement.getPlayer() == TokenSymbol.O){
      throw new Exception("Player X should move first");
    }

    storeMovement(movement);
  }

  public void storeMovement(Movement movement) {

  }

  public List<Movement> getMovements() {
    return movements;
  }
}
