package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private final int row=3;
    private final int column=3;
    private char[][] board;
    private List<Player> players;
    public TicTacToeGame(){
        initializeBoard();
        players=new ArrayList<>();
    }
    private void initializeBoard(){
        board=new char[row][column];
        char count='1';
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                board[i][j]=count++;
            }
        }
    }
    public void initializePlayers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Game Type");
        System.out.println("1. Computer vs User");
        System.out.println("2. User vs User");
        int choice=0;
        try {
            String cho=sc.nextLine();
            choice=Integer.parseInt(cho);
        }catch (NumberFormatException e){
            System.out.println("Invalid choice, please enter again");
            return;
        }
        String player1,player2;
        switch (choice){
            case 1:
                System.out.println("Computer vs User");
                System.out.println("Enter User Name");
                player1=sc.nextLine();
                players.add(new User(player1,'X'));
                players.add(new Computer());
                break;
            case 2:
                System.out.println("User vs User");
                System.out.println("Enter Player 1 Name");
                player1=sc.nextLine();
                players.add(new User(player1,'X'));
                System.out.println("Enter Player 2 Name");
                player2=sc.nextLine();
                players.add(new User(player2,'O'));

                break;
            default:
                System.out.println("Invalid choice, please enter again");

        }
    }
    public void startGame(){
        int playerTurn=0;
        while (true){
            printBoard();
            int player=playerTurn%2;
            players.get(player).play(board);
            if(BoardValidator.isGameEnd(board,row,column)){
                System.out.println("Game Over");
                printBoard();
                System.out.println(players.get(player).getPlayerName()+" wins");
                break;
            }
            if(playerTurn==8){
                printBoard();
                System.out.println("Game Draw");
                break;
            }
            playerTurn++;

        }
    }
    void printBoard(){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(board[i][j]+" ");
                if(j<column-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i<row-1){
                System.out.println("------");
            }
            System.out.println();
        }
    }
}
