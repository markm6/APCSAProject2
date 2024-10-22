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
    private boolean isWholeNumber(double x) {
        return x == (int) x;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
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
        String eq = "y = ";

        /*
        * = SLOPE =
        * IS SLOPE 0? if so, skip 1-3:
        * 1. sign of slope
        * 2. is slope just x?
        * 3. is slope whole number?
        * = INTERCEPT =
        * 1. is intercept 0?
        * 2. is intercept negative or positive?
        * (not in requirements but implemented for consistency)
        * 3. is intercept a whole number?
        * */
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        double slope = slope();
        double intercept = yIntercept();

        if (slope != 0) {
            if (slope < 0) {
                eq += "-";
            }
            if (slope == 1) {
                eq += "x";
            } else {
                if (isWholeNumber(slope)) {
                    eq += ((int) slope) + "x";
                } else {
                    eq += Math.abs(deltaY) + "/" + Math.abs(deltaX) + "x";
                }
            }
        }
        if (intercept == 0 && intercept != slope) {
            return eq;
        } else {
            if (slope != 0) {
                if (intercept < 0) {
                    eq += " - ";
                } else {
                    eq += " + ";
                }
                if (isWholeNumber(intercept)) {
                    eq += (int) Math.abs(intercept);
                } else {
                    eq += Math.abs(intercept);
                }
            } else {
                if (isWholeNumber(intercept)) {
                    eq += (int) intercept;
                } else {
                    eq += intercept;
                }
            }
        }


        return eq;

    }
    public String coordinateForX(double x) {
        return "(" + x + ", " + roundedToHundredth(slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        info += "The equation of the line between these points is: " + equation() + "\n";
        info += "The slope of this line is: " + slope() + "\n";
        info += "The y-intercept of the line is: " + yIntercept() + "\n";
        info += "The distance between the two points is: " + distance();
        return info;
    }

}
