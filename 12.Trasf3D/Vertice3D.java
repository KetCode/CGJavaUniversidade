public class Vertice3D {
	
	double x, y , z;
	
	public Vertice3D(double xv, double yv, double zv) {
		x = xv;
		y = yv;
		z = zv;
	}
	
	public String toString()
	{
		return "( " + String.format("%.2f", x) + " ; "+String.format("%.2f", y)+ " ; "+String.format("%.2f", z)+" )";
	}

}