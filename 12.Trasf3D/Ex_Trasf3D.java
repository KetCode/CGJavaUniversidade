public class Ex_Trasf3D {


	public static Vertice3D translacao( Vertice3D a, double tx, double ty, double tz){
		Vertice3D res = new Vertice3D( a.x+tx , a.y+ty , a.z+tz);
		return res;
	}

	public static Vertice3D escala( Vertice3D a, double ex, double ey, double ez){
		Vertice3D res = new Vertice3D( a.x*ex , a.y*ey, a.z*ez );
		return res;
	}
	
	public static Vertice3D rotacaoX( Vertice3D a, double angulo){
		angulo = (Math.PI/180) * angulo;
		Vertice3D res = new Vertice3D( a.x ,
								   a.y*Math.cos(angulo) - a.z*Math.sin(angulo),
								   a.y*Math.sin(angulo) + a.z*Math.cos(angulo) );
		return res;
	}
	
	public static Vertice3D rotacaoY( Vertice3D a, double angulo){
		angulo = (Math.PI/180) * angulo;
		Vertice3D res = new Vertice3D( a.x*Math.cos(angulo) + a.z*Math.sin(angulo),
								       a.y ,
								       (-1)*a.x*Math.sin(angulo) + a.z*Math.cos(angulo) );
		return res;
	}
	
	public static Vertice3D rotacaoZ( Vertice3D a, double angulo){
		angulo = (Math.PI/180) * angulo;
		Vertice3D res = new Vertice3D( 	a.x*Math.cos(angulo) - a.y*Math.sin(angulo),
								   		a.x*Math.cos(angulo) + a.y*Math.cos(angulo),
								   		a.z );
		return res;
	}

	public static void main(String[] args) {
		
		Vertice3D p1 = new Vertice3D(1, 1, 1);
		Vertice3D p2 = new Vertice3D(3, 3, 3);

		System.out.println( "P1 "+ rotacaoY(p1, 45) );
		System.out.println( "P2 "+ rotacaoY(p2, 45) );
	
		System.out.println( escala(p1, 2, 2,2) );
		System.out.println( translacao(p1, 3, 2, 2 ) );
		System.out.println( rotacaoY(p1, 45) );
		
		Vertice3D a, b, c;
		a = escala(p1, 2, 2, 2);		
		b = translacao(a, 3, 2, 2);
		c = rotacaoY(b, 45);
		
		System.out.println( a );
		System.out.println( b );
		System.out.println( c );
	}

}
