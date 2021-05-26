import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.Graphics2D;
import java.util.Random;

public class at3Panel extends JPanel {
    // Configurações iniciais
    private int xOrigem = 400, yOrigem = 300;
    private double escala = 50;

    public int getXint(double x) {
        return (int) (xOrigem + (x * escala));
    }

    public int getYint(double y) {
        return (int) (yOrigem - (y * escala));
    }

    // Definindo equações
    // Rotação
    public static Vertice rot(Vertice a, double ang) {
        ang = (Math.PI / 180) * ang;
        Vertice equacao = new Vertice(a.x * Math.cos(ang) - a.y * Math.sin(ang),
                a.y * Math.cos(ang) + a.x * Math.sin(ang));
        return equacao;
    }

    // Translaçao
    public static Vertice transl(Vertice a, double tx, double ty) {
        Vertice equacao = new Vertice(a.x + tx, a.y + ty);
        return equacao;
    }

    // Escala
    public static Vertice esc(Vertice a, double ex, double ey) {
        Vertice equacao = new Vertice(a.x * ex, a.y * ey);
        return equacao;
    }

    // desenha o Gráfico
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // chama o paintComponent da superclasse

        this.setBackground(Color.WHITE);
        // Plota os Eixos
        xOrigem = this.getWidth() / 2;
        yOrigem = this.getHeight() / 2;

        // Linhas
        g.setColor(Color.BLACK);
        g.drawLine(0, yOrigem, this.getWidth(), yOrigem);
        g.drawLine(xOrigem, 0, xOrigem, this.getHeight());
        for (double i = 0; i < ((this.getWidth() / 2) / escala); i++)
            g.drawLine(getXint(i), getYint(0.05), getXint(i), getYint(-0.05));
        for (double i = 0; i > -((this.getWidth() / 2) / escala); i--)
            g.drawLine(getXint(i), getYint(0.05), getXint(i), getYint(-0.05));
        for (double i = 0; i < ((this.getWidth() / 2) / escala); i++)
            g.drawLine(getXint(0.05), getYint(i), getXint(-0.05), getYint(i));
        for (double i = 0; i > -((this.getWidth() / 2) / escala); i--)
            g.drawLine(getXint(0.05), getYint(i), getXint(-0.05), getYint(i));

        // Numeros
        g.setColor(Color.BLUE);
        for (int i = 0; i < ((this.getWidth() / 2) / escala); i++)
            g.drawString("" + i, getXint(i - 0.1), getYint(-0.2));
        for (int i = 1; i < ((this.getWidth() / 2) / escala); i++)
            g.drawString("" + i, getXint(-0.2), getYint(i));
        for (int i = -1; i > -((this.getWidth() / 2) / escala); i--)
            g.drawString("" + i, getXint(i - 0.1), getYint(-0.2));
        for (int i = -1; i > -((this.getWidth() / 2) / escala); i--)
            g.drawString("" + i, getXint(-0.2), getYint(i));

        // poligono c/ 8 pontos
        g.setColor(Color.GREEN);
        double xValues[] = { -4, -3.5, -2.5, -3.5, -4, -4.5, -7, -4.5 };
        double yValues[] = { 4, 3.25, 2.5, 1.75, 1, 1.75, 2.5, 3.25 };    
        
        // Conversão
        int[] xPoints, yPoints;
        xPoints = new int[xValues.length];
        yPoints = new int[yValues.length];

        for(int i = 0; i < xValues.length; i++) {
            xPoints[i] = getXint(xValues[i]);
            yPoints[i] = getYint(yValues[i]);
        }
        g.drawPolygon(xPoints, yPoints, 8);
        
        // RTE - Letra a ----------------------------------------------------------------------------------
        // Rotação
        double xR[] = new double[xValues.length];
        double yR[] = new double[yValues.length];

        Vertice original, futuro;

        for(int i = 0; i < xValues.length; i++) {
            original = new Vertice(xValues[i], yValues[i]);
            futuro = rot(original, 60);
            xR[i] = futuro.x;
            yR[i] = futuro.y;
        }
        for(int i = 0; i < xR.length; i++) {
            xPoints[i] = getXint(xR[i]);
            yPoints[i] = getYint(yR[i]);
        }

        Graphics2D g2D = (Graphics2D) g;
        Random random = new Random();

        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        Polygon polygonR = new Polygon(xPoints, yPoints, 8);
        g2D.fill( polygonR );

        // Translação
        double xT[] = new double[xR.length];
        double yT[] = new double[yR.length];

        Vertice futuroR, T;

        for(int i = 0; i < xR.length; i++) {
            futuroR = new Vertice(xR[i], yR[i]);
            T = transl(futuroR, 3, 2);
            xT[i] = T.x;
            yT[i] = T.y;
        }
        for(int i = 0; i < xT.length; i++) {
            xPoints[i] = getXint(xT[i]);
            yPoints[i] = getYint(yT[i]);
        }

        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        Polygon polygonT = new Polygon(xPoints, yPoints, 8);
        g2D.fill( polygonT );

        // Escala
        double xE[] = new double[xT.length];
        double yE[] = new double[yT.length];

        Vertice TR, E;

        for(int i = 0; i < xT.length; i++) {
            TR = new Vertice(xT[i], yT[i]);
            E = esc(TR, 2, 2);
            xE[i] = E.x;
            yE[i] = E.y;
        }
        for(int i = 0; i < xE.length; i++) {
            xPoints[i] = getXint(xE[i]);
            yPoints[i] = getYint(yE[i]);
        }

        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawPolygon(xPoints, yPoints, 8);

        // ERT - Letra b ----------------------------------------------------------------------------------
        // Escala
        for(int i = 0; i < xValues.length; i++) {
            original = new Vertice(xValues[i], yValues[i]);
            futuro = esc(original, 2, 2);
            xR[i] = futuro.x;
            yR[i] = futuro.y;
        }
        for(int i = 0; i < xR.length; i++) {
            xPoints[i] = getXint(xR[i]);
            yPoints[i] = getYint(yR[i]);
        }

        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawPolygon(xPoints, yPoints, 8);

        // Rotação
        for(int i = 0; i < xR.length; i++) {
            futuroR = new Vertice(xR[i], yR[i]);
            T = rot(futuroR, 60);
            xT[i] = T.x;
            yT[i] = T.y;
        }
        for(int i = 0; i < xT.length; i++) {
            xPoints[i] = getXint(xT[i]);
            yPoints[i] = getYint(yT[i]);
        }
         
        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawPolygon(xPoints, yPoints, 8);

        // Translação
        for(int i = 0; i < xT.length; i++) {
            TR = new Vertice(xT[i], yT[i]);
            E = transl(TR, 3, 2);
            xE[i] = E.x;
            yE[i] = E.y;
        }
        for(int i = 0; i < xE.length; i++) {
            xPoints[i] = getXint(xE[i]);
            yPoints[i] = getYint(yE[i]);
        }

        g2D.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawPolygon(xPoints, yPoints, 8);
    }
}