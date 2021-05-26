// Fig. 12.29: ShapesJPanel.java
// Demonstrando algumas formas 2D Java.
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BasicStroke;  
import java.awt.GradientPaint;
import java.awt.TexturePaint;
import java.awt.Rectangle;
import java.awt.Graphics2D;           
import java.awt.geom.Ellipse2D;       
import java.awt.geom.Rectangle2D;     
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Arc2D;           
import java.awt.geom.Line2D;          
import java.awt.image.BufferedImage;  
import javax.swing.JPanel;

public class ShapesJPanel extends JPanel 
{
   // desenha formas com Java 2D API
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // chama o paintComponent da superclasse

      Graphics2D g2d = ( Graphics2D ) g; // faz coer��o de g para Graphics2D

      // desenha elipse 2D preenchida com um gradiente azul-amarelo
      g2d.setPaint( new GradientPaint( 5, 30, Color.BLUE, 35, 100,
         Color.YELLOW, true ) );                                  
      g2d.fill( new Ellipse2D.Double( 5, 30, 65, 100 ) );         

      // desenha ret�ngulo 2D em vermelho
      g2d.setPaint( Color.RED );                            
      g2d.setStroke( new BasicStroke( 10.0f ) );            
      g2d.draw( new Rectangle2D.Double( 80, 30, 65, 100 ) );

      // desenha ret�ng. arred. 2D com um fundo armazenado em buffer
      BufferedImage buffImage = new BufferedImage( 10, 10,   
         BufferedImage.TYPE_INT_RGB );                       

      // obt�m Graphics2D de bufferImage e desenha nela
      Graphics2D gg = buffImage.createGraphics();
      gg.setColor( Color.YELLOW ); // desenha em amarelo
      gg.fillRect( 0, 0, 10, 10 ); // desenha um ret�ngulo preenchido
      gg.setColor( Color.BLACK );  // desenha em preto
      gg.drawRect( 1, 1, 6, 6 ); // desenha um ret�ngulo
      gg.setColor( Color.BLUE ); // desenha em azul
      gg.fillRect( 1, 1, 3, 3 ); // desenha um ret�ngulo preenchido
      gg.setColor( Color.RED ); // desenha em vermelho
      gg.fillRect( 4, 4, 3, 3 ); // desenha um ret�ngulo preenchido

      // pinta buffImage sobre o JFrame
      g2d.setPaint( new TexturePaint( buffImage,                   
         new Rectangle( 10, 10 ) ) );                              
      g2d.fill(                                                    
         new RoundRectangle2D.Double( 155, 30, 75, 100, 50, 50 ) );

      // Desenha arco 2D em forma de torta em branco
      g2d.setPaint( Color.WHITE );                                 
      g2d.setStroke( new BasicStroke( 6.0f ) );                    
      g2d.draw(                                                    
         new Arc2D.Double( 240, 30, 75, 100, 0, 270, Arc2D.PIE ) );

      // Desenha linhas 2D em verde e amarelo
      g2d.setPaint( Color.GREEN );                       
      g2d.draw( new Line2D.Double( 395, 30, 320, 150 ) );

      // desenha uma linha em 2D utilizando tra�o
      float dashes[] = { 10 }; // especifica padr�o de tra�o
      g2d.setPaint( Color.YELLOW );                            
      g2d.setStroke( new BasicStroke( 4, BasicStroke.CAP_ROUND,
         BasicStroke.JOIN_ROUND, 10, dashes, 0 ) );            
      g2d.draw( new Line2D.Double( 320, 30, 395, 150 ) );     
      
      // desenha bandeira do Brasil #foraBostonaro #elenão
      // foda-se bolsonaro e, se você gosta dele, foda-se vc tbm
      g2d.setPaint( new Color( 0, 156, 59) );                            
      g2d.setStroke( new BasicStroke( 0.0f ) );            
      g2d.draw( new Rectangle2D.Double( 80, 220, 250, 150 ) ); // g2d.drawRect( 80, 220, 250, 150 );
      g2d.fillRect( 80, 220, 250, 150);

      g2d.setPaint( new Color( 255, 223, 0) );
      

      /*g2d.setTransform(AffineTransform.getRotateInstance(Math.PI / 4, 150, 370));
      g2d.draw( new Rectangle2D.Double( 89, 220, 100, 100 ) ); // g2d.drawRect( 80, 220, 250, 150 );
      g2d.fillRect( 89, 220, 100, 100);   */

      /* g2d.draw( new Line2D.Double( 80, 295, 205, 220 ) );
      g2d.setPaint( Color.RED );                            
      g2d.draw( new Line2D.Double( 330, 295, 206, 220 ) );
      g2d.setPaint( Color.BLUE ); 
      g2d.draw( new Line2D.Double( 80, 295, 205, 370 ) );
      g2d.setPaint( Color.WHITE );                            
      g2d.draw( new Line2D.Double( 330, 295, 206, 370 ) );

      g.setColor( Color.GREEN );  */                     
      /* int xValues3[] = { 80, 205, 330, 206 };
      int yValues3[] = { 295, 220, 295, 370 };     
      g.fillPolygon( xValues3, yValues3, 4 ); */

      int xValues3[] = { 100, 205, 310, 205 };
      int yValues3[] = { 295, 240, 295, 350 };     
      g.fillPolygon( xValues3, yValues3, 4 );

      int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
      int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
      g.fillPolygon( xPoints, yPoints, 10 );
      

      g2d.setPaint( new Color( 0, 39, 118) );
      g2d.fillOval( 170, 260, 70, 70 );
      

      g2d.setPaint( new Color( 255, 255, 255) );
      /* g2d.fillOval( 170, 290, 70, 10 );      
      g.setColor( Color.WHITE );
      g2d.setStroke( new BasicStroke( 2.0f ) );            
      for (int i = 0; i < 5; i = i + 1){
         g.drawArc( 100-i, 100+i, 90, 80, 0, 110 );
      } */
      g2d.setStroke( new BasicStroke( 8.0f ) );            
      g2d.drawArc( 153, 280, 90, 80, 390, 90 );
      
      g2d.setPaint( Color.BLACK );                            
      g2d.setFont( new Font( "SansSerif", Font.PLAIN, 8 ) );
      g2d.drawString( "F", 174, 288 );
      g2d.drawString( "O", 178, 286 );
      g2d.drawString( "R", 184, 285 );
      g2d.drawString( "A", 189, 284 );
      g2d.drawString( "B", 196, 283 );
      g2d.drawString( "O", 200, 283 );
      g2d.drawString( "L", 205, 284 );
      g2d.drawString( "S", 208, 285 );
      g2d.drawString( "O", 212, 287 );
      g2d.drawString( "N", 217, 288 );
      g2d.drawString( "A", 222, 290 );
      g2d.drawString( "R", 226, 293 );
      g2d.drawString( "O", 230, 297 );


      g.setColor( Color.BLACK );                         
      g2d.setStroke( new BasicStroke( 3.0f ) );
      // g.drawRect( 378, 262, 40, 40 );            
      g.drawRect( ((this.getWidth() / 2) - 22), ((this.getHeight() / 2) - 22), 40, 40 );            
      g.setColor( Color.BLUE );                         
      g.drawRect( 1, 1, (this.getWidth() - 2) , (this.getHeight() - 2) );            
      g.setColor( Color.RED );                         
      g.drawLine(0, 0, 797, 565);
      g.drawLine(0, 565, 797, 0);
   } // fim do m�todo paintComponent
} // fim da classe ShapesJPanel


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/