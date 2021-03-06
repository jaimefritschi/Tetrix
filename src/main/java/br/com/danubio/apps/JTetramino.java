
package br.com.danubio.apps;

import java.awt.Point;

/*
*       0 1 2
*       3 4 5
*       6 7 8
*
*/

public class JTetramino extends Tetramino {
    
    public JTetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[5], allPoints[6], allPoints[10]);
        addNode(allPoints[1], allPoints[2], allPoints[5], allPoints[9]);
        addNode(allPoints[0], allPoints[4], allPoints[5], allPoints[6]);
        addNode(allPoints[1], allPoints[5], allPoints[8], allPoints[9]);
        
        moveTetramino(x, y);
    }
}
