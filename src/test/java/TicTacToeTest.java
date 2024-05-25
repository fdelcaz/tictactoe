import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TicTacToeTest {

  @Test
  public void playerOCannotMoveFirst() {
    TicTacToeGame ticTacToeGame = new TicTacToeGame();

    Exception exception = assertThrows(Exception.class, () -> ticTacToeGame.addMovement(new Movement(TokenSymbol.O, 0, 0)));
    assertEquals("Player X should move first", exception.getMessage());
  }

  @Test
  public void playerXCanMoveFirst() throws Exception {
    TicTacToeGame ticTacToeGame = new TicTacToeGame();
    Movement movement = new Movement(TokenSymbol.X, 0, 0);
    ticTacToeGame.addMovement(movement);

    ArrayList<Movement> movements = (ArrayList<Movement>) ticTacToeGame.getMovements();
    assertEquals(movements, ticTacToeGame.getMovements());
  }
}
