import com.sun.source.tree.BreakTree;

public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    public double distance() {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100) / 100.0;
    }
    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }
    public double yIntercept() {
        /*
        1. y = mx + b
        2. y - b = mx
        3. -b = mx - y
        Thus:
        b = y - mx
        */
        return roundedToHundredth(y1 - slope() * x1);
    }
    public String equation() {
        if (y2 - y1 != 0) {
            return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
        }
        return "y = " + yIntercept();

    }
    public String coordinateForX(double x) {
        return "(" + x + ", " + roundedToHundredth(slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        info += "The equation of the line between these points is: " + equation() + "\n";
        info += "The y-intercept of this line is: " + yIntercept() + "\n";
        info += "The slope of this line is: " + slope() + "\n";
        info += "The distance between these points is " + distance();
        return info;
    }

}
