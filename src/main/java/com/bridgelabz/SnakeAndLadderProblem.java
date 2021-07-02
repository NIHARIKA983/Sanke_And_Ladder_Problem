package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderProblem {
    static final int STARTING_POSITION = 0;
    static final int PLAYER=1;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int NOPLAY = 0;

    static Random RANDOM = new Random();

    //uc2 rolling a random value to the player
    public int diceRoll()
    {
        int diceNumber = (RANDOM.nextInt(6)+1);
        System.out.println("dice number  " +diceNumber);
        return diceNumber;
    }
    public void gamePlay() {
        int playerPosition=STARTING_POSITION;
        int dice=diceRoll();
        int action = RANDOM.nextInt(3);
        System.out.println("action: "+action);
        switch(action)
        {

            case LADDER:
                playerPosition = playerPosition + dice;
                System.out.println("current ladder position: " + playerPosition);
                break;
            case SNAKE:
                playerPosition = playerPosition - dice;
                if(playerPosition<0){
                    playerPosition=STARTING_POSITION;
                }
                System.out.println("current snake position: "+playerPosition);
                break;
            case NOPLAY:
                playerPosition = playerPosition;
                if(playerPosition<0){
                    playerPosition=STARTING_POSITION;
                }
                System.out.println("no play position: "+playerPosition);
                break;
        }
    }
    public static void main(String args[])
    {
        SnakeAndLadderProblem snakeAndLadder=new SnakeAndLadderProblem();
        snakeAndLadder.gamePlay();

    }

}
