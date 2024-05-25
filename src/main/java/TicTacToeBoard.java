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

  public boolean isTheColumnOccupiedByPlayer(int columnIndex, TokenSymbol player) {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(columnIndex, 0, player);
    boolean ZeroOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(columnIndex, 1, player);
    boolean ZeroTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(columnIndex, 2, player);

    return ZeroZeroIsOwnedByPlayerX && ZeroOneIsOwnedByPlayerX && ZeroTwoIsOwnedByPlayerX;
  }

  public boolean isTheRowOccupiedByPlayer(int rowIndex, TokenSymbol player) {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, rowIndex, player);
    boolean ZeroOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, rowIndex, player);
    boolean ZeroTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(2, rowIndex, player);

    return ZeroZeroIsOwnedByPlayerX && ZeroOneIsOwnedByPlayerX && ZeroTwoIsOwnedByPlayerX;
  }

  private boolean isPositionOccupiedByPlayer(int x, int y, TokenSymbol player) {
    return movements.stream().anyMatch(position -> position.getX() == x && position.getY() == y && position.getPlayer() == player);
  }
}
