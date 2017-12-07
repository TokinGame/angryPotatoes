package hu.tokingame.potatoeskill.Demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;
import hu.tokingame.potatoeskill.Options.OptionsStage;

/**
 * Created by zoltan on 11/9/2017.
 */

public class DemoScreen extends MyScreen {
    private DemoStage demoStage;
    public DemoScreen(MyGdxGame game) {
        super(game);
        demoStage = new DemoStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        demoStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(demoStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        demoStage.act(delta);
        demoStage.draw();
    }
}