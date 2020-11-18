package sim;

import java.awt.Color;
import java.awt.Graphics;

public class Blob {
    //fields
    private int x, y, vx, vy, hp;
    private final static int SIZE = 10, MAX_SPEED = 3;
    private final static Color COLOR = Color.RED;
    
    //constructors
    //overloaded
    public Blob(int x, int y) {
        this.hp = 100;
        this.x = x;
        this.y = y;
        this.vx = (int)((Math.random()*2*MAX_SPEED)-MAX_SPEED);
        this.vy = (int)((Math.random()*2*MAX_SPEED)-MAX_SPEED);
    }
    
    //no-args constructor
    public Blob() {
       this.x = (int)(Math.random()*600);
       this.y = (int)(Math.random()*600);
       this.vx = (int)((Math.random()*2*MAX_SPEED)-MAX_SPEED);
        this.vy = (int)((Math.random()*2*MAX_SPEED)-MAX_SPEED); 
    }
   
    //methods
    public void move() {
       x += vx;
       y += vy;
      
    }
    
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x,y,SIZE,SIZE);
    }
    
//getters and setters

    public void collideWorldBounds(World w) {
        if (x>w.getSIZE()|| x<0) {
            vx *= -1;
        }
       if (y>w.getSIZE() || y<0) {
           vy *= -1;
       }
    }
    
    public void collide(Blob other) {
        if (circleVsCircle(this, other)) {
            if (this.hp>other.hp) {
                other.hp--;
            }
            
            else if (this.hp<other.hp) {
                this.hp--;
            }
            else {
                this.hp--;
                other.hp--;
            }
            int tempvx = this.vx;
            int tempvy = this.vy;
            this.vx = other.vx;
            this.vy = other.vy;
            other.vx = tempvx;
            other.vy = tempvy;
            
        }
    }
    
    private boolean circleVsCircle(Blob b1, Blob b2) {
        if (dist(b1, b2)<Blob.SIZE) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private double dist(Blob b1, Blob b2) {
        return Math.sqrt(Math.pow(b2.x-b1.x,2)+Math.pow(b2.y-b1.y,2));
    }

    public int getHp() {
        return hp;
    }
    
    
    
}
