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
}
