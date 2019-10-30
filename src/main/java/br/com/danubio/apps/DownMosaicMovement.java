
package br.com.danubio.apps;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class DownMosaicMovement implements MosaicMovement {

    private MosaicMovement nextMosaicMovement;
    private TreeMap<Point, Block> mosaicMap;
    private Point endPoint;
    private Comparator pointComparator;
    
    public DownMosaicMovement(TreeMap<Point, Block> mosaicMap, Point point)
    {
        this.mosaicMap = mosaicMap;
        this.endPoint = point;
        pointComparator = new PointComparator();
    }
    
    @Override
    public boolean goDown()
    {
        // endPoint é anterior a linha recém removida
        // se não tiver blocos anteriores então mosaicMap.firstKey 
        // vai retornar um ponto posterior ao endPoint criando uma IllegalArgumentException
        
        if (pointComparator.compare(mosaicMap.firstKey(), endPoint) < 0) {
            
            SortedMap<Point, Block> previousBlocks = mosaicMap.subMap(mosaicMap.firstKey(), endPoint);
            
            List<Block> blockList = new ArrayList<Block>();
            for (Block block : previousBlocks.values()) {
                blockList.add(block);
            }

            previousBlocks.clear();
            for (Block block : blockList) {
                Point point = block.getPoint();
                point.y++;
                block.updateObserver();
                mosaicMap.put(block.getPoint(), block);
            }
        }
        
        return true;
    }
    
    @Override
    public void setMosaicMovement(MosaicMovement movement)
    {
        nextMosaicMovement = movement;
    }
    
    @Override
    public MosaicMovement getNext()
    {
        return nextMosaicMovement;
    }
}
