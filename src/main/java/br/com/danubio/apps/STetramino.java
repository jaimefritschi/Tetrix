
package br.com.danubio.apps;

import java.awt.Point;

public class STetramino extends Tetramino {

    public STetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[5], allPoints[9], allPoints[10]);
        addNode(allPoints[6], allPoints[9], allPoints[10], allPoints[13]);
        addNode(allPoints[8], allPoints[9], allPoints[13], allPoints[14]);
        addNode(allPoints[5], allPoints[8], allPoints[9], allPoints[12]);
        
        moveTetramino(x, y);
    }
    
}
