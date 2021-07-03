package com.bridgelabz;

import java.util.Random;

public class SnakeAndLadderProblem {
    static final int STARTING_POSITION = 0;
    static  final int ENDING_POSITION = 100;
    static final int PLAYER1=1;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int NOPLAY = 0;
    static String TASK ;
    int totalDiceCount=0;
    static Random RANDOM = new Random();

    //uc2 rolling the dice
    public int diceRoll(){
        int diceNumber = (RANDOM.nextInt(6)+1);
        System.out.println("dice number  " +diceNumber);
        //UC6 number of times a dice was played to win the game
        totalDiceCount++;
        System.out.println("totalDiceCount " +totalDiceCount);
        return diceNumber;
    }
    public int gamePlay(int currentPosition, int DiceCount)
    {
//UC2 Initializing Rolling Dice
        if( currentPosition < ENDING_POSITION )
        {
            int DICE = (RANDOM.nextInt(6)+1);
//UC3 defining Snake, Ladder or no play
            int action = RANDOM.nextInt(3);
            switch(action)
            {
                case LADDER:
                    if(currentPosition + DICE <= ENDING_POSITION)
                    {
                        currentPosition = currentPosition + DICE;
                        TASK = "Ladder";
                    }
                    break;
                case SNAKE:
                    if(currentPosition - DICE >= STARTING_POSITION)
                    {
                        currentPosition = currentPosition - DICE;
                        TASK = "Snake";
                    }
                    break;
                case NOPLAY:
                    currentPosition = currentPosition;
                    TASK = "noPlay";
                    break;
            }
            System.out.println(" | Dice: "+DICE+" for "+TASK+" and Current Position : "+currentPosition+"| ");
        }
        if(TASK == "Ladder" && currentPosition != ENDING_POSITION)
        {
            DiceCount = dice_Player(DiceCount);
            gamePlay(currentPosition,DiceCount);
        }
        return currentPosition;
    }
    // Dice count increment after every rolling dice
    public int dice_Player(int diceCount)
    {
        diceCount++;
        return diceCount;
    }
    // Game played by two players
    public void TwoPlayers()
    {
        int Player1position = STARTING_POSITION ;
        int Player2position = STARTING_POSITION ;
        int dice_count = STARTING_POSITION ;
        System.out.println("Game Started by two player");
        while( Player1position < ENDING_POSITION && Player2position < ENDING_POSITION )
        {
            System.out.println("Player 1 :-  ");
            Player1position = gamePlay(Player1position,dice_count);
            dice_count = dice_Player(dice_count);
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            if(Player1position == ENDING_POSITION)
            {
                break;
            }
            System.out.println("Player 2 :-  ");
            Player2position = gamePlay(Player2position,dice_count);
            dice_count = dice_Player(dice_count);
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
        if(Player1position == ENDING_POSITION)
        {
            System.out.println();
            System.out.println("Player 1 Won The Match ");
        }
        else if(Player2position == ENDING_POSITION)
        {
            System.out.println();
            System.out.println("Player 2 Won The Match ");
        }
        System.out.println("Total Dice Count of both Players "+dice_count);
    }
    public static void main(String args[])
    {   System.out.println("Welcome to snake and ladder game simulator");
        SnakeAndLadderProblem snakeAndLadder=new SnakeAndLadderProblem();
        snakeAndLadder.TwoPlayers();

    }

}
