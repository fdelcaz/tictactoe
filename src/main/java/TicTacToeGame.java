public class TicTacToeGame {

  private final TicTacToeBoard board;

  public TicTacToeGame (TicTacToeBoard board){
    this.board = board;
  }

  public void addMovement(Movement movement) throws Exception {
    TokenSymbol nextPlayer = board.getNextPlayer();
    if(movement.getPlayer() != nextPlayer){
      throw new Exception("A player cannot play two times in a row");
    }

    board.addMovement(movement);
  }

  public GameStatus getStatus() {

    if(board.isTheColumnOccupiedByPlayer(0, TokenSymbol.X)
      || board.isTheColumnOccupiedByPlayer(1, TokenSymbol.X)
      || board.isTheColumnOccupiedByPlayer(2, TokenSymbol.X)
      || board.isTheColumnOccupiedByPlayer(0, TokenSymbol.O)
      || board.isTheColumnOccupiedByPlayer(1, TokenSymbol.O)
      || board.isTheColumnOccupiedByPlayer(2, TokenSymbol.O))
        return GameStatus.PLAYER_X_WON;

    return GameStatus.IN_PROGRESS;
  }
}
