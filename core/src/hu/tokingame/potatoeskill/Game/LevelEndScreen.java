package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by davim on 2017. 11. 30..
 */

public class LevelEndScreen extends MyScreen {

    private LevelEndStage levelEndStage;

    public LevelEndScreen(MyGdxGame game) {
        super(game);
        levelEndStage = new LevelEndStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        levelEndStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(levelEndStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        levelEndStage.draw();
    }
}
