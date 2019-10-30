
package br.com.danubio.apps;

public class JCreateTetramino implements CreateTetramino {

    @Override
    public Tetramino createTetramino(int x, int y)
    {
        return new JTetramino(x, y);
    }
}
