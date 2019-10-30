
package br.com.danubio.apps;

import java.awt.Graphics2D;

public class MosaicController implements Controller {
    
    private final TetrixController tetrixController;
    
    private PauseController pauseController;
    private TetraminoController tetraminoController;
    private GameOverController gameOverController;
    
    public MosaicController(TetrixController tetrixController)
    {
        this.tetrixController = tetrixController;
    }
    
    public void setTetraminoController(TetraminoController tetraminoController)
    {
        this.tetraminoController = tetraminoController;
    }
    
    public void setPauseController(PauseController pauseController)
    {
        this.pauseController = pauseController;
    }
    
    public void setGameOverController(GameOverController gameOverController)
    {
        this.gameOverController = gameOverController;
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
        
    }
    
    @Override
    public void goLeft()
    {
        
    }
    
    @Override
    public void goDown()
    {
        if (!tetrixController.getMosaic().goDown()) {
            if (tetrixController.addTetramino()) {
                tetrixController.setController(tetraminoController);
            } else {
                tetrixController.setController(gameOverController);
            }
        }
        
        tetrixController.repaint();
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