
package br.com.danubio.apps;

public class OCreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y) 
    {
        return new OTetramino(x, y);
    }
}
