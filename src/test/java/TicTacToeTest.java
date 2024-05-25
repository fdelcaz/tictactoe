import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TicTacToeTest {

  @Test
  public void playerXMustPlayFirst() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    assertEquals(TokenSymbol.X, board.getNextPlayer());
  }

  @Test
  public void aPlayerCannotMoveTwice() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);
    Movement firstMovement = new Movement(TokenSymbol.X, 0, 0);
    Movement secondMovement = new Movement(TokenSymbol.X, 1, 1);
    ticTacToeGame.addMovement(firstMovement);

    Exception exception = assertThrows(Exception.class, () -> ticTacToeGame.addMovement(secondMovement));
    assertEquals("A player cannot play two times in a row", exception.getMessage());
  }

  @Test
  public void player0GoesAfterPlayerX() throws Exception {

    TicTacToeBoard board = mock(TicTacToeBoard.class);
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);

    Movement firstMovement = new Movement(TokenSymbol.X, 0, 0);
    Movement secondMovement = new Movement(TokenSymbol.O, 1, 1);

    when(board.getNextPlayer())
      .thenReturn(TokenSymbol.X)
      .thenReturn(TokenSymbol.O);

    ticTacToeGame.addMovement(firstMovement);
    ticTacToeGame.addMovement(secondMovement);

    verify(board, times(2)).addMovement(any());
  }

  @Test
  public void aPlayerCannotPlayInAnOccupiedPosition() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);

    Movement firstMovement = new Movement(TokenSymbol.X, 0, 0);
    ticTacToeGame.addMovement(firstMovement);

    Movement secondMovement = new Movement(TokenSymbol.O, 0, 0);

    Exception exception = assertThrows(Exception.class, () -> ticTacToeGame.addMovement(secondMovement));
    assertEquals("Invalid position", exception.getMessage());
  }

  @Test
  public void playerXConquersFirstColumnWinsTheGame() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);

    Movement firstMovement = new Movement(TokenSymbol.X, 0, 0);
    ticTacToeGame.addMovement(firstMovement);

    Movement secondMovement = new Movement(TokenSymbol.O, 1, 0);
    ticTacToeGame.addMovement(secondMovement);

    Movement thirdMovement = new Movement(TokenSymbol.X, 0, 1);
    ticTacToeGame.addMovement(thirdMovement);

    Movement fourthMovement = new Movement(TokenSymbol.O, 2, 0);
    ticTacToeGame.addMovement(fourthMovement);

    Movement fifthMovement = new Movement(TokenSymbol.X, 0, 2);
    ticTacToeGame.addMovement(fifthMovement);

    assertEquals(GameStatus.PLAYER_X_WON, ticTacToeGame.getStatus());
  }

  @Test
  public void playerXConquersSecondColumnWinsTheGame() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);

    Movement firstMovement = new Movement(TokenSymbol.X, 1, 0);
    ticTacToeGame.addMovement(firstMovement);

    Movement secondMovement = new Movement(TokenSymbol.O, 0, 0);
    ticTacToeGame.addMovement(secondMovement);

    Movement thirdMovement = new Movement(TokenSymbol.X, 1, 1);
    ticTacToeGame.addMovement(thirdMovement);

    Movement fourthMovement = new Movement(TokenSymbol.O, 0, 2);
    ticTacToeGame.addMovement(fourthMovement);

    Movement fifthMovement = new Movement(TokenSymbol.X, 1, 2);
    ticTacToeGame.addMovement(fifthMovement);

    assertEquals(GameStatus.PLAYER_X_WON, ticTacToeGame.getStatus());
  }



  @Test
  public void gameIsInProgressIfNobodyWon() throws Exception {
    TicTacToeBoard board = new TicTacToeBoard();
    TicTacToeGame ticTacToeGame = new TicTacToeGame(board);

    Movement firstMovement = new Movement(TokenSymbol.X, 0, 0);
    ticTacToeGame.addMovement(firstMovement);

    assertEquals(GameStatus.IN_PROGRESS, ticTacToeGame.getStatus());
  }
}
