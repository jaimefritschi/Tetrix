package br.com.danubio.apps;

import java.awt.Graphics2D;

public interface Controller {
    public void pause();
    public void goRight();
    public void goLeft();
    public void goDown();
    public void rotate();
    public void drawController(Graphics2D g2d);
}
