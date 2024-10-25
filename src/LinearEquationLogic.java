package src;

import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scanner = new Scanner(System.in);
    public LinearEquationLogic() { }

    private int parseCoordX(String coordinates) {
        /* (3, 10) */
        return Integer.parseInt(coordinates.substring(1, coordinates.indexOf(" ") - 1));
    }
    private int parseCoordY(String coordinates) {
        /* (3, 10) */
        return Integer.parseInt(coordinates.substring(coordinates.indexOf(" ") + 1, coordinates.length() - 1));
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");

        String choice = "y";

        while (choice.toLowerCase().charAt(0) == 'y') {
            System.out.print("Enter coordinate 1: ");
            String coord1 = scanner.nextLine();
            System.out.print("Enter coordinate 2: ");
            String coord2 = scanner.nextLine();

            int x1 = parseCoordX(coord1);
            int x2 = parseCoordX(coord2);
            int y1 = parseCoordY(coord1);
            int y2 = parseCoordY(coord2);
            if (x2 - x1 == 0) {
                System.out.println("\nThese points are on a vertical line: x = " + x1 + "\n");
            } else {
                LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
                System.out.println(equation.lineInfo());

                System.out.print("Enter a value for x: ");
                double xValue = scanner.nextDouble();
                System.out.println("The point on the line is " + equation.coordinateForX(xValue));
            }
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            scanner.nextLine();
            choice = scanner.nextLine();

        }
        // end of program
        System.out.println("Thank you for using the slope calculator, goodbye!");

    }
}
