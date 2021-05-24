import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class at2Panel extends JPanel {
   // exibe v�rias linhas, ret�ngulos e elipses
   private int xOrigem=320, yOrigem=240;
      private double escala = 50;
      double a = -10, passo = 1 ;


      public int getXint(double x)
      {
      return (int) (xOrigem + ( x * escala ));
      }
      public int getYint(double y)
      {
      return (int) (yOrigem - ( y * escala ));
      }
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // chama o m�todo paint da superclasse

      this.setBackground( Color.WHITE );

      // Primeira atividade

      g.setColor( Color.BLACK );                       
      g.drawLine( 0, 240, 640, 240 ); // horizontal
      g.drawLine( 320, 0, 320, 480 ); // vertical

      g.drawLine( 220, 235, 220, 245 );   // horizontal-vertical -1
      g.drawLine( 120, 235, 120, 245 );   // horizontal-vertical -2
      g.drawLine(  20, 235,  20, 245 );   // horizontal-vertical -3
      g.drawLine( 420, 235, 420, 245 );   // horizontal-vertical  1
      g.drawLine( 520, 235, 520, 245 );   // horizontal-vertical  2
      g.drawLine( 620, 235, 620, 245 );   // horizontal-vertical  3

      g.drawLine( 315, 340, 325, 340 );    // vertical-horizontal -1
      g.drawLine( 315, 440, 325, 440 );    // vertical-horizontal -2
      g.drawLine( 315, 140, 325, 140 );    // vertical-horizontal  1
      g.drawLine( 315,  40, 325,  40 );    // vertical-horizontal  2

      g.setColor( Color.RED );                       
      g.drawLine( 420, 140, 520, 40 );     // (1,1) + (2,2)

      g.setColor( Color.BLUE );                       
      g.drawString( "-3", 15, 260 );    // horizontal
      g.drawString( "-2", 115, 260 );   // horizontal
      g.drawString( "-1", 215, 260 );   // horizontal
      g.drawString( "1", 415, 260 );    // horizontal
      g.drawString( "2", 515, 260 );    // horizontal
      g.drawString( "3", 615, 260 );    // horizontal
      g.drawString( "-1", 300, 145 );   // vertical
      g.drawString( "-2", 300, 45 );    // vertical
      g.drawString( "1", 300, 445 );    // vertical
      g.drawString( "2", 300, 345 );    // vertical

   } 
}
