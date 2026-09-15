public class NQueenOneWay {
    public static char[][] chessBoard(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean  nQueens(char board[][], int row) {
        if (row >= board.length) {
            printBoard(board);
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens(board, row + 1)){
                    return true;
                }
                board[row][j] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char board[][], int row, int col) {

        //top
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // digonal left 
        for (int j = col, i = row; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //diagonal right 
        for (int j = col, i = row; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char board[][] = chessBoard(4);
        nQueens(board, 0);
    }
}
