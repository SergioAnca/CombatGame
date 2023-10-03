package window;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controls.Keyboard;

public class Practicewindow extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1l; 

    private static final int WIDTH = 600;
    private static final int HEIGHT = 800; 
    
    private static volatile Boolean working = false ;


    private static final String NAME = "Combat Game";

    private static int ups = 0; 
    private static int fps = 0; 

    private static JFrame window; 
    private static Thread thread;

    private static Keyboard keyboard; 





    private Practicewindow(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        window = new JFrame(NAME);  
        //window.setTitle(" not the name");  
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());

        window.add(this, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

    public static void main(String[] args){
        Practicewindow pw = new Practicewindow();
        pw.initialize();
        
    }

    private synchronized void initialize(){
        working = true;
        thread = new Thread(this, "Graf");
        thread.start();

    }
    private synchronized void stop(){
        working = false; 

        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void update(){
        keyboard.update();
        if(keyboard.up){
            System.out.println("up");
        }
        if(keyboard.down){
            System.out.println("down");
        }

        ups++;
    }
    private void shows(){
         fps++;

    }


    @Override
    public void run() {
        //F
        final int nspersecond = 1000000000;
        final byte ups_optim = 60; //updates per second
        final double nsperupdate = nspersecond/ups_optim; 
        long updateReference = System.nanoTime();
        long contReference =  System.nanoTime();
        double timeElapsed;
        double d = 0; 

        requestFocus(); //With this function the user dont need to click the window in order to use the keyboard

        while(working){    

            final long startWhile = System.nanoTime();      
            timeElapsed = startWhile-updateReference; 
            updateReference = startWhile; 
            d += timeElapsed/nsperupdate;
            while(d>=1){
                update();
                d--;
            }

            
            shows();

            if((System.nanoTime() - contReference)>nspersecond){
                window.setTitle(NAME +" fps: "+fps+" ups: "+ups);
                ups = 0; fps = 0; contReference = System.nanoTime();
            }

        }
        
    }
}
