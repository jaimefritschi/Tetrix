
package br.com.danubio.apps;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TetrixController implements Controller {

    private final TetrixView view;
    private final TetraminoPanel tetraminoPanel;
    private final Level level;
    
    private Tetramino tetramino;
    private Board board;
    private Mosaic mosaic;
    
    private Controller controller;
    
    public TetrixController()
    {
        Settings settings = Settings.getSettings();
        
        tetraminoPanel = new TetraminoPanel(settings.getX() + 7, settings.getY());
        
        level = new Level(this);
        final Score score = new Score("UNKNOWN");
        final ScorePanel scorePanel = new ScorePanel(level, score);
        
        view = new TetrixView(this, tetraminoPanel, scorePanel);
        
        board = new Board(settings.getX(), settings.getY(), settings.getWidth(), settings.getHeight());
        mosaic = new Mosaic(board);
        mosaic.addFullLine(new FullLine() {
            @Override
            public void completedLine(LineMosaicMovement movement) 
            {
                score.setScore(movement.getScore(), level);
                scorePanel.updateDisplay();
            }
        });
        tetramino = tetraminoPanel.getTetramino();
        
        PauseController pauseController = new PauseController(this);
        TetraminoController tetraminoController = new TetraminoController(this);
        MosaicController mosaicController = new MosaicController(this);
        GameOverController gameOverController = new GameOverController(this);
        
        
        tetraminoController.setPauseController(pauseController);
        tetraminoController.setMosaicController(mosaicController);
        mosaicController.setTetraminoController(tetraminoController);
        mosaicController.setPauseController(pauseController);
        mosaicController.setGameOverController(gameOverController);
        pauseController.setController(tetraminoController);
        
        setController(pauseController);
    }
    
    public Board getBoard()
    {
        return board;
    }
    
    public Mosaic getMosaic()
    {
        return mosaic;
    }
    
    public Tetramino getTetramino()
    {
        return tetramino;
    }
    
    
    
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    
    public void setPlay(boolean play)
    {
        view.setPlay(play);
        
        if (play) {
            level.start();
        } else {
            level.stop();
        }
    }
    
    public boolean addTetramino()
    {
        tetramino = tetraminoPanel.getTetramino();
        return !tetramino.contains(mosaic);
    }
    
    public void repaint()
    {
        view.repaint();
    }
    
    @Override
    public void pause()
    {
        controller.pause();
    }
    
    @Override
    public void rotate()
    {
        controller.rotate();
    }
    
    @Override
    public void goDown()
    {
        controller.goDown();
    }
    
    @Override
    public void goLeft()
    {
        controller.goLeft();
    }
    
    @Override
    public void goRight()
    {
        controller.goRight();
    }
    
    @Override
    public void drawController(Graphics2D g2d)
    {
        controller.drawController(g2d);
    }
}