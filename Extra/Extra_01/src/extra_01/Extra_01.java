package extra_01;

import java.util.Scanner;

/**
 * @author Samuel Banglsund
 */
public class Extra_01 {

    static Scanner scanner = new Scanner(System.in);
    static double[] radiusForArea = {1, 2, 3, 4, 5},
            radiusForCircumference = {3, 7},
            dayTemperature = {21.5, 23.7, 19.6, 22.5, 25.3, 21.7, 18.9};

    static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for a.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 1:
                a1(radiusForArea);
                break;
            case 2:
                a2(radiusForCircumference);
                break;
            case 3:
                a3(dayTemperature);
                break;
            case 6:
                b1();
                break;
            case 4:
                b4(3);
                break;
            case 5:
                b5();
                break;
            default:
                System.err.println("This program only has 1-23 sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }

    /**
     * A.1 Skriv et program, der udregner og udskriver arealet (π*r^2) af 5
     * forskellige cirkler med radius 1, 2, 3, 4 og 5.
     *
     * @param radiusArray
     */
    static void a1(double[] radiusArray) {
        double area;
        for (int i = 0; i < radiusArray.length; i++) {
            area = Math.PI * Math.pow(radiusArray[i], 2);
            System.out.format("The area of a circle with the radius of " + radiusArray[i] + " is %.3f \n", area);
        }
    }

    /**
     * A.2 Skriv et program, der udregner omkredsen (2*π*r) af 2 cirkler med
     * radius 3 hhv. 7, og udskriver summen af disse.
     *
     * @param radiusArray
     */
    static void a2(double[] radiusArray) {
        double circumference;
        for (int i = 0; i < radiusArray.length; i++) {
            circumference = 2 * Math.PI * radiusArray[i];
            System.out.format("The circumference of a circle with " + radiusArray[i] + " is %.3f", circumference);
        }
    }

    /**
     * A.3 Skriv et program, der givet 7 dagstemperaturer (21.5, 23.7, 19.6,
     * 22.5, 25.3, 21.7, 18.9) udregner og udskriver temperaturdifferencen
     * mellem alle to på hinanden følgende dage (dvs. Tirsdag-Mandag,
     * Onsdag-Tirsdag ... Søndag - Lørdag).
     *
     * @param dayTemperatureArray An array of degrees corresponding to the days
     * of the week.
     */
    static void a3(double[] dayTemperatureArray) {
        double tempDifference;
        for (int i = 0; i < 6; i++) {
            tempDifference = dayTemperatureArray[i + 1] - dayTemperatureArray[i];
            System.out.println("The temperature difference between " + days[i] + " and " + days[i + 1]
                    + " is " + Math.abs((float) tempDifference) + " degrees");
        }
    }

    /**
     * B.1 Skriv et program, der udregner og udskriver arealet (π*r^2) af 5
     * forskellige cirkler med radius 1, 2, 3, 4 og 5.
     */
    static void b1() {
        for (int i = 1; i <= 5; i++) {
            System.out.format("A circle with the radius of " + i + " has an area of %.2f\n", Math.PI * i * i);
        }
    }

    /**
     * B.4 Skriv et program, der givet en måneds nummer udskriver antallet af
     * dage i denne måned.
     *
     * @param monthNumber
     */
    static void b4(int monthNumber) {
        switch (monthNumber) {
            case 1:
                System.out.println("January has " + 31 + " days");
                break;
            case 2:
                System.out.println("February has " + 28 + " days");
                break;
            case 3:
                System.out.println("March has " + 31 + " days");
                break;
            case 4:
                System.out.println("April has " + 30 + " days");
                break;
            case 5:
                System.out.println("May has " + 31 + " days");
                break;
            case 6:
                System.out.println("June has " + 30 + " days");
                break;
            case 7:
                System.out.println("July has " + 31 + " days");
                break;
            case 8:
                System.out.println("August has " + 31 + " days");
                break;
            case 9:
                System.out.println("September has " + 30 + " days");
                break;
            case 10:
                System.out.println("October has " + 31 + " days");
                break;
            case 11:
                System.out.println("November has " + 30 + " days");
                break;
            case 12:
                System.out.println("December has " + 31 + " days");
                break;
            default:
                System.out.println("The given number is outside the range of months (1-12)");
                break;
        }
    }

    /**
     * B.5 Skriv et program, der udregner alle primtal under 1.000.000, og
     * udskriver det største.
     */
    static void b5() {
        int biggestPrime = 0, // The currently biggest prime number.
                number = 2;   // Iterating number.

        boolean isPrime;      // Whether or not the iterating number is a prime number.
        long time = System.currentTimeMillis(); // For measuring run time.

        while (true) {
            isPrime = true;
            for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
                // If the number divided by the current divisor has nothing in rest.
                // Then this number is a primenumber.
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            // If the number was prime, this is true and the number will be the
            // biggest prime number yet.
            if (isPrime) {
                biggestPrime = number;

                // Makes sure the loop is terminated at the limit.
            } else if (number >= 1_000_000) {
                break;
            }

            // Getting ready to check for the next number.
            number++;
        }

        // Prints the biggest primenumber within the given limit.
        System.out.println("The biggest prime number beneath the 1.000.000 limit is " + String.format("%,d", biggestPrime) + ". It was calculated in "
                + (System.currentTimeMillis() - time) + " milliseconds");
    }
}
