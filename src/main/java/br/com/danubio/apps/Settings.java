
package br.com.danubio.apps;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Settings {
    
    private static final int WIDTH = 16;
    private static final int HEIGHT = 22;
    private static final int X = 0;
    private static final int Y = 0;
    private static final Settings uniqueSettings = new Settings();
    
    private List<SettingObserver> observers;
    
    private int[] amountPixels = { 20, 22, 24, 26, 28, 30, 32, 34 };
    private int index;
    
    private Settings()
    {
        index = 3;
        observers = new ArrayList<SettingObserver>();
    }
    
    public int getX()
    {
        return X;
    }
    
    public int getY()
    {
        return Y;
    }
    
    public int getWidth()
    {
        return WIDTH;
    }
    
    public int getHeight()
    {
        return HEIGHT;
    }
    
    public int getAmountPixels()
    {
        return amountPixels[index];
    }
    
    public void zoomIn()
    {
        if (index < amountPixels.length-1) {
            index++;
            notifySettingObserve();
        }
    }
    
    public void zoomOut()
    {
        if (index > 0) {
            index--;
            notifySettingObserve();
        }
    }
    
    public static Settings getSettings()
    {
        return uniqueSettings;
    }
    
    public void addSettingObserver(SettingObserver observer)
    {
        observers.add(observer);
    }
    
    private void notifySettingObserve()
    {
        for (SettingObserver observer: observers) {
            observer.updateObserver();
        }
    }

}