
package br.com.danubio.apps;

import java.awt.Graphics2D;

public class GameOverController implements Controller {

    private TetrixController tetrixController;
    
    public GameOverController(TetrixController tetrixController)
    {
        this.tetrixController = tetrixController;
    }
    
    @Override
    public void pause()
    {
        
    }
    
    @Override
    public void goRight()
    {
        
    }
    
    @Override
    public void goLeft()
    {
        
    }
    
    @Override
    public void goDown()
    {
        tetrixController.setPlay(false);
    }
    
    @Override
    public void rotate()
    {
        
    }
    
    @Override
    public void drawController(Graphics2D g2d)
    {
        tetrixController.getBoard().drawBoard(g2d);
        tetrixController.getMosaic().drawMosaic(g2d);
    }
}