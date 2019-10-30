
package br.com.danubio.apps;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrixView {
    private static String RESOURCES_IMAGES = "images/";
    private Controller controll;
    private JPanel tetrixPanel;
    private JPanel tetraminoPanel;
    private JButton playButton;
    private ImageIcon playIcon;
    private ImageIcon pauseIcon;
            
    
    public TetrixView(Controller controller, JPanel tetraminoPanel, JPanel scorePanel)
    {
        this.controll = controller;
        this.tetraminoPanel = tetraminoPanel;
        
        JFrame window = new JFrame("Tetrix Power");
        
        tetrixPanel = new JPanel()
        {
            Dimension preferredSize;
            {
                setFocusable(true);
                
                addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent event)
                    {
                        switch(event.getKeyCode()) {
                            case KeyEvent.VK_UP:
                                controll.rotate();
                                break;
                            case KeyEvent.VK_DOWN:
                                controll.goDown();
                                break;
                            case KeyEvent.VK_LEFT:
                                controll.goLeft();
                                break;
                            case KeyEvent.VK_RIGHT:
                                controll.goRight();
                                break;
                        }
                    }
                });
                
                preferredSize = new Dimension(300, 400);
            }
            
            @Override
            public Dimension getMinimumSize() 
            {
                return getPreferredSize();
            }
            
            @Override
            public Dimension getPreferredSize()
            {
                return preferredSize;
            }
            
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                controll.drawController(g2d);
            }
            
        };
        
        playButton = new JButton();
        playIcon = createImageIcon(RESOURCES_IMAGES + "play.png");
        playButton.setIcon(playIcon);
        pauseIcon = createImageIcon(RESOURCES_IMAGES + "pause.png");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                controller.pause();
            }
        });
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        window.setLayout(layout);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(tetrixPanel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(tetraminoPanel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(scorePanel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        layout.setConstraints(playButton, constraints);
        
        window.add(tetrixPanel);
        window.add(tetraminoPanel);
        window.add(scorePanel);
        window.add(playButton);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 700);
        window.setVisible(true);
    }
    
    public void setPlay(boolean play)
    {
        if (play) {
            playButton.setIcon(pauseIcon);
        } else {
            playButton.setIcon(playIcon);
        }
        tetrixPanel.requestFocus();
    }
    
    public void repaint()
    {
        tetrixPanel.repaint();
    }
   
  /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TetrixView.class.getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}