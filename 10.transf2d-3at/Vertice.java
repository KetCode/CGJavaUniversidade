public class Vertice {
    double x,y;

    public Vertice(double xv, double yv) {
        x = xv;
        y = yv;
    }

    public String toString() {
        return "(" + String.format("%.2f", x) + " ; " + String.format("%.2f", y) + ")";
    }
}
