
package br.com.danubio.apps;

import java.awt.Point;

/*
*       0
*     1 2 3
*       4
*
*
*/

public class TTetramino extends Tetramino {

    public TTetramino(int x, int y)
    {
        addNode(allPoints[4], allPoints[5], allPoints[6], allPoints[9]);
        addNode(allPoints[1], allPoints[5], allPoints[6], allPoints[9]);
        addNode(allPoints[1], allPoints[4], allPoints[5], allPoints[6]);
        addNode(allPoints[1], allPoints[4], allPoints[5], allPoints[9]);
        
        moveTetramino(x, y);
    }
}