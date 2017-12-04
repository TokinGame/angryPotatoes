package hu.tokingame.potatoeskill.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 11/9/2017.
 */

public class LevelSelectScreen extends MyScreen {
    private LevelSelectStage levelSelectStage;
    public LevelSelectScreen(MyGdxGame game) {
        super(game);
        levelSelectStage = new LevelSelectStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        levelSelectStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(levelSelectStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        levelSelectStage.act(delta);
        levelSelectStage.draw();
    }
}
