package extra_02;

import java.util.Scanner;

/**
 * @author Samuel Bangslund
 */
public class Extra_02 {

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
            case 1:
                c1();
                break;
            case 3:
                c3();
                break;
            case 4:
                c4();
                break;
            case 5:
                c5();
                break;
            case 6:
                c6();
                break;
            default:
                System.err.println("This program only has 1-6 (except 2) sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }

    /**
     * Skriv et program, der udregner og udskriver arealet (π*r^2) af 5
     * forskellige cirkler med radius 1, 2, 3, 4 og 5.
     */
    static void c1() {
        int[] circleRadiuses = {1, 2, 3, 4, 5};

        for (int radius : circleRadiuses) {
            System.out.format("The area of a circle with the radius of "
                    + radius + " is %.2f\n", Math.PI * Math.pow(radius, 2));
        }
    }

    /**
     * Skriv et program, der givet 7 dagstemperaturer (21.5, 23.7, 19.6, 22.5,
     * 25.3, 21.7, 18.9) udregner og udskriver temperaturdifferencen mellem alle
     * to på hinanden følgende dage (dvs. Tirsdag-Mandag, Onsdag-Tirsdag ...
     * Søndag - Lørdag).
     */
    static void c3() {
        double[] dayTemperatures = {21.5, 23.7, 19.6, 22.5, 25.3, 21.7, 18.9};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double tempDifference;
        for (int i = 0; i < 6; i++) {
            tempDifference = dayTemperatures[i + 1] - dayTemperatures[i];
            System.out.println("The temperature difference between " + days[i] + " and " + days[i + 1]
                    + " is " + Math.abs((float) tempDifference) + " degrees");
        }
    }

    /**
     * Skriv et program, der givet en måneds nummer udskriver antallet af dage i
     * denne måned.
     */
    static void c4() {
        System.out.print("Choose a month (1 for January): ");
        int monthNumber = scanner.nextInt();

        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.println(months[monthNumber - 1] + " has " + numberOfDays[monthNumber - 1] + " days.");
    }

    /**
     * Skriv et program, der udregner alle primtal under 1.000.000 ved at
     * implementere Eratosthenes Si, og udskriver det største. Kvadratroden af i
     * udregnes som java.lang.Math.sqrt(i). Sammenlign med løsningen til opgave
     * B.5.
     */
    static void c5() {
        int n = 1_000_000;
        boolean[] A = new boolean[n];
        int count = 0;

        long time = System.currentTimeMillis();

        for (int i = 2; i < A.length; i++) {
            A[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (A[i]) {
                for (int j = (int) Math.pow(i, 2); j < n; j = (int) Math.pow(i, 2) + count * i) {
                    A[j] = false;
                    count++;
                }
                count = 0;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (A[i]) {
                System.out.format("The largest primenumber beneath %,d is %,d: %,d ms\n", n, i, System.currentTimeMillis() - time);
                break;
            }
        }
    }

    /**
     * Skriv et program, der udskriver indekset af det største tal i et array.
     */
    static void c6() {
        int[] array = {1, 2, 8, 4, 6, 2, 4, 19, 10};
        int temp = 0;

        for (int number : array) {
            temp = (number > temp) ? number : temp;
        }

        System.out.println("The biggest number in the array is " + temp);
    }
}
