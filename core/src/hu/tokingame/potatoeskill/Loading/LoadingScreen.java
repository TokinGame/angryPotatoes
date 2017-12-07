package hu.tokingame.potatoeskill.Loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

import static hu.tokingame.potatoeskill.Global.Globals.getPrefs;
import static hu.tokingame.potatoeskill.Global.Globals.unlocked;

/**
 * Created by M on 11/9/2017.
 */

public class LoadingScreen extends MyScreen {


    public LoadingScreen(MyGdxGame game) {
        super(game);
    }
    BitmapFont bitmapFont = new BitmapFont();

    @Override
    public void show() {
        Globals.soundFX = Globals.getPrefs().getBoolean("soundFX",true);
        Globals.music = Globals.getPrefs().getBoolean("music", true);
        Assets.manager.finishLoading();
        Assets.load();
        for (int i = 1; i < unlocked.length; i++) {
            unlocked[i] = getPrefs().getBoolean("l"+i,false);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        bitmapFont.draw(spriteBatch,"Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets()+ Assets.manager.getLoadedAssets()) + " (" + ((int)(Assets.manager.getProgress()*100f)) + "%)", Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        spriteBatch.end();
        if (Assets.manager.update()) {
            Assets.afterLoaded();
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void hide() {

    }

    @Override
    public void init() {
        setBackGroundColor(0f, 0f, 0f);
    }
}
