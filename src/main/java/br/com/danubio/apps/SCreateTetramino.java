
package br.com.danubio.apps;

public class SCreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y)
    {
        return new STetramino(x, y);
    }
}
