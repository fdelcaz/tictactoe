import java.util.ArrayList;

public class TicTacToeBoard {
  private ArrayList<Movement> movements = new ArrayList<>();

  public void addMovement(Movement movement) throws Exception {

    boolean positionIsOccupied = movements.stream().anyMatch(x -> x.getX() == movement.getX() && x.getY() == movement.getY());

    if (positionIsOccupied){
      throw new Exception("Invalid position");
    }
    this.movements.add(movement);
  }

  public TokenSymbol getNextPlayer() {
    if (this.movements.isEmpty()){
      return TokenSymbol.X;
    }

    TokenSymbol lastPlayer = this.movements.get(this.movements.size()-1).getPlayer();
    if(lastPlayer == TokenSymbol.X){
      return TokenSymbol.O;
    }

    return TokenSymbol.X;
  }


  //Could de merged but I dont see a lot of value on it
  public boolean isTheColumnOccupiedByPlayer(int columnIndex, TokenSymbol player) {
    boolean firstXInColumn = isPositionOccupiedByPlayer(columnIndex, 0, player);
    boolean secondXInColumn = isPositionOccupiedByPlayer(columnIndex, 1, player);
    boolean thirdXInColumn = isPositionOccupiedByPlayer(columnIndex, 2, player);

    return firstXInColumn && secondXInColumn && thirdXInColumn;
  }

  public boolean isTheRowOccupiedByPlayer(int rowIndex, TokenSymbol player) {
    boolean firstYInColumn = isPositionOccupiedByPlayer(0, rowIndex, player);
    boolean secondYInColumn = isPositionOccupiedByPlayer(1, rowIndex, player);
    boolean thirdYInColumn = isPositionOccupiedByPlayer(2, rowIndex, player);

    return firstYInColumn && secondYInColumn && thirdYInColumn;
  }

  public boolean isFirstDiagonalOccupiedByPlayer(int rowIndex, TokenSymbol player) {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, 0, player);
    boolean OneOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, 1, player);
    boolean TwoTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(2, 2, player);

    return ZeroZeroIsOwnedByPlayerX && OneOneIsOwnedByPlayerX && TwoTwoIsOwnedByPlayerX;
  }

  public boolean isSecondDiagonalOccupiedByPlayer(int rowIndex, TokenSymbol player) {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(2, 0, player);
    boolean OneOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, 1, player);
    boolean TwoTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, 2, player);

    return ZeroZeroIsOwnedByPlayerX && OneOneIsOwnedByPlayerX && TwoTwoIsOwnedByPlayerX;
  }

  private boolean isPositionOccupiedByPlayer(int x, int y, TokenSymbol player) {
    return movements.stream().anyMatch(position -> position.getX() == x && position.getY() == y && position.getPlayer() == player);
  }
}
