package graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SpriteSheet {
    private final int width; 
    private final int high; 
    public final int[] pixels;
    
    


    public int getWidth() {
        return width;
    }




    public SpriteSheet(final String route, final int width, final int high){
        this.width = width; 
        this.high = high; 
        pixels = new int[width*high];

        try {    
        BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(route)); 
        image.getRGB(0, 0, width, high, pixels, 0, width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
