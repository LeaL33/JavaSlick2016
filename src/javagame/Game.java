package javagame;

import java.io.File;
import java.io.IOException;
import org.ini4j.Wini;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * 
 * @author lea & corentin
 */
public class Game extends StateBasedGame {
    
    public static final String GAMENAME = "BONK";
    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int INSTR = 2;
    public static final int CONFIG = 3;
    
    /**
     * 
     * @param gamename 
     */
    public Game(String gamename) {
        super(gamename);
        this.addState(new Menu(MENU));
        this.addState(new Play(PLAY));
        this.addState(new Instr(INSTR));
        this.addState(new Config(CONFIG));
    }
    
    
    
    
    /**
     * 
     * @param gc the game container
     * @throws SlickException 
     */
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(MENU).init(gc, this);
        this.getState(PLAY).init(gc, this);
        this.getState(INSTR).init(gc, this);
        this.getState(CONFIG).init(gc, this);
        this.enterState(MENU);
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        AppGameContainer appgc;
        Wini ini = new Wini(new File("settings.ini"));
        boolean fs = ini.get("Display", "fullscreen", boolean.class);
        try {
            appgc = new AppGameContainer(new Game(GAMENAME));
            appgc.setShowFPS(false);
            appgc.setDisplayMode(640, 480, fs);
            appgc.start();
        }
        catch(SlickException e) {
            e.printStackTrace();
        }
    }
    
}