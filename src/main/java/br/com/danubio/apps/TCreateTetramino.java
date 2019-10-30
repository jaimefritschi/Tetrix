
package br.com.danubio.apps;

public class TCreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y)
    {
        return new TTetramino(x, y);
    }
}
