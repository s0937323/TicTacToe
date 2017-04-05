/**
 * This implementation of TicTacToe uses a 1 dimensional int array of 10 elements.
 * Only array indices 1-9 are used. Array index 0 is not used.
 * The untaken TicTacToe squares contain numbers 1-9. A square taken by "X" contains 11,
 * and a square taken by "O" contains 12. X takes the first turn in the game.
 * 
 * @author Asad Arif
 * @version 2
 */

import java.util.Scanner;

public class TicTacToe
{
    //
    // Instance variables:
    //
    private int [] board;
    private int turn; // start at 1, if odd then X's turn, if even then O's turn

    /**
     * Default constructor for objects of class TicTacToe
     */
    public TicTacToe()
    {
        // initialise instance variables
        // Make sure the board array has a length of 10.
        board = new int[10];
        turn = 1;

        // Assign numbers 1-9 to the board array elements 1-9;
        // We will not use board[0];
        // Must use a for loop that repeats from 1-9.
        for(int i = 1; i <= board.length - 1; i++)
        {
            board[i] = i;
        }
    } // end constructor

    //
    // Methods:    
    //
    /**
     * showBoard: Method to show the current 3x3 board of squares.
     * Also, shows whose turn it is: "X's turn" or "O's turn", based on the value of turn.
     * See example output in assignment 5 description.
     * 
     * Print the 3x3 board of squares;
     * Must use a for loop that repeats from 1-9;
     *      If a board array element contains 11, print "-X-";
     *      If a board array element contains 12, print "-O-";
     *      Otherwise, print the board element surrounded by a space on either side.
     *      After printing 3 board elements, print a new line for the next row.
     *
     * After the loop, print whether it's "X's turn" or "O's turn",
     * depending on whether the value of the turn instance variable is odd or even.
     */
    public void showBoard()
    {
        for(int i = 1; i <= board.length - 1; i++)
        {
            //Prints an -X- if the value is 11, Prints an -O- if the value is 12. Else, will just print the slot's number
            if (board[i] == 11)
            {
                System.out.print("-X-");
            }
            else if (board[i] == 12)
            {
                System.out.print("-O-");
            }
            else
            {
                System.out.print(" " + board[i] + " ");
            }
            //Prints a new line after 3 board items
            if (i % 3 == 0)
            {
                System.out.println("");
            }
        }
        //Prints if it is X's or O's turn, depending if turn is odd or even. Displays Game Over when turn > 9
        if (turn == 10)
        {
            System.out.println("Game is Over");
        }
        else if(hasWon() == true)
        {
            System.out.println("Game is Over");
        }
            
        else if(turn % 2 != 0)
        {
            System.out.println("\nX's turn");
        }
        else
        {
            System.out.println("\nO's turn");
        }
    }

    /**
     * takeSquare: Method to put "X" or "O" in one of the 9 squares
     * 
     * Place an "X" (11) or "O" (12) in the square indicated by squareNumber,
     * depending on the value of the turn instance variable.
     * 
     * @param squareNumber (a number from 1 - 9)
     */
    public void takeSquare(int squareNumber)
    {
        if (turn % 2 != 0)
        {
            board[squareNumber] = 11;
        }
        else
        {
            board[squareNumber] = 12;
        }
    }

    /**
     * validSquare: Method to check if the input squareNumber is valid.
     * A squareNumber is valid if it's between 1-9 AND
     * if the board[squareNumber] does not contain an "X" (11) or "O" (12).
     * 
     * @param squareNumber
     * @return valid (true if valid, false if invalid)
     */
    public boolean validSquare(int squareNumber)
    {
        boolean valid;
       
        if(squareNumber < 1 || squareNumber > 9)
        {
            valid = false;
        }
        else if (board[squareNumber] == 11 || board[squareNumber] == 12)
        {
            valid = false;
        }
        else
        {
            valid = true;
        }

        return valid;
    }

    /**
     * hasWon: Check for game won.
     * If this method returns true, X or O has won.
     * @return won, true or false
     */
    public boolean hasWon()
    {
        boolean won = false; //It is assumed no one has won

        //Checks for all possible ways for X to win using the "Sum Methods". If a sum of 33 (3 X's) is found, won is true
        if(row1Sum() == 33 || row2Sum() == 33 || row3Sum() == 33 || col1Sum() == 33
          || col2Sum() == 33 || col3Sum() == 33 || diag1Sum() == 33 || diag2Sum() == 33)
        {
            won = true;
        }

        //Checks for all possible ways for O to win using the "Sum Methods". If a sum of 36 (3 O's) is found, won is true
        if(row1Sum() == 36 || row2Sum() == 36 || row3Sum() == 36 || col1Sum() == 36
          || col2Sum() == 36 || col3Sum() == 36 || diag1Sum() == 36 || diag2Sum() == 36)
        {
            won = true;
        }

        return won;
    }

    //Calculates the sum of Row 1
    public int row1Sum()
    {
        int row1Sum = 0;
        for(int i = 1; i<=3; i++) //Row 1 sum
        {
            if(board[i] == 11)
            {
                row1Sum = row1Sum + 11;
            }

            if(board[i] == 12)
            {
                row1Sum = row1Sum + 12;
            }
        }

        return row1Sum;
    }  

    //Calculates the sum of Row 2
    public int row2Sum()
    {
        int row2Sum = 0;
        for(int i = 4; i<=6; i++) //Row 2 sum
        {
            if(board[i] == 11)
            {
                row2Sum = row2Sum + 11;
            }

            if(board[i] == 12)
            {
                row2Sum = row2Sum + 12;
            }
        }

        return row2Sum;
    }

    //Calculates the sum of Row 3
    public int row3Sum()
    {
        int row3Sum = 0;
        for(int i = 7; i<=9; i++) //Row 3 sum
        {
            if(board[i] == 11)
            {
                row3Sum = row3Sum + 11;
            }

            if(board[i] == 12)
            {
                row3Sum = row3Sum + 12;
            }
        }

        return row3Sum;  
    }

    //Calculates the sum of Col 1
    public int col1Sum()
    { 
        int col1Sum = 0;
        for(int i = 1; i<=7; i+=3) //Col 1 sum
        {
            if(board[i] == 11)
            {
                col1Sum = col1Sum + 11;
            }

            if(board[i] == 12)
            {
                col1Sum = col1Sum + 12;
            }
        }

        return col1Sum;
    }    

    //Calculates the sum of Col 2
    public int col2Sum()
    {  
        int col2Sum = 0;
        for(int i = 2; i<=8; i+=3) //Col 2 sum
        {
            if(board[i] == 11)
            {
                col2Sum = col2Sum + 11;
            }

            if(board[i] == 12)
            {
                col2Sum = col2Sum + 12;
            }
        }

        return col2Sum;
    } 

    //Calculates the sum of Col 3
    public int col3Sum ()
    {
        int col3Sum = 0;
        for(int i = 3; i<=9; i+=9) //Col 3 sum
        {
            if(board[i] == 11)
            {
                col3Sum = col3Sum + 11;
            }

            if(board[i] == 12)
            {
                col3Sum = col3Sum + 12;
            }
        }

        return col3Sum;
    }

    //Calculates the sum of Diag 1 (Forward Diag)
    public int diag1Sum()
    {
        int diag1Sum = 0;
        for(int i = 1; i<=9; i+=4)
        {
            if(board[i] == 11)
            {
                diag1Sum = diag1Sum + 11;
            }

            if(board[i] == 12)
            {
                diag1Sum = diag1Sum + 12;
            }
        }
        return diag1Sum;
    }

    //Calculates the sum of Diag 2 (Reverse Diag)
    public int diag2Sum()
    {
        int diag2Sum = 0;
        for(int i = 3; i<=7; i+=2)
        {
            if(board[i] == 11)
            {
                diag2Sum = diag2Sum + 11;
            }

            if(board[i] == 12)
            {
                diag2Sum = diag2Sum + 12;
            }
        } 
        return diag2Sum;
    }

    /**
     * getHumanSquare: This method will ask a human player for an input square to
     *                 take. If the input square number is valid, return the
     *                 square number. The human player can be playing either X
     *                 or O.
     * Requires Scanner.
     * @return squareNumber, a valid squareNumber from 1-9
     */
    public int getHumanSquare()
    {
        Scanner in = new Scanner(System.in);
        int squareNumber;   
        while(true)
        {
            System.out.println("Enter a Square Number: ");
            squareNumber = in.nextInt();
            if(validSquare(squareNumber) == true)
            {
                break;
            }
        }

        return squareNumber;
    }

    /**
     * getMachineSquare: This method contains an algorithm through which the
     *                   computer will choose a valid square number to take to
     *                   win the game or to prevent the opponent from winning
     *                   the game. The computer can be playing either X or O.
     * @return squareNumber, a valid squareNumber from 1-9
     */
    public int getMachineSquare()
    {
        int squareNumber = 1; 
        int mySymbol;
        int enemySymbol;

        if (turn % 2 != 0) //Assuming Machine is X
        {
            mySymbol = 11;
        }
        else //Machine is O
        {
            mySymbol = 12;
        }

        if (mySymbol == 11) //If Machine is X, enemy is O
        {
            enemySymbol = 12;
        }
        else //If Machine is O, enemy is X
        {
            enemySymbol = 11;
        }

        //CHECKING TO WIN
        
        if(row1Sum() == (mySymbol * 2)) //If Row 1 has 2 symbols of its own, it must place a symbol in Row 1 to win
        {
            for(int i = 1; i<=3; i++) //Keep attempting to place symbol in Row 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(row2Sum() == (mySymbol * 2)) //If Row 2 has 2 symbols of its own, it must place a symbol in Row 2 to win
        {
            for(int i = 4; i<=6; i++) //Keep attempting to place symbol in Row 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(row3Sum() == (mySymbol * 2)) //If Row 3 has 2 symbols of its own, it must place a symbol in Row 3 to win
        {
            for(int i = 7; i<=9; i++) //Keep attempting to place symbol in Row 3 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col1Sum() == (mySymbol * 2)) //If Col 1 has 2 symbols of its own, it must place a symbol in Col 1 to win
        {
            for(int i = 1; i<=7; i+=3) //Keep attempting to place symbol in Col 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col2Sum() == (mySymbol * 2)) //If Col 2 has 2 symbols of its own, it must place a symbol in Col 2 to win
        {
            for(int i = 2; i<=8; i+=3) //Keep attempting to place symbol in Col 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col3Sum() == (mySymbol * 2)) //If Col 3 has 2 symbols of its own, it must place a symbol in Col 3 to win
        {
            for(int i = 3; i<=9; i+=9) //Keep attempting to place symbol in Col 3 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(diag1Sum() == (mySymbol * 2)) //If Diag 1 has 2 symbols of its own, it must place a symbol in Diag 1 to win
        {
            for(int i = 1; i<=9; i+=4) //Keep attempting to place symbol in Diag 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(diag2Sum() == (mySymbol * 2)) //If Diag 3 has 2 symbols of its own, it must place a symbol in Diag 2 to win
        {
            for(int i = 3; i<=7; i+=2) //Keep attempting to place symbol in Diag 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }

        // NOW CHECKING TO BLOCK ENEMY

        else if(row1Sum() == (enemySymbol * 2)) //If Row 1 has 2 symbols of the enemy, it must place a symbol in Row 1 to block
        {
            for(int i = 1; i<=3; i++) //Keep attempting to place symbol in Row 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(row2Sum() == (enemySymbol * 2)) //If Row 2 has 2 symbols of the enemy, it must place a symbol in Row 2 to block
        {
            for(int i = 4; i<=6; i++) //Keep attempting to place symbol in Row 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(row3Sum() == (enemySymbol * 2)) //If Row 3 has 2 symbols of the enemy, it must place a symbol in Row 3 to block
        {
            for(int i = 7; i<=9; i++) //Keep attempting to place symbol in Row 3 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col1Sum() == (enemySymbol * 2)) //If Col 1 has 2 symbols of the enemy, it must place a symbol in Col 1 to block
        {
            for(int i = 1; i<=7; i+=3) //Keep attempting to place symbol in Col 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col2Sum() == (enemySymbol * 2)) //If Col 2 has 2 symbols of the enemy, it must place a symbol in Col 2 to block
        {
            for(int i = 2; i<=8; i+=3) //Keep attempting to place symbol in Col 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(col3Sum() == (enemySymbol * 2)) //If Col 3 has 2 symbols of the enemy, it must place a symbol in Col 3 to block
        {
            for(int i = 3; i<=9; i+=9) //Keep attempting to place symbol in Col 3 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(diag1Sum() == (enemySymbol * 2)) //If Diag 1 has 2 symbols of the enemy, it must place a symbol in Diag 1 to block
        {
            for(int i = 1; i<=9; i+=4) //Keep attempting to place symbol in Diag 1 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }
        else if(diag2Sum() == (enemySymbol * 2)) //If Diag 2 has 2 symbols of the enemy, it must place a symbol in Diag 2 to block
        {
            for(int i = 3; i<=7; i+=2) //Keep attempting to place symbol in Diag 2 until valid
            {
                if(validSquare(board[i]) == true)
                {
                    squareNumber = i;
                    return squareNumber;
                }
            }
        }

        // NOW GUESSING RANDOMLY

        else
        {
            while(true) //Keep attempting to place symbol randomly on board until valid
            {
                if(validSquare(squareNumber) == true)
                {
                    return squareNumber;
                }
                else
                {
                    squareNumber = randbetween(1,9);
                }
            }
        }
        
        return 1;
    }

    /**
     * randbetween: Return a random integer between low and high values
     * 
     * @param: low - low value
     * @param: high - high value
     * @return: random integer b/w low and high
     */ 
    private int randbetween( int low, int high ) {
        // Make sure that low and high values are in correct positions:
        // If low > high, swap low and high.
        if ( low > high ) {
            int temp = low;
            low = high;
            high = temp;
        }

        int scale = high - low + 1;
        int shift = low;
        int randnum = (int)(Math.random() * scale) + shift;

        return randnum;
    }

    /**
     * play: Method to play TicTacToe.
     * Requires Scanner.
     *
     * Pick a player for X: human or machine
     * Pick a player for O: human or machine
     * In a game loop that repeats 9 times, do:
     *      - Call showBoard to show the board.
     *      - Get X player or O player's square number by calling the
     *        getHumanSquare or getMachineSquare method. Which method
     *        you call depends on whose turn it is, and what type of players
     *        that X or O are.
     *      - Call the takeSquare() method with the square number that
     *        is returned by getHumanSquare() or getMachineSquare().
     *      - If anyone has won, break and declare winner.
     *      - Increment turn variable after every turn.
     *      
     * Show the board again after the game loop ends.
     */
    public void play()
    {
        int answer;
        boolean XHuman, OHuman;
        Scanner in = new Scanner(System.in);  
        System.out.println("Is X human? 1 for Yes, 2 for No: ");
        answer = in.nextInt();

        if(answer == 1)
        {
            XHuman = true;
        }
        else
        {
            XHuman = false;
        }

        System.out.println("\nIs O human? 1 for Yes, 2 for No: ");
        answer = in.nextInt();

        if(answer == 1)
        {
            OHuman = true;
        }
        else
        {
            OHuman = false;
        }

        for(int i = 1; i <= 9; i++)
        {
            System.out.println(""); //Design purposes
            showBoard();

            if (turn % 2 != 0)
            {
                if (XHuman == true)
                {
                    takeSquare(getHumanSquare());
                }
                else
                {
                    takeSquare(getMachineSquare());
                }
            }

            else
            {
                if (OHuman == true)
                {
                    takeSquare(getHumanSquare());
                }
                else
                {
                    takeSquare(getMachineSquare());
                }
            }

            if (hasWon() == true)
            {
                if (turn % 2 != 0)
                {
                    System.out.println("\nX has won");
                }
                else
                {
                    System.out.println("\nO has won");
                }
               
                break;
            }
            turn++;
        }
    
        showBoard();
    }
} // end class