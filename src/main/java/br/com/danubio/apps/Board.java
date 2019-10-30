
package br.com.danubio.apps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/*
*    16 x 22
*/
public class Board implements SettingObserver {
    
    private static final Color COLOR = Color.YELLOW;
    
    private Block[] blocks;
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    
    public Board(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        initBoard();
    }
    
    private void initBoard()
    {
       blocks = new Block[(2*width) + (2*height)-4];
       
       int index=0;
       Point point;
       for (int x=this.x; x < (this.x+width); x++) {
           for (int y=this.y; y < (this.y+height); y++) {
               if (contains(x, y)) {
                   point = new Point(x, y);
                   blocks[index++] = new Block(point, COLOR);
               }
           }
       }
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public boolean contains(int x, int y)
    {
        return x == this.x || x == this.x+width-1 || y == this.y || y == this.y+height-1;
    }
    
    public boolean contains(Point point)
    {
        return contains(point.x, point.y);
    }
    
    @Override
    public void updateObserver()
    {
        for (Block block : blocks) {
            block.updateObserver();
        }
    }
    
    public void drawBoard(Graphics2D g2d)
    {
        for(Block block : blocks) {
            block.drawBlock(g2d);
        }
    }
}