package controls;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private final static int keyNumber = 120; 
    private final boolean[] keys = new boolean[keyNumber];

    public boolean up; 
    public boolean down; 
    
    public void update(){
        up = keys[KeyEvent.VK_W]; 
        down = keys[KeyEvent.VK_S];
    }
   
    @Override
    public void keyPressed(KeyEvent e) {                    
        keys[e.getKeyCode()] = true; 
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false; 

        
    }
    

}
