package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderProblem {
    static final int STARTING_POSITION = 0;
    static  final int ENDING_POSITION = 100;
    static final int PLAYER=1;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int NOPLAY = 0;

    static Random RANDOM = new Random();

    //uc2 rolling the dice
    public int diceRoll()
    {
        int diceNumber = (RANDOM.nextInt(6)+1);
        System.out.println("dice number  " +diceNumber);
        return diceNumber;
    }
    //uc3 The Player then checks for a Option. They are No Play, Ladder or Snake.
    public void gamePlay() {
        int playerPosition=STARTING_POSITION;

        //uc4 Repeat till the Player reaches the winning position 100
        while (playerPosition<ENDING_POSITION)
        {
            int dice=diceRoll();
            int action = RANDOM.nextInt(3);
            System.out.println("action: "+action);
            switch (action) {

                case LADDER:
                    int limit;
                    limit = playerPosition;
                    limit = limit + dice;
                    //uc5 Ensure the player get to exact winning position 100.
                    if (limit<=ENDING_POSITION) {
                        playerPosition = playerPosition + dice;
                        System.out.println("current ladder position: " + playerPosition);
                    }
                    break;
                case SNAKE:
                    playerPosition = playerPosition - dice;
                    if (playerPosition < STARTING_POSITION) {
                        playerPosition = STARTING_POSITION;
                    }
                    System.out.println("current snake position: " + playerPosition);
                    break;
                case NOPLAY:
                    playerPosition = playerPosition;
                    if (playerPosition < STARTING_POSITION) {
                        playerPosition = STARTING_POSITION;
                        System.out.println("no play position: " + playerPosition);
                    }

                    break;
            }
            System.out.println(" ");
        }
    }
    public static void main(String args[])
    {
        SnakeAndLadderProblem snakeAndLadder=new SnakeAndLadderProblem();
        snakeAndLadder.gamePlay();

    }

}
