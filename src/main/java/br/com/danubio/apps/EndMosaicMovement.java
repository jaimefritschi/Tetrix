
package br.com.danubio.apps;

public class EndMosaicMovement implements MosaicMovement {

    @Override
    public boolean goDown()
    {
        return false;
    }
    
    @Override
    public MosaicMovement getNext()
    {
        return this;
    }
    
    @Override
    public void setMosaicMovement(MosaicMovement movement)
    {
        
    }
}
