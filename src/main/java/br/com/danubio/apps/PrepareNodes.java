
package br.com.danubio.apps;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class PrepareNodes {
    private static final int NUM_BLOCKS = 4;
    private static final PrepareNodes uniquePrepareNodes = new PrepareNodes();
    
    private Random rand = new Random();
    private Color[] colors = { Color.RED, Color.YELLOW, new Color(51, 153, 255), new Color(51, 204, 255), new Color(0, 255, 51), 
        new Color(255, 204, 51), new Color(255, 102, 0), new Color(153, 102, 0)};
    private Node firstNode;
    private Point[] auxiliaryPoints;
    private Block[] blocks;
    
    private PrepareNodes()
    {
        firstNode = null;
        auxiliaryPoints = new Point[NUM_BLOCKS];
        for (int index=0; index < auxiliaryPoints.length; index++) {
            auxiliaryPoints[index] = new Point();
        }
    }
    
    private void initPrepareNodes(Node node)
    {
        firstNode = node;
        firstNode.setNext(firstNode);
        
        blocks = new Block[NUM_BLOCKS];
        Color color = colors[rand.nextInt(colors.length)];
        for (int index=0; index < blocks.length; index++) {
            blocks[index] = new Block(color);
        }
        
        firstNode.setBlocks(blocks);
        firstNode.updateNode();
        firstNode.setAuxiliaryPoints(auxiliaryPoints);
    }

    public void addNode(Node node)
    {
        Node nextNode = firstNode.getNext();
        firstNode.setNext(node);
        node.setNext(nextNode);
        
        node.setBlocks(blocks);
        node.setAuxiliaryPoints(auxiliaryPoints);
    }
    
    public static PrepareNodes getPrepareNodes(Node node)
    {
        uniquePrepareNodes.initPrepareNodes(node);
        
        return uniquePrepareNodes;
    }
}