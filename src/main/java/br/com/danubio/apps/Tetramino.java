
package br.com.danubio.apps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*       0  1  2  3
*       4  5  6  7
*       8  9  10 11
*       12 13 14 15
*
*
*/

public abstract class Tetramino implements SettingObserver {
    
    protected Node currentNode;
    protected PrepareNodes prepareNodes;
    protected Point[] allPoints;
    
    protected Tetramino()
    {
        prepareNodes = null;
        allPoints = new Point[16];
        for (int i=0; i < allPoints.length; i++) {
            allPoints[i] = new Point();
        }
        
    }
    
    protected void addNode(Point p1, Point p2, Point p3, Point p4)
    {
        Node node = new Node(p1, p2, p3, p4);
        
        if (prepareNodes == null) {
            prepareNodes = PrepareNodes.getPrepareNodes(node);
            currentNode = node;
            currentNode.updateNode();
        } else {
            prepareNodes.addNode(node);
        }
    }
    
    @Override
    public void updateObserver()
    {
        for (Block block : currentNode.getBlocks()) 
            block.updateObserver();
    }
    
    public Block[] getBlocks()
    {
        return currentNode.getBlocks();
    }
    
    protected Point[] getAllPoints()
    {
        return allPoints;
    }
    
    public void moveTetramino(int x, int y)
    {
        int index = 0;
        for (int _y=y; _y < y+4; _y++) {
            for (int _x=x; _x < x+4; _x++) {
                allPoints[index++].setLocation(_x, _y);
            }
        }
        
        updateObserver();
    }
    
    public boolean contains(Mosaic mosaic) 
    {
        boolean contains = false;
        for (Point point : currentNode.getPoints()) {
            if (mosaic.contains(point)) {
                contains = true;
                break;
            }
        }
        
        return contains;
    }
    
    public boolean rotate(Board board, Mosaic mosaic)
    {
        Node node = currentNode.getNext();
        boolean rotate = true;
        for (Point point : node.getPoints()) {
            if (board.contains(point) || mosaic.contains(point)) {
                rotate = false;
                break;
            }
        }
        
        if (rotate) {
            currentNode = currentNode.getNext();
            currentNode.updateNode();
        }
        
        return rotate;
    }
    
    public boolean goLeft(Board board, Mosaic mosaic)
    {
        boolean go = true;
        for (Point point : currentNode.getLeft()) {
            if (board.contains(point) || mosaic.contains(point)) {
                go = false;
                break;
            }
        }
        
        if (go) {
            for (Point point : getAllPoints()) {
                point.x--;
            }
            currentNode.updateNode();
        }
        
        return go;
    }
    
    public boolean goRight(Board board, Mosaic mosaic) 
    {
        boolean go = true;
        for (Point point : currentNode.getRight()) {
            if (board.contains(point) || mosaic.contains(point)) {
                go = false;
                break;
            }
        }
        
        if (go) {
            for (Point point : getAllPoints()) {
                point.x++;
            }
            currentNode.updateNode();
        }
        
        return go;
    }
    
    public boolean goDown(Board board, Mosaic mosaic)
    {
        boolean go = true;
        for(Point point : currentNode.getDown()) {
            if (board.contains(point) || mosaic.contains(point)) {
                go = false;
                break;
            }
        }
        
        if (go) {
            for (Point point : getAllPoints()) {
                point.y++;
            }
            currentNode.updateNode();
        } else {
            mosaic.addTetramino(this);
        }
        
        return go;
    }
    
    public void drawTetramino(Graphics2D g2d)
    {
        for (Block block : currentNode.getBlocks())
        {
            block.drawBlock(g2d);
        }
    }
    
}