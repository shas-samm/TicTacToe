// This is a simple tictactoe game
// this project helps to understand some basics of java also
public class Main {
    public static void main(String a[]) {
        Player p1 = new Player("Alice", PlayingPiece.O);
        Player p2 = new Player("Bob" , PlayingPiece.X);
        Game game = new Game(p1, p2, 3);
        System.out.print("game winner is: " + game.startGame());
    }
}
