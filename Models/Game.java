import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Board board;
    Player currPlayer;

    public Game (Player p1 , Player p2 , int size) {
        this.p1 = p1;
        this.p2 = p2;
        currPlayer = p1;
        this.board = new Board(size);
    }

    public String startGame() {
        Boolean noWinner = true;
        while(noWinner){
            board.display();
            if(board.isEmpty() == false){
                noWinner = false;
                continue;
            }

            System.out.print("Player: " + currPlayer.name + " " + "Enter row,column: ");
            @SuppressWarnings("resource")
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inpRow = Integer.valueOf(values[0]);
            int inpCol = Integer.valueOf(values[1]);

            if(board.isEmptyCell(inpRow, inpCol) == false) {
                System.out.print("Incorrect position chosen , try again");
                currPlayer = currPlayer == p1 ? p1 : p2;
                continue;
            }

            board.placePiece(inpRow, inpCol, currPlayer.piece);
            boolean winner = board.isWin(currPlayer.piece);
            if(winner) {
                inputScanner.close();
                return currPlayer.name;
            }
            currPlayer = currPlayer == p1 ? p2 : p1;
        }
        return "tie";
    }
}
