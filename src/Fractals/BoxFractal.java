package Fractals;

import javax.swing.*;
import java.awt.*;

public class BoxFractal extends JPanel
{
    private int levels;
    public BoxFractal(int lev)
    {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int x = xCenter - 243;
        int y = yCenter - 243;
        int width = 486;
        int height = 486;

        g.setColor(Color.RED);
        drawAndSplit(g, x, y, height, width, this.levels);

    }

    public void drawAndSplit(Graphics g, int x, int y, int h, int w, int times)
    {
        if(times == 0) return;
        else if(times == 1) {
            g.fillRect(x, y, w, h);
            return;
        } else if(times > 0) {
            int newHeight = h / 3;
            int newWidth = w / 3;
            // Top Left
            drawAndSplit(g,
                    x,
                    y,
                    newHeight, newWidth, times - 1);
            // Bottom Left
            drawAndSplit(g,
                    x,
                    y + 2 * newHeight,
                    newHeight, newWidth, times - 1);
            // Middle
            drawAndSplit(g,
                    x + newWidth,
                    y + newHeight,
                    newHeight, newWidth, times - 1);
            // Top Right
            drawAndSplit(g,
                    x + 2 * newWidth,
                    y,
                    newHeight, newWidth, times - 1);
            // Bottom Right
            drawAndSplit(g,
                    x + 2 * newHeight,
                    y + 2 * newWidth,
                    newHeight, newWidth, times - 1);
        }

    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxFractal panel = new BoxFractal(3);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}