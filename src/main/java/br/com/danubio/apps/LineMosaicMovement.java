
package br.com.danubio.apps;

import java.awt.Point;
import java.util.SortedMap;

public class LineMosaicMovement implements MosaicMovement {

    private MosaicMovement nextMosaicMovement;
    private SortedMap<Point, Block> lineMosaic;
    private Mosaic mosaic;
    private int score;
    
    public LineMosaicMovement(Mosaic mosaic, SortedMap<Point, Block> line, int score)
    {
        this.mosaic = mosaic;
        this.lineMosaic = line;
        this.score = score;
    }
    
    public int getScore()
    {
        return score;
    }
    
    @Override
    public boolean goDown()
    {
        lineMosaic.clear();
        mosaic.notifyFullLine(this);
        return true;
    }
    
    @Override
    public MosaicMovement getNext()
    {
        return nextMosaicMovement;
    }
    
    @Override
    public void setMosaicMovement(MosaicMovement movement)
    {
        nextMosaicMovement = movement;
    }
}