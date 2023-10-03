package graphics;

public class Sprite {
    private final int size; 
    private int x;
    private int y; 
    public int[] pixels;
    private final SpriteSheet sheet;

    public Sprite(final int size, final int colum, final int files, final SpriteSheet sheet){
        this.size = size; 
        pixels = new int[this.size*this.size];

        this.x = colum*size; 
        this.y = files*size;
        this.sheet = sheet;
        for(int j =0; j<size; j++){                                             //
            for(int i = 0; i<size; i++){
                pixels[i+j*size] = sheet.pixels[(this.x+i) + (this.y+j) * (sheet.getWidth())];

            }
         }

    }
    
}
