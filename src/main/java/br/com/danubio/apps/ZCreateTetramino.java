
package br.com.danubio.apps;

public class ZCreateTetramino implements CreateTetramino {

    public Tetramino createTetramino(int x, int y) {
        return new ZTetramino(x, y);
    }

}
