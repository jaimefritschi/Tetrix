
package br.com.danubio.apps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

public class Block extends RoundRectangle2D.Float implements SettingObserver {
    private static final Color BOARD = new Color(51, 51, 51);
    private static final Stroke boardStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
    private Color color;
    private Point point;
    
    public Block(Point point, Color color)
    {
        setPoint(point);
        this.color = color;
    }
    
    public Block(Color color)
    {
        this(null, color);
    }
    
    public Point getPoint()
    {
        return point;
    }
    
    public void setPoint(Point point)
    {
        if (point != null) {
            this.point = point;
            updateObserver();
        }
    }
    
    @Override
    public void updateObserver()
    {
        int amountPixels = Settings.getSettings().getAmountPixels();
        setRoundRect(this.point.x * amountPixels, this.point.y * amountPixels, amountPixels, amountPixels, 10, 10);
    }
    
    public void drawBlock(Graphics2D g2d)
    {
        g2d.setPaint(color);
        g2d.fill(this);
        g2d.setPaint(BOARD);
        g2d.setStroke(boardStroke);
        g2d.draw(this);
    }
}