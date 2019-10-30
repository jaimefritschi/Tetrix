
package br.com.danubio.apps;

import java.awt.Point;

public class ITetramino extends Tetramino {

    public ITetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[5], allPoints[6], allPoints[7]);
        addNode(allPoints[1], allPoints[5], allPoints[9], allPoints[13]);
        
        moveTetramino(x, y);
    }
    
}