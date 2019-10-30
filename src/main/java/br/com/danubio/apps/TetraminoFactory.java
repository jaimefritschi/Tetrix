
package br.com.danubio.apps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TetraminoFactory {
    
    private static final Random rand = new Random();
    private final List<CreateTetramino> createList;
    private final int x; 
    private final int y;
    
    public TetraminoFactory(int x, int y)
    {
        createList = new ArrayList<CreateTetramino>();
        this.x = x;
        this.y = y;
        
        createList.add(new TCreateTetramino());
        createList.add(new ZCreateTetramino());
        createList.add(new SCreateTetramino());
        createList.add(new OCreateTetramino());
        createList.add(new LCreateTetramino());
        createList.add(new ICreateTetramino());
        createList.add(new JCreateTetramino());
    }

    public Tetramino createTetramino() 
    {
        int index = rand.nextInt(createList.size());
        
        return createList.get(index).createTetramino(x, y);
    }
}
