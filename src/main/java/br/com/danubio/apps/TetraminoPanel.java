
package br.com.danubio.apps;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TetraminoPanel extends JPanel {

    private static final int X_POS = 3;
    private static final int Y_POS = 3;
    
    private final Board board;
    private Tetramino tetramino;
    private final TetraminoFactory factory;
    private final int x;
    private final int y;
    
    private final Dimension preferredDimension;
    
    public TetraminoPanel(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.setFocusable(false);
        preferredDimension = new Dimension(80, 100);
        
        
        board = new Board(0, 0, 9, 9);
        
        factory = new TetraminoFactory(X_POS, Y_POS);
        tetramino = factory.createTetramino();
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return preferredDimension;
    }
    
    @Override
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
    
    public Tetramino getTetramino()
    {
        Tetramino aux = tetramino;
        aux.moveTetramino(x, y);
        tetramino = factory.createTetramino();
        repaint();
        
        return aux;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        board.drawBoard(g2d);
        tetramino.drawTetramino(g2d);
    }
}