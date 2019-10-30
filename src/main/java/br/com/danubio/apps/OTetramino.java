
package br.com.danubio.apps;

import java.awt.Point;

public class OTetramino extends Tetramino {
    
    public OTetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[5], allPoints[8], allPoints[9]);
        
        moveTetramino(x, y);
    }
}
