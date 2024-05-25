import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeGame {

  private final TicTacToeBoard board;
  List<TokenSymbol> players = new ArrayList<>(Arrays.asList(TokenSymbol.X, TokenSymbol.O));

  public TicTacToeGame(TicTacToeBoard board) {
    this.board = board;
  }

  public void addMovement(Movement movement) throws Exception {
    if (getStatus() != GameStatus.IN_PROGRESS) {
      throw new Exception("The game is already won");
    }

    TokenSymbol nextPlayer = board.getNextPlayer();

    if (movement.getPlayer() != nextPlayer) {
      throw new Exception("A player cannot play two times in a row");
    }

    if (movement.getX() < 0 || movement.getX() > 2)
      throw new Exception("Position out of boundaries");

    if (movement.getY() < 0 || movement.getY() > 2)
      throw new Exception("Position out of boundaries");

    board.addMovement(movement);
  }

  public GameStatus getStatus() {

    GameStatus winnerStatus = getWinner();
    if (winnerStatus != null) {
      return winnerStatus;
    }

    if (!board.anyMovementsLeft()) {
      return GameStatus.GAME_OVER;
    }

    return GameStatus.IN_PROGRESS;
  }

  private GameStatus getWinner() {
    TokenSymbol winner = getPlayerOwningAColumn();
    if (winner != null) {
      if (winner == TokenSymbol.X)
        return GameStatus.PLAYER_X_WON;
      return GameStatus.PLAYER_O_WON;
    }

    winner = getPlayerOwningARow();
    if (winner != null) {
      if (winner == TokenSymbol.X)
        return GameStatus.PLAYER_X_WON;
      return GameStatus.PLAYER_O_WON;
    }

    winner = getPlayerOwningADiagonal();
    if (winner != null) {
      if (winner == TokenSymbol.X)
        return GameStatus.PLAYER_X_WON;
      return GameStatus.PLAYER_O_WON;
    }
    return null;
  }

  private TokenSymbol getPlayerOwningAColumn() {
    for (TokenSymbol player : players) {
      for (int x = 0; x <= 2; x++) {
        if (board.isTheColumnOccupiedByPlayer(x, player))
          return player;
      }
    }
    return null;
  }

  private TokenSymbol getPlayerOwningARow() {
    for (TokenSymbol player : players) {
      for (int y = 0; y <= 2; y++) {
        if (board.isTheRowOccupiedByPlayer(y, player))
          return player;
      }
    }
    return null;
  }

  private TokenSymbol getPlayerOwningADiagonal() {
    for (TokenSymbol player : players) {
      if (board.isFirstDiagonalOccupiedByPlayer(player))
        return player;
      if (board.isSecondDiagonalOccupiedByPlayer(player))
        return player;
    }
    return null;
  }

}
