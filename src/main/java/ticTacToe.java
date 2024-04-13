
/*Tic Tac Toe Game
Written By: Md Shahbaz Hashmi Ansari
Programing languages: Java
Code Version: V1.0
Copyright ©: Open-source project 
Compatible with: BlueJ, Netbeans, VS Code etc...
 */
import java.util.Scanner;

class ticTacToe {
  public static String[][] playGround = new String[3][3];
  public static String player;
  public static int playerInputI, playerInputJ, i, j, iKey, jKey, playMode;

  public ticTacToe() { // Constructor
    i = 0;
    j = 0;
    player = " ";
    jKey = 0;
    iKey = 0;
    playerInputI = 0;
    playerInputJ = 0;
    playMode = 0;

  }

  public static void main(String[] args) { // Main method
    Scanner sc = new Scanner(System.in);
    ticTacToe obj = new ticTacToe();
    System.out.println("\nWelcome to the Tic Tac Toe Game");
    System.out.printf("%27s", "|-------------------------|");
    System.out.printf("%27s", "\n|Choose the playing mode: |");
    System.out.printf("%27s", "\n|-------------------------|");
    System.out.printf("%27s", "\n|Enter '1' for 2 players  |");
    System.out.printf("%27s", "\n|Enter '2' for 1 players  |");
    System.out.printf("%27s", "\n|-------------------------|");
    System.out.print("\n Enter your Choice: ");
    playMode = sc.nextInt();
    if (playMode > 2) {
      System.out.println("\nInvalid Play Mode Input!");
      return;
    }
    int p = 1;
    System.out.println("\nHow to play? \n Example:"); // Short example on how to play game
    System.out.println("\n");
    for (i = 0; i < 3; i++) { // Storing Number into to array
      for (j = 0; j < 3; j++) {
        playGround[i][j] = Integer.toString(p++); // Converting int to string using wrapper class
      }

    }
    p = 1;
    for (i = 0; i < 3; i++) { // Patterned output for example
      for (j = 0; j < 3; j++) {
        if (j == 2)
          System.out.printf("%5d ", p++);
        else
          System.out.printf("%5d %4s", p++, "|");
      }
      if (i != 2)
        System.out.println("\n    ----------------------");
    }
    System.out.println("\n");
    System.out.print("\nYour Turn: ");
    System.out.print("2");
    p = 1;
    System.out.println("\n");
    for (i = 0; i < 3; i++) {
      for (j = 0; j < 3; j++) {
        if (j == 2)

          System.out.printf("%5d ", p++);

        else {
          if (i == 0 && j == 1)
            System.out.printf("%5s %4s", "X", "|");
          else
            System.out.printf("%5d %4s", p++, "|");
        }
      }
      if (i != 2)
        System.out.println("\n    ----------------------");
    }
    System.out.println("\n");
    System.out.println("\nLet's Start!"); // Getting started with the game message

    for (int k = 0; k < 9; k++) {
      if (playMode == 1) { // play mode call

        if (k % 2 == 0) {
          player = "X";
          obj.player1Input();
          obj.printOutput();
          obj.result();

        } else {
          player = "O";
          obj.player2Input();
          obj.printOutput();
          obj.result();

        }

      } else if (playMode == 2) {

        if (k % 2 == 0) {
          player = "X";
          obj.player1Input();
          obj.printOutput();
          obj.result();

        } else {

          player = "O";
          int pos = obj.computerInput();
          System.out.print("\nComputer Input: " + pos);
          obj.printOutput();
          obj.result();

        }
      }

    }

  }

  public void player1Input() { // Asking user /player 1 to input the next move
    Scanner sc = new Scanner(System.in);
    System.out.print("\nYour Turn: ");
    int ch = sc.nextInt();
    choice(ch);
    if (playGround[iKey][jKey].equals("X") || playGround[iKey][jKey].equals("O")) {
      System.out.println("Invalid Input");
      player1Input();
    } else {
      playerInputI = iKey; // iKey determine the row position
      playerInputJ = jKey; // jKey determine the column position
      playGround[playerInputI][playerInputJ] = "X"; // changing the value with "X"
    }
  }

  public void player2Input() { // Asking user /player 2 to input the next move
    Scanner sc = new Scanner(System.in);
    System.out.print("\nPlayer 2 Turn: ");
    int ch = sc.nextInt();
    choice(ch);
    if (playGround[iKey][jKey].equals("X") || playGround[iKey][jKey].equals("O")) {
      System.out.println("Invalid Input");
      player2Input();
    } else {
      playerInputI = iKey;
      playerInputJ = jKey;
      playGround[playerInputI][playerInputJ] = "O"; // changing the value with "O"
    }
  }

  public int computerInput() { // Computer Input/ Computer moves

    int ch = (int) (Math.random() * 9 - 1 + 1) + 1;
    choice(ch);

    if (playGround[iKey][jKey].equals("X") || playGround[iKey][jKey].equals("O")) {

      computerInput();
    } else {

      playerInputI = iKey;
      playerInputJ = jKey;
      playGround[playerInputI][playerInputJ] = "O";
    }
    return ch;
  }

  public void printOutput() {
    System.out.println("\n");
    for (i = 0; i < 3; i++) {
      for (j = 0; j < 3; j++) {
        if (j == 2)
          System.out.printf("%5s ", playGround[i][j]);
        else
          System.out.printf("%5s %4s", playGround[i][j], "|");
      }
      if (i != 2)
        System.out.println("\n    ----------------------");
    }
    System.out.println("\n");
  }

  public void result() {

    if (playGround[playerInputI][0].equals(player) && playGround[playerInputI][1].equals(player)
        && playGround[playerInputI][2].equals(player)) {
      print();
    }

    if (playGround[0][playerInputJ].equals(player) && playGround[1][playerInputJ].equals(player)
        && playGround[2][playerInputJ].equals(player)) {
      print();
    }

    if (i == j && playGround[0][0].equals(player) && playGround[1][1].equals(player) && playGround[2][2].equals(player)
        || i + j == 2 && playGround[0][0].equals(player) && playGround[1][1].equals(player)
            && playGround[2][2].equals(player)) {
      print();
    }
  }

  public static void print() {
    if (player.equals("O")) {
      if (playMode == 2)
        System.out.println("\n Computer Won!");
      else
        System.out.println("\n Player 2 Won!");
    } else if (player.equals("X")) {
      System.out.println("\n Player 1 Won!");
    }
    System.exit(0);
  }

  public static void choice(int ch) {

    switch (ch) {
      case 1: {
        iKey = 0;
        jKey = 0;
        break;
      }
      case 2: {
        iKey = 0;
        jKey = 1;
        break;
      }
      case 3: {
        iKey = 0;
        jKey = 2;
        break;
      }
      case 4: {
        iKey = 1;
        jKey = 0;

        break;
      }
      case 5: {
        iKey = 1;
        jKey = 1;
        break;
      }
      case 6: {
        iKey = 1;
        jKey = 2;
        break;
      }
      case 7: {
        iKey = 2;
        jKey = 0;
        break;
      }
      case 8: {
        iKey = 2;
        jKey = 1;
        break;
      }
      case 9: {
        iKey = 2;
        jKey = 2;
        break;
      }
    }
  }

}