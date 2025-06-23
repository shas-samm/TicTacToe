public class Board {
    public int size;
    public Cell[][] cells;

    public Board (int size){
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard () {
        for(int i=0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                cells[i][j] = new Cell();
            }
        }
    }

    public boolean isEmptyCell (int row , int col) {
        return cells[row][col].piece == null;
    }

    public boolean isEmpty() {
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                if(cells[i][j].piece == null) return true;
            }
        }
        return false;
    }

    public void placePiece (int row , int col , PlayingPiece piece) {
        cells[row][col].piece = piece;
    }

    public boolean isWin (PlayingPiece piece) {
        // row check
        for(int i = 0 ; i < size ; i++){
            boolean rowWin = true;
            for(int j = 0 ; j < size ; j++){
                if(cells[i][j].piece != piece) {
                    rowWin = false;
                    break;
                }
            }
            if(rowWin == true) return true;
        }
        // column check
        for(int j = 0 ; j < size; j++){
            boolean colWin = true;
            for(int i = 0 ; i < size ; i++){
                if(cells[i][j].piece != piece) {
                    colWin = false;
                    break;
                }
            }
            if(colWin == true) return true;
        }
        // diagonals check
        boolean diag1 = true , diag2 = true;
        for(int i = 0 ; i < size ; i++){
            if(cells[i][i].piece != piece) diag1 = false;
            if(cells[i][size - i - 1].piece != piece) diag2 = false;
        }

        return diag1 || diag2;
    }

    public void display () {
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                if(cells[i][j].piece != null) {
                    System.out.print(cells[i][j].piece);
                }
                else{
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
