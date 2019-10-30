
package br.com.danubio.apps;

import java.awt.Graphics2D;

public class TetraminoController implements Controller {
    
    private final TetrixController tetrixController;
    private PauseController pauseController;
    private MosaicController mosaicController;
    
    public TetraminoController(TetrixController tetrixController)
    {
        this.tetrixController = tetrixController;
    }
    
    public void setPauseController(PauseController controller)
    {
        pauseController = controller;
    }
    
    public void setMosaicController(MosaicController controller)
    {
        mosaicController = controller;
    }
    
    @Override
    public void pause()
    {
        tetrixController.setPlay(false);
        pauseController.setController(this);
        tetrixController.setController(pauseController);
    }
    
    @Override
    public void goRight()
    {
        tetrixController.getTetramino().goRight(tetrixController.getBoard(), tetrixController.getMosaic());
        tetrixController.repaint();
    }
    
    @Override
    public void goLeft()
    {
        tetrixController.getTetramino().goLeft(tetrixController.getBoard(), tetrixController.getMosaic());
        tetrixController.repaint();
    }
    
    @Override
    public void goDown()
    {
        if (!tetrixController.getTetramino().goDown(tetrixController.getBoard(), tetrixController.getMosaic()))
            tetrixController.setController(mosaicController);
        
        tetrixController.repaint();
    }
    
    @Override
    public void rotate()
    {
        tetrixController.getTetramino().rotate(tetrixController.getBoard(), tetrixController.getMosaic());
        tetrixController.repaint();
    }
    
    @Override
    public void drawController(Graphics2D g2d)
    {
        tetrixController.getBoard().drawBoard(g2d);
        tetrixController.getTetramino().drawTetramino(g2d);
        tetrixController.getMosaic().drawMosaic(g2d);
    }

}