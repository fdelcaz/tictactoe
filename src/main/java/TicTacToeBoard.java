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

  public boolean isFirstColumnOccupiedByPlayerX() {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, 0, TokenSymbol.X);
    boolean ZeroOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, 1, TokenSymbol.X);
    boolean ZeroTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(0, 2, TokenSymbol.X);

    return ZeroZeroIsOwnedByPlayerX && ZeroOneIsOwnedByPlayerX && ZeroTwoIsOwnedByPlayerX;
  }

  public boolean isSecondColumnOccupiedByPlayerX() {
    boolean ZeroZeroIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, 0, TokenSymbol.X);
    boolean ZeroOneIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, 1, TokenSymbol.X);
    boolean ZeroTwoIsOwnedByPlayerX = isPositionOccupiedByPlayer(1, 2, TokenSymbol.X);

    return ZeroZeroIsOwnedByPlayerX && ZeroOneIsOwnedByPlayerX && ZeroTwoIsOwnedByPlayerX;
  }

  private boolean isPositionOccupiedByPlayer(int x, int y, TokenSymbol player) {
    return movements.stream().anyMatch(position -> position.getX() == x && position.getY() == y && position.getPlayer() == player);
  }
}
