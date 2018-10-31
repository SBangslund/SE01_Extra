package extra_03;

import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Extra_03 {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int programToRun = 0;
        if (args.length > 0) {
            try {
                programToRun = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer");
                System.exit(1);
            }
        } else {
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for C.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 2:
                d2(3, 7);
                break;
            case 5:
                d5(100, 200);
                break;
            case 8:
                int[][] soduko = {
                    {1, 7, 2, 8, 9, 5, 6, 4, 3},
                    {9, 5, 6, 7, 3, 4, 8, 2, 1},
                    {4, 3, 8, 2, 6, 1, 5, 9, 7},
                    {6, 9, 5, 3, 2, 7, 1, 8, 4},
                    {8, 2, 4, 9, 1, 6, 3, 7, 5},
                    {7, 1, 3, 5, 4, 8, 9, 6, 2},
                    {2, 8, 9, 1, 7, 3, 4, 5, 6},
                    {3, 4, 7, 6, 5, 9, 2, 1, 8},
                    {5, 6, 1, 4, 8, 2, 7, 3, 9}};
                System.out.println("The solution provied is " + d8(soduko));
                break;
            default:
                System.err.println("This program only has 3 sub-programs. The argument " + programToRun + " does not match any of the programs.");
                break;
        }
    }

    /**
     * Skriv et program, der udregner omkredsen (2*π*r) af 2 cirkler med radius
     * 3 hhv. 7, og udskriver summen af disse.
     *
     * @param radius1
     * @param radius2
     */
    static void d2(int radius1, int radius2) {
        System.out.format("The sum of 2 circles circumference with a radius of %s and %s is %.2f\n",
                radius1, radius2, (calculateCircum(radius1) + calculateCircum(radius2)));
    }

    static double calculateCircum(double radius) {
        return 2 * Math.PI * radius;
    }

    /**
     * Skriv et program, der finder alle primtal mellem 100 og 200 og som har og
     * benytter to metoder (ud over main)
     *
     * @param min
     * @param max
     */
    static void d5(int min, int max) {
        System.out.format("Primes from %s to %s:\n", min, max);
        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Skriv en metode der givet et 9x9 array af heltal bestemmer (via en boolsk
     * returværdi) om der er tale om en gyldig Sudoku løsning, og skriv et
     * program der benytter denne.
     *
     * @param soduko
     * @return
     */
    static boolean d8(int[][] soduko) {
        boolean[] checkedRows = new boolean[9];
        boolean[] checkedColumns = new boolean[9];

        // Checks all the rows for their sum to equal 45.
        for (int y = 0; y < 9; y++) {
            int rowSum = 0;
            for (int x = 0; x < 9; x++) {
                rowSum += soduko[y][x];
            }
            checkedRows[y] = rowSum == 45;
        }

        // Checks all the columns for their sum to equal 45.
        for (int x = 0; x < 9; x++) {
            int columnSum = 0;
            for (int y = 0; y < 9; y++) {
                columnSum += soduko[x][y];
            }
            checkedColumns[x] = columnSum == 45;
        }

        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (checkedRows[i] || checkedColumns[i]) {
                counter++;
            }
        }
        return counter == 9;
    }
}
