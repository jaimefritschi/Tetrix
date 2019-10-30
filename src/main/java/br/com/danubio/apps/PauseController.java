
package br.com.danubio.apps;

import java.awt.Graphics2D;

public class PauseController implements Controller {
    
    private Controller controller;
    
    private final TetrixController tetrixController;
    
    public PauseController(TetrixController tetrixController)
    {
        this.tetrixController = tetrixController;
    }
    
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    
    // Como é um controlador de pausa 
    // a função pause coloca o controlador tetrix em jogo novamente
    @Override
    public void pause()
    {
        tetrixController.setPlay(true);
        tetrixController.setController(controller);
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
        
    }
    
    @Override
    public void rotate()
    {
        
    }
    
    @Override
    public void drawController(Graphics2D g2d)
    {
        tetrixController.getBoard().drawBoard(g2d);
        tetrixController.getTetramino().drawTetramino(g2d);
        tetrixController.getMosaic().drawMosaic(g2d);
    }
}