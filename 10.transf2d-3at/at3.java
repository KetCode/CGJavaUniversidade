import java.awt.Color;
import javax.swing.JFrame;

public class at3 {
    public static void main( String args[] )
   {
      JFrame frame = 
         new JFrame( "Atividade 3 - Transf2D" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
      at3Panel panel = 
         new at3Panel(); 
      panel.setBackground( Color.WHITE ); 
      frame.add( panel );
      frame.setSize( 800, 600 ); 
      frame.setVisible( true ); 
   } 
}
