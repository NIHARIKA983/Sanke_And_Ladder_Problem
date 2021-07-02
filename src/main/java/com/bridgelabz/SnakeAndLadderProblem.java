package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderProblem {
    static final int STARTING_POSITION = 0;
    static final int PLAYER=1;
    static Random RANDOM = new Random();

    //uc2 rolling a random value to the player
    public void diceRoll()
    {
        int DICE = (RANDOM.nextInt(6)+1);
        System.out.println("dice number  " +DICE);
    }

    public static void main(String[] args)
    {
        SnakeAndLadderProblem snakeAndLadder=new SnakeAndLadderProblem();
        snakeAndLadder.diceRoll();
    }

}
