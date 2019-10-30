
package br.com.danubio.apps;

import java.awt.Point;

/*
*       0 1 2
*       3 4 5
*       6 7 8
*
*/
public class ZTetramino extends Tetramino {

    public ZTetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[8], allPoints[9], allPoints[13]);
        addNode(allPoints[5], allPoints[6], allPoints[8], allPoints[9]);
        addNode(allPoints[5], allPoints[9], allPoints[10], allPoints[14]);
        addNode(allPoints[9], allPoints[10], allPoints[12], allPoints[13]);
        
        moveTetramino(x, y);
    }
}
