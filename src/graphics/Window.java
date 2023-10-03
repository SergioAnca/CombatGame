package graphics;

public class Window {
    private final int width; 
    private final int high; 
    private final int[] pixels; 

    public Window(final int width, final int high){
        this.width = width; 
        this.high = high; 
        pixels = new int[width*high];

    }

    public void cleanScreen(){
        for(int i = 0; i< pixels.length;i++){   //All the pixels in the screen become black
            pixels[i] = 0;                      

        }
    }
    public void shows(final int compX, final int compY){
        for(int j = 0; j<high; j++){                //Go through de y axis
            int posY = j+compY;
            if(posY<0||posY>=high){continue;}       //Limit the vertical pixels
            for(int i = 0; i<width; i++){           //Go throufg de x axis
                int posX = i+compX; 
                if(posX<0||posX>=width){continue;}       //Limit the vertical pixels
            }
            /*TO DO  */

        }

    }



}
