
package br.com.danubio.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Level implements ActionListener {

    private Timer timer;
    private TetrixController tetrixController;
    private int level;
    private int delay;
    
    public Level(TetrixController tetrixController)
    {
        this.tetrixController = tetrixController;
        level = 0;
        timer = new Timer(delay, this);
        increaseLevel();
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void increaseLevel()
    {
        int timestep = (int) Math.round(80 + 800.0 * Math.pow(0.75, ++level - 1));
        delay = Math.max(10, timestep);
        timer.setDelay(delay);
    }
    
    public void start()
    {
        timer.start();
    }
    
    public void stop()
    {
        timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        tetrixController.goDown();
    }
}