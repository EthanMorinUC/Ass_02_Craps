import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        boolean playOn = true;
        int rolls = 0;
        int dice1, dice2, diceSum, thePoint;

        do {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
            diceSum = dice1 + dice2;
            System.out.println("Your dice are: " + dice1 + " and " + dice2);
            System.out.println("Dice Sum: " + diceSum);
            System.out.println("");

            if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
                System.out.println("You crapped out. You Lost.");
            } else if (diceSum == 7 || diceSum == 11) {
                System.out.println("You got a natural! You win!");
            } else {
                thePoint = diceSum;
                diceSum = 0;
                while (thePoint != diceSum) {
                    dice1 = (int) (Math.random() * 6) + 1;
                    dice2 = (int) (Math.random() * 6) + 1;
                    diceSum = dice1 + dice2;
                    System.out.println("The point is " + thePoint);
                    System.out.println("Your dice are: " + dice1 + " and " + dice2);
                    System.out.println("Dice Sum: " + diceSum);
                    System.out.println("----------------------");
                    if (thePoint == diceSum) {
                        System.out.println("You hit The Point! You win!");
                        break;
                    } else if (diceSum == 7) {
                        System.out.println("You crapped out. You Lost.");
                        break;
                    }
                }
            }

            boolean goodInput = false;
            while (!goodInput) {
                System.out.println("Do you want to play again (Y/N)? ");
                input = scan.next().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    goodInput = true;
                    playOn = input.equals("y");
                } else {
                    System.out.println("Invalid input. Please type either Y or N.");
                }
            }
        } while (playOn);
        scan.close();
    }
}
