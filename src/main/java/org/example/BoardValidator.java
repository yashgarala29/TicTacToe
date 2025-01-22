package org.example;

public class BoardValidator {
    static boolean isValidPosition(int position, char[][] board) {
        int row = (position - 1) / 3;
        int column = (position - 1) % 3;
        if (position < 1 || position > 9 || board[row][column] == 'X' || board[row][column] == 'O') {
            return false;
        }
        return true;
    }
    static boolean isGameEnd(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        for (int i = 0; i < column; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return true;
        }
        return false;

    }
}
