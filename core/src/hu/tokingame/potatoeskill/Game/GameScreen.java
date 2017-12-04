package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 11/9/2017.
 */

public class GameScreen extends MyScreen {
    private GameStage gameStage;
    public GameScreen(MyGdxGame game) {
        super(game);
        gameStage = new GameStage(new ExtendViewport(Globals.WORLD_WIDTH/10, Globals.WORLD_HEIGHT/10), spriteBatch, game);
        gameStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(gameStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        gameStage.dispose();
    }
}
