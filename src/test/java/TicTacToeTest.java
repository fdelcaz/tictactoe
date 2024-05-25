import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {

  @Test
  public void testPlayerXAlwaysGoesFirst() {
    TicTacToeGame ticTacToeGame = new TicTacToeGame();
    Player player = new Player(TokenSymbol.O);

    Exception exception = assertThrows(Exception.class, () -> ticTacToeGame.addMovement(new Movement(player, 0, 0)));
    assertEquals("Player X should move first", exception.getMessage());
  }
}
