import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static java.lang.Math.*;

public class at2Panel extends JPanel {
    private int xOrigem = 320, yOrigem = 240;
    private double escala = 50;
    double a = -10, passo = 1;

    public int getXint(double x) {
        return (int) (xOrigem + (x * escala));
    }

    public int getYint(double y) {
        return (int) (yOrigem - (y * escala));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // chama o m�todo paint da superclasse

        this.setBackground(Color.WHITE);

        xOrigem = this.getWidth() / 32;
        yOrigem = this.getHeight() / 2;

        g.setColor(Color.BLACK);
        g.drawLine(0, yOrigem, this.getWidth(), yOrigem); // horizontal
        g.drawLine(xOrigem, 0, xOrigem, this.getHeight() * 2); // vertical

        // linhas da escala
        for (double i = 0; i < (this.getWidth() / escala); i++)
            g.drawLine(getXint(i), getYint(0.05), getXint(i), getYint(-0.05));
        for (double i = 0; i < ((this.getWidth() / 2) / escala); i++)
            g.drawLine(getXint(0.05), getYint(i), getXint(-0.05), getYint(i));
        for (double i = 0; i > -((this.getWidth() / 2) / escala); i--)
            g.drawLine(getXint(0.05), getYint(i), getXint(-0.05), getYint(i));

        // numeros
        g.setColor(Color.BLUE);
        g.drawString("0", getXint(-0.2), getYint(-0.3));
        for (int i = 1; i < (this.getWidth() / escala); i++)
            g.drawString("" + i, getXint(i - 0.07), getYint(-0.3));
        for (int i = 1; i < ((this.getWidth() / 2) / escala); i++)
            g.drawString("" + i, getXint(-0.3), getYint(i - 0.07));
        for (int i = -1; i > -((this.getWidth() / 2) / escala); i--)
            g.drawString("" + i, getXint(i - 0.1), getYint(-0.2));
        for (int i = -1; i > -((this.getWidth() / 2) / escala); i--)
            g.drawString("" + i, getXint(-0.3), getYint(i - 0.07));

        // função seno
        g.setColor(Color.RED);
        for (double x = -getWidth(); x <= getWidth(); x += 0.01) {
            double y = sin(x);
            g.drawLine(getXint(x), getYint(y), getXint(x), getYint(y));
        }

        // função cosseno
        g.setColor(Color.GREEN);
        for (double x = -getWidth(); x <= getWidth(); x += 0.01) {
            double y = cos(x);
            g.drawLine(getXint(x), getYint(y), getXint(x), getYint(y));
        }

    }
}
