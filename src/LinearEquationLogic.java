import javax.sound.sampled.Line;
import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scanner = new Scanner(System.in);
    private int parseCoordX(String coordinates) {
        /* (3, 10) */
        return Integer.parseInt(coordinates.substring(1, coordinates.indexOf(" ")));
    }
    private int parseCoordY(String coordinates) {
        /* (3, 10) */
        return Integer.parseInt(coordinates.substring(coordinates.indexOf(" "), coordinates.length() - 1));
    }
    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scanner.nextLine();

        int x1 = parseCoordX(coord1);
        int x2 = parseCoordX(coord2);
        int y1 = parseCoordY(coord1);
        int y2 = parseCoordY(coord2);

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println(equation.lineInfo());

    }
}
