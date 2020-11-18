package sim;

import java.awt.Color;
import java.awt.Graphics;

public class World {
    private final int SIZE = 600;
    private final Color bg = Color.GRAY;
    //declare array of Blobs
    private Blob[] blobs = new Blob[2000];
    
    public World() {
        for (int i = 0; i < blobs.length; i++) {
            blobs[i] = new Blob();
        }
    }
    
    public void draw(Graphics g) {
       
        //For each loop, enhanced for loop
        for (Blob blob : blobs) {
            if (blob.getHp() <= 0) continue;
            blob.move();
            blob.collideWorldBounds(this);
            for (Blob b2 : blobs) {
                 if (blob ==b2) continue;
                 //continue means ignore
                  if (b2.getHp() <= 0) continue;
                blob.collide(b2);
            }
            blob.draw(g);
        }
    }

    public int getSIZE() {
        return SIZE;
    }
    
}