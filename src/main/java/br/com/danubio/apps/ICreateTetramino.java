
package br.com.danubio.apps;

public class ICreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y)
    {
        return new ITetramino(x, y);
    }
}
