package hu.tokingame.potatoeskill.Options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by zoltan on 11/9/2017.
 */

public class OptionsScreen extends MyScreen {
    private OptionsStage optionsStage;
    public OptionsScreen(MyGdxGame game) {
        super(game);
        optionsStage = new OptionsStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        optionsStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(optionsStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        optionsStage.act(delta);
        optionsStage.draw();
    }
}