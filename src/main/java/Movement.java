public class Movement {
  private final TokenSymbol player;
  private final int x;
  private final int y;

  public Movement(TokenSymbol player, int x, int y) {
    this.player = player;
    this.x = x;
    this.y = y;
  }

  public TokenSymbol getPlayer() {
    return this.player;
  }
}
