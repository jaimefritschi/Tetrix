
package br.com.danubio.apps;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    private final Level level;
    private Score score;
    
    private JLabel scoreLabel;
    private JLabel lineDropLabel;
    private JLabel levelLabel;
    
    public ScorePanel(Level level, Score score)
    {
        this.level = level;
        this.score = score;
        
        JLabel showScoreLabel = new JLabel("Pontos");
        scoreLabel = new JLabel("0");
        JLabel showLineDropLabel = new JLabel("Linhas");
        lineDropLabel = new JLabel("0");
        JLabel showLevelLabel = new JLabel("Nível");
        levelLabel = new JLabel("1");
        
        this.setLayout(new GridLayout(6, 1));
        add(showScoreLabel);
        add(scoreLabel);
        add(showLineDropLabel);
        add(lineDropLabel);
        add(showLevelLabel);
        add(levelLabel);
    }
    
    public void updateDisplay()
    {
        scoreLabel.setText(String.valueOf(score.getScore()));
        lineDropLabel.setText(String.valueOf(score.getLines()));
        levelLabel.setText(String.valueOf(level.getLevel()));
    }
}
