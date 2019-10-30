
package br.com.danubio.apps;

import java.awt.Graphics2D;
import java.awt.Point;

public class Node {

    private Point[] nodePoints;
    private Node next;
    private Block[] blocks;
    private Point[] auxiliaryPoints;
    
    public Node(Point p1, Point p2, Point p3, Point p4)
    {
        nodePoints = new Point[4];
        nodePoints[0] = p1;
        nodePoints[1] = p2;
        nodePoints[2] = p3;
        nodePoints[3] = p4;
    }
    
    public void setBlocks(Block[] blocks)
    {
        this.blocks = blocks;
    }
    
    public void setAuxiliaryPoints(Point[] auxiliary)
    {
        this.auxiliaryPoints = auxiliary;
    }
    
    public void updateNode()
    {
        for (int index=0; index < blocks.length; index++) {
            this.blocks[index].setPoint(nodePoints[index]);
        }
    }
    
    public void setNext(Node next)
    {
        this.next = next;
    }
    
    public Node getNext()
    {
        return next;
    }
    
    public Point[] getPoints()
    {
        return nodePoints;
    }
    
    public Block[] getBlocks()
    {
        return blocks;
    }
    
    public Point[] getLeft()
    {
        for (int index=0; index < nodePoints.length; index++) {
            auxiliaryPoints[index].setLocation(nodePoints[index]);
            auxiliaryPoints[index].x--;
        }
       
        return auxiliaryPoints;
    }
    
    public Point[] getRight()
    {
        for (int index=0; index < nodePoints.length; index++) {
            auxiliaryPoints[index].setLocation(nodePoints[index]);
            auxiliaryPoints[index].x++;
        }
        
        return auxiliaryPoints;
    }
    
    public Point[] getDown()
    {
        for (int index=0; index < nodePoints.length; index++) {
            auxiliaryPoints[index].setLocation(nodePoints[index]);
            auxiliaryPoints[index].y++;
        }
        
        return auxiliaryPoints;
    }
    
    public void drawNode(Graphics2D g2d)
    {
        for (Block block : blocks)
        {
            block.drawBlock(g2d);
        }
    }
}