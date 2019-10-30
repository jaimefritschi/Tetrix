
package br.com.danubio.apps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Mosaic {
    
    private static final Random rand = new Random();
    private static final Color  COLOR = new Color(0, 100, 0);
    private static final int[] SCORE = { 40, 60, 200, 900 };
    
    // Utilizado para isolar as linhas do mosaicMap
    private Map<Integer, LinePoint> lineMap;
    
    private TreeMap<Point, Block> mosaicMap;
    
    private MosaicMovement currentMovement;
    
    private List<FullLine> fullLineList;
    
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int size;
    
    public Mosaic(Board board)
    {
        x = board.getX()+1;
        y = board.getY()+1;
        width = board.getWidth()-2;
        height = board.getHeight()-2;
        size = width;
        
        lineMap = new HashMap<Integer, LinePoint>();
        mosaicMap = new TreeMap<Point, Block>(new PointComparator());
        fullLineList = new ArrayList<FullLine>();
        
        for (int h=0; h < height; h++) {
            lineMap.put(y+h, new LinePoint(new Point(x, y+h), new Point(x+width, y+h)));
            LinePoint line = lineMap.get(y+h);
        }
        
        for (int l =1; l < 7; l++) {
            LinePoint line = lineMap.get(y + height - l);
            if (line != null) {
                SortedMap<Point, Block> blocks = mosaicMap.subMap(line.initPoint(), line.endPoint());
                int r = rand.nextInt(width);
                for (int w = x; w < x + width; w++) {
                    if (w != x+r) {
                        Point point = new Point(w, y + height - l);
                        blocks.put(point, new Block(point, COLOR));
                    }
                }
            }
        }
        
        addMosaicMovement(new EndMosaicMovement());
    }
    
    private void addMosaicMovement(MosaicMovement movement)
    {
        MosaicMovement next = currentMovement;
        currentMovement = movement;
        currentMovement.setMosaicMovement(next);
    }
    
    public boolean goDown()
    {
        boolean go = currentMovement.goDown();
        currentMovement = currentMovement.getNext();
        return go;
    }
    
    public boolean contains(Point point)
    {
        Block block = mosaicMap.get(point);
        return (block != null);
    }
    
    public void addTetramino(Tetramino tetramino)
    {
        TreeSet<Integer> keySet = new TreeSet<Integer>();
        
        for (Block block : tetramino.getBlocks()) {
            mosaicMap.put(block.getPoint(), block);
            keySet.add(block.getPoint().y);
        }
        
        Iterator<Integer> keyIterator = keySet.descendingIterator();
        int score=0;
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            LinePoint line = lineMap.get(key);
            SortedMap<Point, Block> blocks = mosaicMap.subMap(line.initPoint(), line.endPoint());
            
            if (blocks.size() == size) {
                LinePoint previous = lineMap.get(key - 1);
                addMosaicMovement(new DownMosaicMovement(mosaicMap, previous.endPoint()));
                addMosaicMovement(new LineMosaicMovement(this, blocks, SCORE[score++]));
            }
        }
    }
    
    public void addFullLine(FullLine line)
    {
        fullLineList.add(line);
    }
    
    void notifyFullLine(LineMosaicMovement movement)
    {
        for (FullLine line : fullLineList) {
            line.completedLine(movement);
        }
    }
    
    public void drawMosaic(Graphics2D g2d)
    {
        for (Block block : mosaicMap.values()) {
            block.drawBlock(g2d);
        }
        
    }
}

class LinePoint {
    private Point initPoint;
    private Point endPoint;
    
    LinePoint(Point initPoint, Point endPoint)
    {
        this.initPoint = initPoint;
        this.endPoint = endPoint;
    }
    
    public Point initPoint()
    {
        return initPoint;
    }
    
    public Point endPoint()
    {
        return endPoint;
    }
}

class PointComparator implements Comparator<Point> {

    public int compare(Point aPoint, Point bPoint) {
        int result = (aPoint.y - bPoint.y);
        if (result != 0) {
            return result;
        }
        
        return (aPoint.x - bPoint.x);
    }
}
