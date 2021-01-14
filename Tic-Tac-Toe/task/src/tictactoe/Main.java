package tictactoe;

import java.util.Scanner;

public class Main {
    char table[][] = {
            {'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
    int counter = 0;
    boolean xWins = false;
    boolean oWins = false;
    String xWinCheck = "XXX";
    String oWinCheck = "OOO";
    String temp = "";
    int coordinatesI = 0;
    int coordinatesJ = 0;
    int moveCount = 1;

    public static void main(String[] args) {
        Main ma = new Main();
        ma.createMatrix();
    }

    void createMatrix() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                counter++;
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        enterCoordinates();
    }

    void enterCoordinates() {
        do {
            System.out.println("Enter the coordinates: ");
            Scanner sc = new Scanner(System.in);
            coordinatesI = sc.nextInt();
            coordinatesJ = sc.nextInt();

            if (coordinatesI > 3 || coordinatesI < 1 || coordinatesJ < 1 || coordinatesJ > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            ;
        } while (coordinatesI > 3 || coordinatesI < 1 || coordinatesJ < 1 || coordinatesJ > 3);

        checkMatrix();
    }

    void checkMatrix() {
        int tempi = table.length - 1 - (coordinatesJ - 1);
        int tempj = coordinatesI - 1;
        if (table[tempi][tempj] == '_') {
            if (moveCount % 2 == 0) {
                table[tempi][tempj] = 'O';
            } else {
                table[tempi][tempj] = 'X';
            }
            moveCount++;
            updatedMatrix();
        } else {
            System.out.print("This cell is occupied! Choose another one!");

            enterCoordinates();
        }
    }

    void updatedMatrix() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        wins();
    }

    void wins() {
        temp = "";
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                temp += table[i][j];
                if (temp.equals(xWinCheck)) {
                    xWins = true;
                } else if (temp.equals(oWinCheck)) {
                    oWins = true;
                }
            }
            if (temp.equals(xWinCheck)) {
                xWins = true;
            } else if (temp.equals(oWinCheck)) {
                oWins = true;
            }

            temp = "";
        }
        temp = "";
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[j].length; i++) {
                temp += table[i][j];
                if (temp.equals(xWinCheck)) {
                    xWins = true;
                } else if (temp.equals(oWinCheck)) {
                    oWins = true;
                }
            }
            if (temp.equals(xWinCheck)) {
                xWins = true;
            } else if (temp.equals(oWinCheck)) {
                oWins = true;
            }
            temp = "";
        }

        temp = "";
        temp += table[0][0] + "" + table[1][1] + "" + table[2][2];
        if (temp.equals(xWinCheck)) {
            xWins = true;
        } else if (temp.equals(oWinCheck)) {
            oWins = true;
        }
        temp = "";
        temp += table[0][2] + "" + table[1][1] + "" + table[2][0];
        if (temp.equals(xWinCheck)) {
            xWins = true;
        } else if (temp.equals(oWinCheck)) {
            oWins = true;
        }

        if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (moveCount > 9) {
            restSolutions();
        } else {
            enterCoordinates();
        }
    }

    void restSolutions() {
        counter = 0;
        for (char i[] : table) {
            for (char j : i) {
                if (j == 'X' || j == 'O') {
                    counter++;
                }
            }
        }
        if (counter == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }
}
