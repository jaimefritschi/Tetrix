
package br.com.danubio.apps;

public interface MosaicMovement {
    public boolean goDown();
    public MosaicMovement getNext();
    public void setMosaicMovement(MosaicMovement movement);
}
