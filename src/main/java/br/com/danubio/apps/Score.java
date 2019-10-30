
package br.com.danubio.apps;

import java.util.Date;

public class Score {
    private static final int LINES_PER_LEVEL = 10;
    
    private String player;
    private Date date;
    private int score;
    private int lines;
    
    public Score(String player)
    {
        this.player = player;
        this.date = new Date();
        this.score = 0;
        this.lines = 0;
    }
    
    public int getLines() 
    {
        return lines;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public void setScore(int score, Level level)
    {
        this.score += score * level.getLevel();
        lines++;
        if ((lines % LINES_PER_LEVEL) == 0) {
            level.increaseLevel();
        }
    }
    
    public int getScore()
    {
        return score;
    }
            
}
