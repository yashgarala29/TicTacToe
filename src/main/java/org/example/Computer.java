package org.example;

public class Computer implements Player {
    private final String playerName;
    private char symbol;

    public Computer() {
        this.playerName = "Computer";
        this.symbol = 'O';
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public void play(char[][] board) {
        int position;
        position = getSmartMove(board);
        if (position == -1 || BoardValidator.isValidPosition(position, board)) {
            return;
        }
        int row = (position - 1) / 3;
        int column = (position - 1) % 3;
        board[row][column] = symbol;


    }

    private int getSmartMove(char[][] board) {
        for (int i = 1; i <= 9; i++) {
            if (canWin(i, board, symbol)) {
                return i;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (canWin(i, board, 'X')) {
                return i;
            }
        }
        while (true) {
            int position = (int) (Math.random() * 9) + 1;
            if (BoardValidator.isValidPosition(position, board)) {
                return position;
            }
        }

    }

    private boolean canWin(int position, char[][] board, char symbol) {
        int row = (position - 1) / 3;
        int column = (position - 1) % 3;
        if (board[row][column] != 'X' && board[row][column] != 'O') {
            board[row][column] = symbol;
            if (BoardValidator.isGameEnd(board, board.length, board[0].length)) {
                board[row][column] = (char) (position + '0');
                return true;
            }
            board[row][column] = (char) (position + '0');
        }
        return false;
    }
}

