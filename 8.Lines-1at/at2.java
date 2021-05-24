import java.awt.Color;
import javax.swing.JFrame;

public class at2 {
    public static void main( String args[] )
   {
      JFrame frame = 
         new JFrame( "Atividade 2 - Gráfico sin-cos" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
      at2Panel panel = 
         new at2Panel(); 
      panel.setBackground( Color.WHITE ); 
      frame.add( panel );
      frame.setSize( 640, 480 ); 
      frame.setVisible( true ); 
   } 
}
