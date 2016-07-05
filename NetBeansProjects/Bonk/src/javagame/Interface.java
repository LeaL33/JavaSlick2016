package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author lea
 */
public class Interface extends BasicGameState {
    
    class Button {
        Image image, imageActive;
        int x1, x2, y1, y2;
        boolean active = false;
        
        public Button(Image image, Image imageActive, int x1, int y1, int x2, int y2) {
            this.image = image;
            this.imageActive = imageActive;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        public boolean hover(int xpos, int ypos) {
            if (xpos > this.x1 && xpos < this.x2 && ypos > this.y1 && ypos < this.y2) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public Interface(int state) {
        
    }
    
    int state;
    
}
