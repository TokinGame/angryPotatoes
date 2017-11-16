package hu.tokingame.potatoeskill.Exit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by zoltan on 11/9/2017.
 */

public class ExitScreen extends MyScreen {
    private ExitStage exitStage;
    public ExitScreen(MyGdxGame game) {
        super(game);
        exitStage = new ExitStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        exitStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(exitStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        exitStage.act(delta);
        exitStage.draw();
    }
}

