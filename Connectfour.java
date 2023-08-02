import java.util.Scanner;
//make some changes
public class Connectfour {

    // we need to create bsic visualization pattern
    public static String[][] createpattern() {
        // we need 6 rows and 15 column to print \|| and space between
        String[][] f = new String[7][15];
        // we need to create a box for our game to put | and space
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                // we need to put | in place of even no and space in odd porition
                if (j % 2 == 0) {
                    f[i][j] = "|";
                } else {
                    f[i][j] = " ";
                }
                // to put baseline in box at bottom row
                if (i == 6)
                    f[i][j] = "-";
            }
        }
        return f;
    }

    // now we need to print our game to make a new mehod
    public static void printpattern(String[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }

    // we need to create another method to drop red balls

    public static void dropred(String[][] f) {
        // now we need to ask user to drop balls in odd columns as they dont know we
        // have 15 columns
        System.out.println("Drop a red in columns(0-6): ");
        // to take input we nned to create read object
        Scanner read = new Scanner(System.in);
        int c = 2 * read.nextInt() + 1; // this way we can take input as 1-3-5-7-9-11-13

        // we need to start from bottom to top for loop to iterate columns
        for (int i = 5; i >= 0; i--) {
            if (f[i][c] == " ") {

                f[i][c] = "R";
                break;
            }
        }
        

    }

    // same for yellow
    public static void dropyellow(String[][] f) {
        // now we need to ask useer to drop balls in odd columns as they dont know we
        // have 15 columns
        System.out.println("Drop a yellow in columns(0-6): ");
        
        Scanner read = new Scanner(System.in);
        int c = 2 * read.nextInt() + 1; // this way we can take input as 1-3-5-7-9-11-13

        // we need to start from bottom to top for loop to iterate columns
        for (int i = 5; i >= 0; i--) {
            if (f[i][c] == " ") {

                f[i][c] = "Y";
                break;
            }
        }
    
    }

    // this is hard part
    // user can win in four ways
    // either full vertical,horizontal,diagnol
    // in diagnol mean left up to right bottom
    // left bottom to right up
    // we need 4 condition to win
    public static String cwinner(String[][] f) {
        // here line in any row means winner
        for (int i = 0; i < 6; i++) {
            // the pattern can be ----__,_----_,__----;
            // this means 3 ways to win in horizontal line
            // as we need to put input in odd columns
            // we start from 0 (which is 1 ----__)
            // end at 6 (which is 7 __----)
            for (int j = 0; j < 7; j += 2) {
                if ((f[i][j + 1] != " ")
                        && (f[i][j + 3] != " ")
                        && (f[i][j + 5] != " ")
                        && (f[i][j + 7] != " ")
                        && f[i][j + 1] == (f[i][j + 3])
                        && f[i][j + 3] == (f[i][j + 5])
                        && f[i][j + 5] == (f[i][j + 7]))
                    return f[i][j + 1];
            }
        }

        // for vertical
        for (int j = 1; j < 15; j += 2) {
            // we now iterate over column in 2 gaps
            for (int i = 0; i < 3; i++) {
                if ((f[i][j] != " ")
                        && (f[i + 1][j] != " ")
                        && (f[i + 2][j] != " ")
                        && (f[i + 3][j] != " ")
                        && (f[i][j] == f[i + 1][j])
                        && (f[i + 1][j] == f[i + 2][j])
                        && (f[i + 2][j] == f[i + 3][j]))
                    return f[i][j];
            }
        }

        // for diagnol match we need to move 3 column and rows to check
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 9; j += 2) {
                if ((f[i][j] != " ")
                        && (f[i + 1][j + 2] != " ")
                        && (f[i + 2][j + 4] != " ")
                        && (f[i + 3][j + 6] != " ")
                        && (f[i][j] == f[i + 1][j + 2])
                        && (f[i + 1][j + 2] == f[i + 2][j + 4])
                        && (f[i + 2][j + 4] == f[i + 3][j + 6]))
                    return f[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 7; j < 15; j += 2) {
                if ((f[i][j] != " ")
                        && (f[i + 1][j - 2] != " ")
                        && (f[i + 2][j - 4] != " ")
                        && (f[i + 3][j - 6] != " ")
                        && (f[i][j] == f[i + 1][j - 2])
                        && (f[i + 1][j - 2] == f[i + 2][j - 4])
                        && (f[i + 2][j - 4] == f[i + 3][j - 6]))
                    return f[i][j];
            }
        }
        return null;

    }

    public static void main(String[] args) {
        // just call methods
        String[][] f = createpattern();

        // condition for our game to keep playing
        boolean game = true;
        // to choose and selcet users turn
        int count = 0;
        printpattern(f);

        // run game using while loop
        while (game) {
            if (count % 2 == 0) {
                dropred(f);
            } else {
                dropyellow(f);
            }

            count++;
            printpattern(f);

            // to check winner
            if (cwinner(f) != null) {
                if (cwinner(f) == "R") {
                    System.out.println("Red Won");
                } else if (cwinner(f) == "Y") {
                    System.out.println("Yellow Won");
                }
                game = false;
            }
        }

    }
    

}

//commit after adding gitignore file
//git overwites commit if it is branched