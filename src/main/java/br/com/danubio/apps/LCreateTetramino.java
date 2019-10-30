
package br.com.danubio.apps;

public class LCreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y)
    {
        return new LTetramino(x, y);
    }
}
