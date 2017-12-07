package hu.tokingame.potatoeskill.HowTo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Exit.ExitStage;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by zoltan on 11/9/2017.
 */

public class HowToScreen extends MyScreen {
    private HowToStage howToStage;
    public HowToScreen(MyGdxGame game) {
        super(game);
        howToStage = new HowToStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        howToStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(howToStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        howToStage.act(delta);
        howToStage.draw();
    }
}

