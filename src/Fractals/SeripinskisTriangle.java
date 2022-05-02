package Fractals;

import javax.swing.*;
import java.awt.*;

public class SeripinskisTriangle extends JPanel
{
    private int levels;
    public SeripinskisTriangle(int lev)
    {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int [] xcoord = {xCenter - 128, xCenter, xCenter + 128};
        int [] ycoord = {yCenter + 128, yCenter - 128, yCenter + 128};

        g.setColor(Color.RED);
        drawAndSplit(g, xcoord, ycoord, this.levels);

    }

    public int [] midpoints(int [] x)
    {
        int [] m = new int [3];

        m[0] = (x[0] + x[1])/2;
        m[1] = (x[1] + x[2])/2;
        m[2] = (x[2] + x[0])/2;

        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {
        if (times == 0) return;
        else if (times == 1) {
            g.fillPolygon(x,y, 3);
            return;
        } else if (times > 0) {
            g.drawPolygon(x, y, 3);
            int[] midpointsX = midpoints(x);
            int[] midpointsY = midpoints(y);

            //Left Triangle
            drawAndSplit(
                    g,
                    new int[] {x[0], midpointsX[0], midpointsX[2]},
                    new int[] {y[0], midpointsY[0], midpointsY[2]},
                    times - 1
            );
            //Top Triangle
            drawAndSplit(
                    g,
                    new int[] {midpointsX[0], x[1], midpointsX[1]},
                    new int[] {midpointsY[0], y[1], midpointsY[1]},
                    times - 1
            );
            //Right Triangle
            drawAndSplit(
                    g,
                    new int[] {midpointsX[2], midpointsX[1], x[2]},
                    new int[] {midpointsY[2], midpointsY[1], y[2]},
                    times - 1
            );
        }

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeripinskisTriangle panel = new SeripinskisTriangle(4);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}