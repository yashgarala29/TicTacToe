package org.example;

import java.util.Scanner;

public class User implements Player {
    private final String playerName;
    private final char symbol;
    public User(String playerName, char symbol){
        this.playerName=playerName;
        this.symbol=symbol;
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
        Scanner sc=new Scanner(System.in);
        System.out.println(playerName+" enter your position");
        while (true){
            String pos=sc.nextLine();
            int position=0;
            try {
                position=Integer.parseInt(pos);
            }
            catch (NumberFormatException e){
                System.out.println("Invalid position, please enter again");
                continue;
            }
            if(BoardValidator.isValidPosition(position,board)){
                int row=(position-1)/3;
                int column=(position-1)%3;
                board[row][column]=symbol;
                break;
            }
            else{
                System.out.println("Invalid position, please enter again");
            }
        }
    }
}
