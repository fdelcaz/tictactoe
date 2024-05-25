import java.util.ArrayList;

public class TicTacToeBoard {
  private ArrayList<Movement> movements = new ArrayList<>();

  public void addMovement(Movement movement) {
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
}
