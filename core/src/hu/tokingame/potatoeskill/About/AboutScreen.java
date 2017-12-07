package hu.tokingame.potatoeskill.About;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Exit.ExitStage;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by zoltan on 11/9/2017.
 */

public class AboutScreen extends MyScreen {
    private AboutStage aboutStage;
    public AboutScreen(MyGdxGame game) {
        super(game);
        aboutStage = new AboutStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        aboutStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(aboutStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        aboutStage.act(delta);
        aboutStage.draw();
    }
}

