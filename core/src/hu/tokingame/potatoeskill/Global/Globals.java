package hu.tokingame.potatoeskill.Global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by M on 11/9/2017.
 */

public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.°α₁₂²";
    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static final Preferences prefs = Gdx.app.getPreferences("main");

    public static boolean DEBUG_ALL = false;

    public static boolean soundFX = true, music = prefs.getBoolean("music",true), hard = prefs.getBoolean("hard",false);

    public static float windDirection = 0;

    public static int currentLevel = 1;

    public static boolean[] unlocked = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    public static Preferences getPrefs(){
        return prefs;
    }
}
